package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10816 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(BSR(key, 0, n, arr) - BSL(key, 0, n, arr)).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int BSL(int key, int left, int right, int[] arr) {


        while (left < right) {

            int mid = (left + right) / 2;

            if (key <= arr[mid])
                right = mid;

            else
                left = mid + 1;
        }

        return left;
    }

    public static int BSR(int key, int left, int right, int[] arr) {


        while (left < right) {
            int mid = (left + right) / 2;

            if (key < arr[mid])
                right = mid;

            else
                left = mid + 1;
        }

        return left;
    }
}
