package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463 {

    public static int n;
    public static int[] dp;

    public static int minCount(int n) {
        if (n == 1)
            return dp[n];
        if (dp[n] == 0) {
            if (n % 6 == 0) {
                dp[n] = Math.min(minCount(n - 1), Math.min(minCount(n / 2), minCount(n / 3))) + 1;

            } else if (n % 3 == 0) {
                dp[n] = Math.min(minCount(n / 3), minCount(n - 1)) + 1;

            } else if (n % 2 == 0) {
                dp[n] = Math.min(minCount(n / 2), minCount(n - 1)) + 1;

            } else
                dp[n] = minCount(n - 1) + 1;
        }

        return dp[n];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        dp = new int[n + 1];

        System.out.println(minCount(n));

    }
}
