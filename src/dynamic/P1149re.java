package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149re {

    public static int[][] arr;
    public static Integer[][] min;

    public static int DP(int depth, int idx) {

        if (min[depth][idx] == null) {
            if (idx == 0) {
                min[depth][idx] = arr[depth][idx] + Math.min(DP(depth - 1, 1), DP(depth - 1, 2));
            }

            else if (idx == 1) {
                min[depth][idx] = arr[depth][idx] + Math.min(DP(depth - 1, 0), DP(depth - 1, 2));
            }

            else {
                min[depth][idx] = arr[depth][idx] + Math.min(DP(depth - 1, 0), DP(depth - 1, 1));
            }
        }

        return min[depth][idx];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        arr = new int[n][3];
        min = new Integer[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }


        min[0][0] = arr[0][0];
        min[0][1] = arr[0][1];
        min[0][2] = arr[0][2];

        System.out.println(Math.min(DP(n - 1, 0), Math.min(DP(n - 1, 1), DP(n - 1, 2))));

    }
}

