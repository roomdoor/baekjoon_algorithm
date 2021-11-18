package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11654 {
    public static ArrayList<Point>[] map;
    public static long[] totalDistance;
    public static int INF = Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();
    public static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        totalDistance = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
            totalDistance[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            map[start].add(new Point(end, distance));
        }

        bmfd(n);
        if (!isPossible) {
            for (int i = 2; i <= n; i++) {
                if (totalDistance[i] == INF) sb.append(-1).append("\n");
                else sb.append(totalDistance[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void bmfd(int n) {
        totalDistance[1] = 0;
        boolean isChanged = false;
        for (int c = 0; c < n - 1; c++) {
            isChanged = false;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < map[i].size(); j++) {
                    int nextPoint = map[i].get(j).y;
                    int distance = map[i].get(j).distance;

                    if (totalDistance[i] != INF && totalDistance[i] + distance < totalDistance[nextPoint]) {
                        totalDistance[nextPoint] = totalDistance[i] + distance;
                        isChanged = true;
                    }
                }
            }
            if (!isChanged) break;
        }

        if (isChanged) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < map[i].size(); j++) {
                    int nextPoint = map[i].get(j).y;
                    int distance = map[i].get(j).distance;

                    if (totalDistance[i] != INF && totalDistance[i] + distance < totalDistance[nextPoint]) {
                        sb.append(-1);
                        isPossible = true;
                    }
                }
            }
        }
    }

    private static class Point {
        int y, distance;

        public Point(int y, int distance) {
            this.y = y;
            this.distance = distance;
        }
    }
}
