package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2156re {

    public static int[] arr;
    public static Integer[] DP;


    public static int dp(int depth) {

        if (DP[depth] == null) {

            DP[depth] = Math.max(dp(depth - 2), dp(depth - 3) + arr[depth - 1]) + arr[depth];
        }

        return DP[depth];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        arr = new int[n + 1];
        DP = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        DP[0] = 0;
        DP[1] = arr[1];
        DP[2] = arr[1] + arr[2];

        for (int i = 0; i <= n; i++) {

            System.out.println(dp(i));
        }

    }
}
