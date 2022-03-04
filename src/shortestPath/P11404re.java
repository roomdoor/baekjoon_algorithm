package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11404re {
    public static int[][] TD;
    public static ArrayList<ArrayList<Node>> map;
    public static int INF = 1000000000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        TD = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    TD[i][j] = INF;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map.get(a).add(new Node(b, c));
            TD[a][b] = Math.min(TD[a][b], c);
        }

        FW(n);

        print(n);

    }

    public static void FW(int n) {

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k) continue;
                for (int j = 1; j <= n; j++) {
                    if (k == j || i == j) continue;
                    TD[i][j] = Math.min(TD[i][j], TD[i][k] + TD[k][j]);
                }
            }
        }
    }

    public static void print(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (TD[i][j] != INF) {
                    sb.append(TD[i][j]).append(" ");
                } else {
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static class Node {
        int end;
        int distance;

        public Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }
}