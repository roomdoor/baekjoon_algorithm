package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1504 {
    public static ArrayList<Point>[] map;
    public static int[][] totalDistance;
    public static int[][] isVisited;
    public static int wayPoint1;
    public static int wayPoint2;
    public static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        isVisited = new int[4][n + 1];
        totalDistance = new int[4][n + 1];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < n + 1; j++) totalDistance[i][j] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) map[i] = new ArrayList<>();

        totalDistance[0][1] = 0;
        totalDistance[1][1] = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Point(b, c, 0, 0, 0));
            map[b].add(new Point(a, c, 0, 0, 0));
        }

        st = new StringTokenizer(bf.readLine());
        wayPoint1 = Integer.parseInt(st.nextToken());
        wayPoint2 = Integer.parseInt(st.nextToken());

        bfs();

        if (totalDistance[3][n] != Integer.MAX_VALUE) System.out.println(totalDistance[3][n]);
        else System.out.println(-1);
    }

    public static void bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(1, 0, 0, 0, 0));
        int count = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int cur = point.y;
            int dis = point.distance;
            int wauPoint = point.wayPoint;

            if (cur == wayPoint1) { // wayPoint1 왔을떄 체크
                if (point.two == 1) wauPoint = 3;
                else wauPoint = 1;
                point.one = 1;
            }

            if (cur == wayPoint2) { // wayPoint2 왔을떄 체크
                if (point.one == 1) wauPoint = 3;
                else wauPoint = 1;
                point.two = 1;
            }

            if (cur == n && wauPoint == 3) {
                count += 1;  // v1 -> v2 -> n and v2 -> v1 -> n
                if (count == 2) return;
            } // wayPoint1, wayPoint2 다 거쳐서 n 왔을때


            switch (wauPoint) { // wayPoint 0(하나도 안거침), 1(1 or 2만거침), 3(둘다 거침)

                case 0:
                    if (isVisited[0][cur] == 0) {
                        isVisited[0][cur] = 1;
                        for (int i = 0; i < map[cur].size(); i++) {
                            int distance = Math.min(dis + map[cur].get(i).distance, totalDistance[0][map[cur].get(i).y]);
                            if (distance < totalDistance[0][map[cur].get(i).y]) {
                                totalDistance[0][map[cur].get(i).y] = distance;
                                queue.add(new Point(map[cur].get(i).y, distance, wauPoint, point.one, point.two));
                            }
                        }
                    }
                    break;

                case 1:
                    if (point.one == 1) {
                        if (isVisited[1][cur] == 0) {
                            isVisited[1][cur] = 1;
                            for (int i = 0; i < map[cur].size(); i++) {
                                int distance = Math.min(dis + map[cur].get(i).distance, totalDistance[1][map[cur].get(i).y]);
                                if (distance < totalDistance[1][map[cur].get(i).y]) {
                                    totalDistance[1][map[cur].get(i).y] = distance;
                                    queue.add(new Point(map[cur].get(i).y, distance, wauPoint, point.one, point.two));
                                }
                            }
                        }
                        break;
                    }

                    if (point.two == 1) {
                        if (isVisited[2][cur] == 0) {
                            isVisited[2][cur] = 1;
                            for (int i = 0; i < map[cur].size(); i++) {
                                int distance = Math.min(dis + map[cur].get(i).distance, totalDistance[2][map[cur].get(i).y]);
                                if (distance < totalDistance[2][map[cur].get(i).y]) {
                                    totalDistance[2][map[cur].get(i).y] = distance;
                                    queue.add(new Point(map[cur].get(i).y, distance, wauPoint, point.one, point.two));
                                }
                            }
                        }
                        break;
                    }

                case 3:
                    if (isVisited[3][cur] == 0 && cur != n) {
                        isVisited[3][cur] = 1;
                        for (int i = 0; i < map[cur].size(); i++) {
                            int distance = Math.min(dis + map[cur].get(i).distance, totalDistance[3][map[cur].get(i).y]);
                            if (distance < totalDistance[3][map[cur].get(i).y]) {
                                totalDistance[3][map[cur].get(i).y] = distance;
                                queue.add(new Point(map[cur].get(i).y, distance, wauPoint, point.one, point.two));
                            }
                        }
                    }
                    break;
            }
        }
    }


    private static class Point implements Comparable<Point> {
        int y, distance, one, two;
        int wayPoint;


        public Point(int y, int distance, int wayPoint, int one, int two) {
            this.y = y;
            this.distance = distance;
            this.one = one;
            this.two = two;
            this.wayPoint = wayPoint;
        }

        @Override
        public int compareTo(Point o) {
            return distance - o.distance;
        }
    }
}
