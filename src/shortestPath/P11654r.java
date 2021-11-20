package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11654r {
    public static ArrayList<ArrayList<Point>> map;
    public static long[] totalDistance;
    public static int INF = 987654321;
    public static StringBuilder sb = new StringBuilder();
    public static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        totalDistance = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
            totalDistance[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            map.get(i).add(new Point(end, distance));
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
        boolean isUpdate = false;

        for (int i = 1; i < n; i++) {
            isUpdate = false;
            for (int j = 1; j <= n; j++) {
                for (Point point : map.get(j)) {
                    if (totalDistance[j] != INF && point.distance + totalDistance[j] < totalDistance[point.y]) {
                        totalDistance[point.y] = point.distance + totalDistance[j];
                        isUpdate = true;
                    }
                }
            }
            if (!isUpdate) break;
        }

        if (isUpdate) {
            for (int j = 1; j <= n; j++) {
                for (Point point : map.get(j)) {
                    if (totalDistance[j] != INF && point.distance + totalDistance[j] < totalDistance[point.y]) {
                        sb.append(-1);
                        isPossible = true;
                        return;
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
