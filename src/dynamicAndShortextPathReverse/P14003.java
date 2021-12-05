package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14003 {
    public static int[] arr;
    public static int[] trace;
    public static ArrayList<Integer> BSList;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        trace = new int[n];
        BSList = new ArrayList<>();
        BSList.add(Integer.MIN_VALUE);

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            int num = arr[i];
            int start = 1;
            int end = BSList.size() - 1;

            if (num > BSList.get(end)) {
                BSList.add(num);
                trace[i] = end;
            } else {
                BSList.set(BS(start, end, num), num);
                trace[i] = end;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(BSList.size() - 1).append("\n");

        for (int i = 1; i < BSList.size(); i++) {
            sb.append(BSList.get(i)).append(" ");
        }

        System.out.println(sb.toString());
        System.out.println(Arrays.toString(trace));
    }

    public static int BS(int start, int end, int key) {
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;

            if (key <= BSList.get(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }
}
