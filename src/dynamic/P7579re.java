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
        boolean isChecked = false;
        for (int j = 1; j <= maxC &&!isChecked; j++) {

            for (int i = 1; i <= n; i++) {
                if (j < memory[1][i]) {
                    DP[i][j] = DP[i - 1][j];
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j] ,Math.max(memory[0][i], DP[i - 1][j - memory[1][i]] + memory[0][i]));
                }

                if (DP[i][j] >= m) {
                    System.out.println(j);
                    isChecked = true;
                    break;
                }
            }
        }

//        print(n,maxC);

    }

    public static void print(int n ,int maxC) {
        System.out.print("    ");
        for (int i = 1; i <= maxC; i++) {
            if (i < 10) {
                System.out.print("  " + i + " ");
            } else if (i < 100) {
                System.out.print(" " + i + " ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print(i + "   ");
            for (int j = 1; j <= maxC; j++) {
                if (DP[i][j] < 10) {
                    System.out.print("  " + DP[i][j] + " ");
                } else if (DP[i][j] < 100) {
                    System.out.print(" " + DP[i][j] + " ");
                } else {
                    System.out.print(DP[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
