package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10844re {
    public static int[][] DP;
    public static final int num = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        DP = new int[n][10];
        for (int i = 1; i < 10; i++) {
            DP[0][i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    DP[i + 1][j + 1] += DP[i][j] % num ;
                } else if (j == 9) {
                    DP[i + 1][j - 1] += DP[i][j] % num;
                } else {
                    DP[i + 1][j - 1] += DP[i][j] % num;
                    DP[i + 1][j + 1] += DP[i][j] % num;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += DP[n - 1][i] % num;
            answer %= num;
        }

        System.out.println(answer % num);
    }
}