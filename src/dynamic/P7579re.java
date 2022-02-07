package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7579re {
    public static int[][] memory;
    public static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        memory = new int[2][n + 1];

        int maxM = 0;
        int maxC = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            memory[0][i] = Integer.parseInt(st.nextToken());
            maxM += memory[0][i];
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            memory[1][i] = Integer.parseInt(st.nextToken());
            maxC += memory[1][i];
        }

        DP = new int[n + 1][maxC + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxC; j++) {
                if (j < memory[1][i]) {
                    DP[i][j] = DP[i - 1][j];
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i - 1][j - memory[1][j]] + memory[0][j]);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxC ; j++) {
                System.out.print(DP[i][j] + " ");
            }
            System.out.println();
        }
    }
}
