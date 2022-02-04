package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2293 {
    public static int[] coin;
    public static boolean[][] coinSum;
    public static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        coin = new int[n];
        coinSum = new boolean[n + 1][k + 1];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(bf.readLine());
        }

        dfs(0, k, n, 0);


        System.out.println(count);
    }

    public static void dfs(int value, int k, int n, int next) {
        if (value > k) return;
        if (value == k) {
            count++;
            return;
        }

        for (int i = next; i < n; i++) {
            dfs( value + coin[i], k, n, i);

        }
    }
}
