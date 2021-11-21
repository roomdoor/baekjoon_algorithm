package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11654 {
    public static ArrayList<Point>[] map;
    public static long[] totalDistance;
    public static int INF = 987654321;
    public static StringBuilder sb = new StringBuilder();
    public static boolean isPossible = false;

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
        } else sb.append(-1).append("\n");

        System.out.println(sb.toString());
    }

    public static void bmfd(int n) {
        totalDistance[1] = 0;
        boolean isChanged = false;          // 밸만 포드 수행했을때 totalDistance 가 update 되었는지 확인

        for (int c = 1; c < n; c++) {       // 벨만 포드 정점 갯수 n 만큼 수행한다.
            isChanged = false;
            for (int i = 1; i <= n; i++) {  // 1번 점부터 n번 점까지 실행
                for (int j = 0; j < map[i].size(); j++) {
                    int nextPoint = map[i].get(j).y; // i 번 점에서 갈수있는 점
                    int distance = map[i].get(j).distance; // i 번 점에서 nextPoint 로 가는데 걸리는 가중치

                    if (totalDistance[i] == INF) {
                        break;
                    }

                    if (totalDistance[i] + distance < totalDistance[nextPoint]) {
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

                    if (totalDistance[i] == INF) {
                        break;
                    }

                    if (totalDistance[i] + distance < totalDistance[nextPoint]) {
                        isPossible = true;
                        return;
                    }
                }
            }
        }
    }

    private static class Point {
        int y;
        int distance;

        public Point(int y, int distance) {
            this.y = y;
            this.distance = distance;
        }
    }
}
