package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(BS(Long.parseLong(st.nextToken()), 0, n - 1)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static long[] arr;

    public static int BS(long key, int left, int right) {
        while (left <= right) {

            int mid = (left + right) / 2;

            if (key < arr[mid]) right = mid - 1;

            else if (key > arr[mid]) left = mid + 1;

            else return 1;
        }

        return 0;
    }
}
