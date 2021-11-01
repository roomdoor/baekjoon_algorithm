package DandCp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DP(n, n, 0, 0);
        System.out.println(white);
        System.out.println(blue);

    }

    public static int[][] arr;
    public static int white = 0;
    public static int blue = 0;


    public static void DP(int n, int dp, int x, int y) {
        if (isChecked(x, y, dp)) {
            if (arr[x][y] == 0) white++;
            else blue++;
            return;
        }

        int newDP = dp / 2;
        DP(n, newDP, x, y);
        DP(n, newDP, x + newDP, y);
        DP(n, newDP, x, y + newDP);
        DP(n, newDP, x + newDP, y + newDP);

    }

    public static boolean isChecked(int x, int y, int dp) {
        int color = arr[x][y];
        for (int i = x; i < x + dp; i++) {
            for (int j = y; j < y + dp; j++) {
                if (color != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
