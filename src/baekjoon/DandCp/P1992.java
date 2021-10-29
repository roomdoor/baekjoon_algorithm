package DandCp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1992 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        DP(n, 0, 0);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
//
//((110(0101))(0010)1(0001))
//((110(0101))(0010)1(0001))
//        (0(0011)(0(0111)01)1)
//        (0(0011)(0(0111)01)1)
        System.out.println(sb.toString());
    }

    public static StringBuilder sb = new StringBuilder();
    public static int[][] arr;


    public static void DP(int dp, int x, int y) {
        if (isChecked(x, y, dp)) {
            sb.append(arr[x][y]);
            return;
        }

        int newDP = dp / 2;
        sb.append('(');
        DP(newDP, x, y);
        DP(newDP, x, y + newDP);
        DP(newDP, x + newDP, y);
        DP(newDP, x + newDP, y + newDP);
        sb.append(')');
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
