package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int x = Integer.parseInt(bf.readLine());
        System.out.println(twoPointer(arr, x));

    }

    public static int twoPointer(int[] arr, int x) {
        int count = 0;
        int p1 = 0;
        int p2 = arr.length - 1;
        while (p1 < p2) {

            int sum = arr[p1] + arr[p2];

            if (sum == x) {
                count++;
                p1++;
                p2--;
            }
            if (sum < x) {
                p1++;
            }
            if (sum > x) {
                p2--;
            }

        }
        return count;
    }
}
