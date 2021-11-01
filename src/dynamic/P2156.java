package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2156 {


    public static int[] arr;
    public static Integer[] arrMax;

    public static int DP(int n) {

        if (arrMax[n] == null) {
            arrMax[n] = Math.max(Math.max(DP(n - 2), DP(n - 3) + arr[n - 1]) + arr[n], DP(n - 1));
        }

        return arrMax[n];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        arr = new int[n + 1];
        arrMax = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        arrMax[0] = 0;
        arrMax[1] = arr[1];

        if (n > 1) {
            arrMax[2] = arr[1] + arr[2];
        }

        System.out.println(DP(n));

    }
}
