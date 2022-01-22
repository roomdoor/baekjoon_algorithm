package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11066re {
    public static int[][] DP;
    public static int[] cost;
    public static int[] sum;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(bf.readLine());
            DP = new int[k + 1][k + 1];
            for (int j = 0; j < k; j++) {
                Arrays.fill(DP[j], INF);
            }
            cost = new int[k + 1];
            sum = new int[k + 1];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j < k + 1; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
                sum[j] += sum[j - 1] + cost[j];
            }

            int answer = pageSum(1, k);
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int pageSum(int a, int b) {
        int answer = 0;
        if (a == b) {
            return 0;
        }

        if (a + 1 == b) {
            return cost[a] + cost[b];
        }

        if (DP[a][b] != INF) {
            return DP[a][b];
        }

        for (int mid = a; mid < b; mid++) {
            DP[a][b] = Math.min(DP[a][b], pageSum(a, mid) + pageSum(mid + 1, b) + sum[b] - sum[a - 1]);
        }
        return DP[a][b];
    }
}
