package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11780 {
    public static long[][] TC;
    public static Trace[][] trace;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        TC = new long[n + 1][n + 1];
        trace = new Trace[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(trace[i], new Trace(0, ""));
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                TC[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            TC[start][end] = Math.min(TC[start][end], cost);
            trace[start][end] = new Trace(2, "");
        }

        FW(n);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (TC[i][j] == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(TC[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (trace[i][j].count == 0) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(trace[i][j].count).append(" ").
                            append(i).
                            append(trace[i][j].trace).append(" ").
                            append(j).append("\n");
                }
            }
        }
        System.out.println(sb.toString());

    }

    public static void FW(int city) {
        for (int i = 1; i <= city; i++) {
            for (int j = 1; j <= city; j++) {
                if (i == j) continue;
                for (int k = 1; k <= city; k++) {
                    if (i == k || j == k) continue;
                    if (TC[j][k] > TC[j][i] + TC[i][k]) {
                        TC[j][k] = TC[j][i] + TC[i][k];
                        trace[j][k] = new Trace(trace[j][i].count + trace[i][k].count - 1,
                                trace[j][i].trace + " " + i + trace[i][k].trace);
                    }
                }
            }
        }
    }

    private static class Trace {
        int count;
        String trace;

        public Trace(int count, String trace) {
            this.count = count;
            this.trace = trace;
        }
    }
}