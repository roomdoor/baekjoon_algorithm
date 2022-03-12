package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1463re {
    public static int[] DP = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        Arrays.fill(DP, Integer.MAX_VALUE);
        makeOne(n, 0);
        if (n == 1) {
            DP[1] = 0;
        }
        System.out.println(DP[1]);
    }

    public static void makeOne(int n, int count) {
        if (n == 1) {
            return;
        }

        if (n % 3 == 0 & DP[n / 3] > count + 1) {
            DP[n / 3] = count + 1;
            makeOne(n / 3, count + 1);
        }

        if (n % 2 == 0 & DP[n / 2] > count + 1) {
            DP[n / 2] = count + 1;
            makeOne(n / 2, count + 1);
        }

        if (DP[n - 1] > count + 1) {
            DP[n - 1] = count + 1;
            makeOne(n - 1, count + 1);
        }
    }
}
