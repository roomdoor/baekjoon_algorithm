package DandCp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10830 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        matrix1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                matrix1[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        matrixAnswer = matrixCal(B, matrix1);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrixAnswer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int n;
    public static long B;
    public static int[][] matrix1;
    public static int[][] matrixAnswer;

    public static int[][] matrixCal(long B, int[][] temp) {

        if (B == 1L) {
            return temp;
        }

        int[][] result = matrixCal(B / 2, temp);


        result = multi(result, result);

        if (B % 2 == 1) {
            result = multi(result, temp);
        }

        return result;
    }


    public static int[][] multi(int[][] m1, int[][] m2) {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    temp[i][j] += m1[i][k] * m2[k][j];
                    temp[i][j] %= 1000;
                }
            }
        }

        return temp;
    }
}
