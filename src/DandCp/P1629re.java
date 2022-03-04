package DandCp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1629re {
    public static int[][] xy = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    public static int[][] map;
    public static int white = 0;
    public static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DP(n, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void DP(int n, int x, int y) {
        int check = isSame(x, y, n);
        if (check == 1) {
            blue++;
        } else if (check == 0) {
            white++;
        } else {
            for (int i = 0; i < 4; i++) {
                DP(n / 2, x + xy[i][0] * n / 2, y + xy[i][1] * n / 2);
            }
        }
    }


    public static int isSame(int x, int y, int len) {
        int before = map[x][y];
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (map[i][j] == before) {
                    before = map[i][j];
                } else {
                    return -1;
                }
            }
        }
        return before;
    }
}
