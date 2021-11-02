package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P12015 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int num : arr) {
            if (num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int min = 0;
                int max = list.size() - 1;

                while (min < max) {
                    int mid = (min + max) / 2;
                    if (list.get(mid) < num) {
                        min = mid + 1;
                    } else {
                        max = mid;
                    }
                }
                list.set(max, num);
            }
        }
        System.out.println(list.size() - 1);
    }

}
