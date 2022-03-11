package recrusion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2447re {
    public static StringBuilder sb = new StringBuilder();
    public static int[] dx = {0, 0, 0, 1, 1, 1, 2, 2, 2};
    public static int[] dy = {0, 1, 2, 0, 1, 2, 0, 1, 2};
    public static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        map = new String[n][n];


        makeStar(n, 0, 0, 0);

        print(n);
        System.out.println(sb.toString());
    }

    public static void makeStar(int n, int x, int y, int empty) {
        if (empty == 4) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    map[i][j] = " ";
                }
            }
            return;
        }

        if (n == 1) {
            map[x][y] = "*";
            return;
        }

        int newN = n / 3;
        for (int i = 0; i < 9; i++) {
            makeStar(newN, x + dx[i] * newN, y + dy[i] * newN, i);
        }
    }

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
    }
}
