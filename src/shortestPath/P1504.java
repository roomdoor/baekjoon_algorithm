package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1504 {
    public static ArrayList<Point>[] map;
    public static int[][] totalDistance;
    public static boolean[][] isVisited;
    public static int wayPoint1;
    public static int wayPoint2;
    public static int n;
    public static int INF = 200000000;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        isVisited = new boolean[5][n + 1];
        totalDistance = new int[5][n + 1];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < n + 1; j++) totalDistance[i][j] = INF;
        for (int i = 1; i <= n; i++) map[i] = new ArrayList<>();


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Point(b, c, 0, new ArrayList<>()));
            map[b].add(new Point(a, c, 0, new ArrayList<>()));
        }

        st = new StringTokenizer(bf.readLine());
        wayPoint1 = Integer.parseInt(st.nextToken());
        wayPoint2 = Integer.parseInt(st.nextToken());

        dijkstra();

        int answer = Math.min(totalDistance[3][n], totalDistance[4][n]);

        if (answer < INF) System.out.println(answer);
        else System.out.println(-1);
        System.out.println(Arrays.deepToString(totalDistance));
    }

    public static void dijkstra() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(1, 0, 0, new ArrayList<>()));
        totalDistance[0][1] = 0;

        int count = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int cur = point.y;
            int dis = point.distance;
            int wauPoint = point.wayPoint;
            ArrayList<Integer> wayPointOrder = point.wayPointOrder;

            if (cur == wayPoint1) { // wayPoint1 왔을떄 체크
                if (!wayPointOrder.isEmpty() && wayPointOrder.get(0) == 2) {
                    totalDistance[4][cur] = totalDistance[2][cur];
                    wauPoint = 3;
                }
                else {
                    totalDistance[1][cur] = totalDistance[0][cur];
                    wauPoint = 1;
                }
                wayPointOrder.add(1);
            }

            if (cur == wayPoint2) { // wayPoint2 왔을떄 체크
                if (!wayPointOrder.isEmpty() && wayPointOrder.get(0) == 1) {
                    totalDistance[3][cur] = totalDistance[1][cur];
                    wauPoint = 3;
                }
                else {
                    totalDistance[2][cur] = totalDistance[0][cur];
                    wauPoint = 1;
                };
                wayPointOrder.add(2);
            }

            if (cur == n && wauPoint == 3) {
                count += 1;  // v1 -> v2 -> n and v2 -> v1 -> n
                if (count >= 2) return;
            } // wayPoint1, wayPoint2 다 거쳐서 n 왔을때


            switch (wauPoint) { // wayPoint 0(하나도 안거침), 1(1 or 2만거침), 3(둘다 거침)

                case 0:
                    if (!isVisited[0][cur]) {
                        isVisited[0][cur] = true;
                        for (int i = 0; i < map[cur].size(); i++) {
                            int distance = Math.min(dis + map[cur].get(i).distance, totalDistance[0][map[cur].get(i).y]);
                            if (distance < totalDistance[0][map[cur].get(i).y]) {
                                totalDistance[0][map[cur].get(i).y] = distance;
                                queue.add(new Point(map[cur].get(i).y, distance, wauPoint, wayPointOrder));
                            }
                        }
                        break;
                    }

                case 1:
                    if (wayPointOrder.get(0) == 1) {
                        if (!isVisited[1][cur]) {
                            isVisited[1][cur] = true;
                            for (int i = 0; i < map[cur].size(); i++) {
                                int distance = Math.min(dis + map[cur].get(i).distance, totalDistance[1][map[cur].get(i).y]);
                                if (distance < totalDistance[1][map[cur].get(i).y]) {
                                    totalDistance[1][map[cur].get(i).y] = distance;
                                    queue.add(new Point(map[cur].get(i).y, distance, wauPoint, wayPointOrder));
                                }
                            }
                        }
                        break;
                    }

                    if (wayPointOrder.get(0) == 2) {
                        if (!isVisited[2][cur]) {
                            isVisited[2][cur] = true;
                            for (int i = 0; i < map[cur].size(); i++) {
                                int distance = Math.min(dis + map[cur].get(i).distance, totalDistance[2][map[cur].get(i).y]);
                                if (distance < totalDistance[2][map[cur].get(i).y]) {
                                    totalDistance[2][map[cur].get(i).y] = distance;
                                    queue.add(new Point(map[cur].get(i).y, distance, wauPoint, wayPointOrder));
                                }
                            }
                        }
                        break;
                    }

                case 3:
                    if (!isVisited[3][cur] && cur != n && wayPointOrder.get(0) == 1) {
                        isVisited[3][cur] = true;
                        for (int i = 0; i < map[cur].size(); i++) {
                            int distance = Math.min(dis + map[cur].get(i).distance, totalDistance[3][map[cur].get(i).y]);
                            if (distance < totalDistance[3][map[cur].get(i).y]) {
                                totalDistance[3][map[cur].get(i).y] = distance;
                                queue.add(new Point(map[cur].get(i).y, distance, wauPoint, wayPointOrder));
                            }
                        }
                        break;
                    }

                    if (!isVisited[4][cur] && cur != n && wayPointOrder.get(0) == 2) {
                        isVisited[4][cur] = true;
                        for (int i = 0; i < map[cur].size(); i++) {
                            int distance = Math.min(dis + map[cur].get(i).distance, totalDistance[4][map[cur].get(i).y]);
                            if (distance < totalDistance[4][map[cur].get(i).y]) {
                                totalDistance[4][map[cur].get(i).y] = distance;
                                queue.add(new Point(map[cur].get(i).y, distance, wauPoint, wayPointOrder));
                            }
                        }
                        break;
                    }

            }
        }
    }


    private static class Point implements Comparable<Point> {
        int y, distance;
        int wayPoint;
        ArrayList<Integer> wayPointOrder;


        public Point(int y, int distance, int wayPoint, ArrayList<Integer> wayPointOrder) {
            this.y = y;
            this.distance = distance;
            this.wayPoint = wayPoint;
            this.wayPointOrder = wayPointOrder;
        }

        @Override
        public int compareTo(Point o) {
            return distance - o.distance;
        }
    }
}
// 6 [[200000000, 0, 3, 5, 4], [200000000, 6, 9, 6, 8], [200000000, 200000000, 200000000, 200000000, 200000000], [200000000, 10, 8, 15, 6], [200000000, 200000000, 200000000, 200000000, 200000000]]

// 7 [[200000000, 0, 3, 5, 4], [200000000, 6, 9, 6, 8], [200000000, 200000000, 200000000, 200000000, 200000000], [200000000, 11, 9, 16, 7], [200000000, 200000000, 200000000, 200000000, 200000000]]
