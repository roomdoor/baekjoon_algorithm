package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11657re {
    public static List<List<Node>> map;
    public static long[] DP;
    public static long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        DP = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
            DP[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            map.get(start).add(new Node(end, time));
        }

        StringBuilder sb = new StringBuilder();
        if (BMFD(n)) {
            for (int i = 2; i <= n; i++) {
                if (DP[i] == INF) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(DP[i]).append("\n");
                }
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb.toString());
    }

    public static boolean BMFD(int n) {
        DP[1] = 0;
        boolean isChecked = false;
        for (int k = 0; k < n - 1; k++) {
            isChecked = false;
            for (int i = 1; i <= n; i++) {
                for (Node next : map.get(i)) {
                    if (DP[i] == INF) break;
                    if (DP[next.end] > DP[i] + next.time) {
                        DP[next.end] = DP[i] + next.time;
                        isChecked = true;
                    }
                }
            }
            if (!isChecked) break;
        }

        if (isChecked) {
            for (int i = 1; i <= n; i++) {
                for (Node next : map.get(i)) {
                    if (DP[i] == INF) break;
                    if (DP[next.end] > DP[i] + next.time) {
                        DP[next.end] = DP[i] + next.time;
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean BMFChecked(int n) {
        boolean isChecked = true;
        for (int i = 1; i <= n; i++) {
            for (Node next : map.get(i)) {
                if (DP[i] < INF && DP[next.end] > DP[i] + next.time) {
                    DP[next.end] = DP[i] + next.time;
                    isChecked = false;
                }
            }
        }

        return isChecked;
    }

    private static class Node {
        int end;
        int time;

        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }
}
