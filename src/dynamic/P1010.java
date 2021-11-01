package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010 {
    public static int[][] bc = new int[30][30];

    public static int BC(int n, int m) {
        if (n == m || m <= 0 || n <= 0) {
            return 1;
        }

        if (bc[n][m] != 0) {
            return bc[n][m];
        }

        return bc[n][m] = BC(n - 1, m - 1) + BC(n, m - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int leftPoint = Integer.parseInt(st.nextToken());
            int rightPoint = Integer.parseInt(st.nextToken());

            sb.append(BC(leftPoint, rightPoint)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
