package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12365 {

    public static int[][] arr;
    public static Integer[][] DP;

    public static int dp(int depth) {

        if (DP[depth][0] == null) {

            DP[depth][1] = Math.max(dp(depth - 1), dp(depth - 1) + arr[depth][1]);


        }

        return DP[depth][1];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        DP = new Integer[n][2];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
