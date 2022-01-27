package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10942re {
    public static int[] map;
    public static boolean[][] DP;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        map = new int[n + 1];
        DP = new boolean[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        palindrome(n);

        int m = Integer.parseInt(bf.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            print(a,b);
        }

        System.out.println(sb.toString());

    }

    public static void palindrome(int n) {
        for (int i = 1; i <= n; i++) {
            DP[i][i] = true;
        }

        for (int i = 1; i < n; i++) {
            if (map[i] == map[i + 1]) {
                DP[i][i + 1] = true;
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (map[j] == map[j + i] && DP[j + 1][i + j - 1]) {
                    DP[j][i + j] = true;
                }
            }
        }
    }

    public static void print(int a, int b) {
        if (DP[a][b]) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }


}
