package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579re {
    public static int[] stairs;
    public static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        stairs = new int[n];
        DP = new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(bf.readLine());
        }

        DP[0] = stairs[0];
        if (n > 1) {
            DP[1] = stairs[0] + stairs[1];
        }
        if (n > 2) {
            DP[2] = Math.max(DP[0] + stairs[2], stairs[1] + stairs[2]);
        }

        for (int i = 3; i < n; i++) {
            DP[i] = Math.max(DP[i - 3] + stairs[i - 1], DP[i - 2]) + stairs[i];
        }

        System.out.println(DP[n - 1]);

    }
}
