package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11404 {
    public static long[][] totalCost;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.parseInt(bf.readLine());
        int bus = Integer.parseInt(bf.readLine());

        totalCost = new long[city][city];
        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                if (i == j) continue;
                totalCost[i][j] = INF;
            }
        }

        for (int i = 0; i < bus; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            totalCost[start][end] = Math.min(totalCost[start][end], cost);
        }

        FW(city);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                if (totalCost[i][j] >= INF) {
                    sb.append("0").append(" ");
                } else {
                    sb.append(totalCost[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    public static void FW(int city) {
        for (int k = 0; k < city; k++) {
            for (int i = 0; i < city; i++) {
                if (i == k) continue;
                for (int j = 0; j < city; j++) {
                    if (j == k || j == i) continue;
                    totalCost[i][j] = Math.min(totalCost[i][j], totalCost[i][k] + totalCost[k][j]);
                }
            }
        }
    }
}