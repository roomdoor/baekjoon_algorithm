package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889 {

    public static int[][] Sij;
    public static boolean[] isChecked;
    public static int score = 0;
    public static int min = 100000000;


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(bf.readLine());
        Sij = new int[n][n];
        isChecked = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                Sij[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calScore(0, n, 0);
        System.out.println(min);
    }


    public static void calScore(int depth, int n, int temp) {

        if (depth == n / 2) {

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (i != j) {
                        if (isChecked[i] && isChecked[j]) {
                            score += Sij[i][j] + Sij[j][i];
                        }

                        if (!isChecked[i] && !isChecked[j]) {
                            score -= Sij[i][j] + Sij[j][i];
                        }
                    }
                }
            }

            min = Math.min(Math.abs(score), Math.abs(min));
            score = 0;
            return;
        }

        for (int i = temp; i < n; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                temp = i;
                calScore(depth + 1, n, temp);
                isChecked[i] = false;
            }
        }
    }
}

