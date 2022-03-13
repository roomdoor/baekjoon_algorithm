package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12865re {
    public static int[][] items;
    public static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        DP = new int[N + 1][K + 1];
        items = new int[2][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            items[0][i] = Integer.parseInt(st.nextToken());
            items[1][i] = Integer.parseInt(st.nextToken());
        }
        makeItemsCombination(N, K);

        System.out.println(DP[N][K]);
    }

    public static void makeItemsCombination(int N, int K) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (items[0][i] <= j) {
                    if (j - items[0][i] > 0) {
                        DP[i][j] = Math.max(items[1][i] + DP[i - 1][j - items[0][i]], DP[i - 1][j]);
                    } else {
                        DP[i][j] = Math.max(items[1][i], DP[i - 1][j]);
                    }
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }
    }
}
