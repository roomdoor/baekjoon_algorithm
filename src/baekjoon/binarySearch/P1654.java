package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(bf.readLine());
        }
        Arrays.sort(arr);


        System.out.println(BS(k, 1, arr[n - 1] + 1, arr) - 1);
    }

    public static long BS(int k, long left, long right, long[] arr) {

        while (left < right) {
            long mid = (left + right) / 2;

            if (check(k, mid, arr)) left = mid + 1;

            else right = mid;
        }
        return left;
    }

    public static boolean check(int k, long num, long[] arr) {
        int sum = 0;
        for (long l : arr) {
            sum += l / num;
        }
        return sum >= k;
    }
}
