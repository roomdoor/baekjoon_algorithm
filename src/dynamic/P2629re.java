package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2629re {
    public static int[] w;
    public static boolean[][] isChecked;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = STI(bf.readLine());
        w = new int[n];
        isChecked = new boolean[n + 1][40001];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            w[i] = STI(st.nextToken());
        }

        dfs(0, 0, n);


        int marble = STI(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < marble; i++) {
            int m = STI(st.nextToken());

            if (isChecked[n][m]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }

        }

        System.out.println(sb.toString());
    }

    public static void dfs(int MNum, int weight, int n) {
        if (isChecked[MNum][weight]) return;
        isChecked[MNum][weight] = true;

        if (MNum == n) return;

        dfs(MNum + 1, weight + w[MNum], n);
        dfs(MNum + 1, weight, n);
        dfs(MNum + 1, Math.abs(weight - w[MNum]), n);
    }


    public static int STI(String s) {
        return Integer.parseInt(s);
    }
}
