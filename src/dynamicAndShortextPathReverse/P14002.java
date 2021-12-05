package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14002 {

    public static int[] arr;
    public static Integer[] DP;
    public static Integer[] trace;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[n];
        trace = new Integer[n];
        DP = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n -1; i >= 0; i--) {
            count(i);
        }

        int count = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (count < DP[i]) {
                count = DP[i];
                index = i;
            }
        }

        System.out.println(count);

//        System.out.println(Arrays.toString(DP));
//        System.out.println(Arrays.toString(trace));
//        System.out.println(index);

        StringBuilder sb = new StringBuilder();
        sb.append(arr[index]).append(" ");
        while (trace[index] != null) {
            index = trace[index];
            sb.append(arr[index]).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static void count(int n) {
        if (DP[n] == null) {
            DP[n] = 1;
        }

        for (int i = n + 1; i < arr.length; i++) {
            if (arr[i] > arr[n] && DP[n] < DP[i] + 1) {
                DP[n] = DP[i] + 1;
                trace[n] = i;
            }
        }
    }
}
