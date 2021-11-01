package DandCp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2740 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());

        int[][] matrix1 = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m1; j++) {
                matrix1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine());
        int n2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());

        int[][] matrix2 = new int[n2][m2];
        for (int i = 0; i < n2; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m2; j++) {
                matrix2[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int[][] matrixAnswer = new int[n1][m2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < m1; k++) {
                    matrixAnswer[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                sb.append(matrixAnswer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
