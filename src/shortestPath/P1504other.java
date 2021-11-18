package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1504other {
    public static ArrayList<Point>[] map;
    public static int[] totalDistance;
    public static int[] isVisited;
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
        for (int i = 1; i <= n; i++) map[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Point(b, c));
            map[b].add(new Point(a, c));
        }

        st = new StringTokenizer(bf.readLine());
        wayPoint1 = Integer.parseInt(st.nextToken());
        wayPoint2 = Integer.parseInt(st.nextToken());


        bfs(1, wayPoint1);
        int temp = totalDistance[wayPoint1];
//        System.out.println(temp + " start -> v1");
        bfs(wayPoint1, wayPoint2);
        temp += totalDistance[wayPoint2];
//        System.out.println(temp + " v1 -> v2");
        bfs(wayPoint2, n);
        temp += totalDistance[n];
//        System.out.println(temp + " v2 -> n");
        int v1v2n = temp;

        temp = 0;
        bfs(1, wayPoint2);
        temp += totalDistance[wayPoint2];
//        System.out.println(temp + " start -> v2");
        bfs(wayPoint2, wayPoint1);
        temp += totalDistance[wayPoint1];
//        System.out.println(temp + " v2 -> v1");
        bfs(wayPoint1, n);
        temp += totalDistance[n];
//        System.out.println(temp + " v1 -> n");
        int v2v1n = temp;

        int answer = Math.min(v1v2n, v2v1n);

        if (answer < INF) System.out.println(answer);
        else System.out.println(-1);
    }

    public static void bfs(int start, int end) {
        isVisited = new int[n + 1];
        totalDistance = new int[n + 1];
        for (int j = 0; j < n + 1; j++) totalDistance[j] = INF;

        PriorityQueue<Point> queue = new PriorityQueue<>();

        queue.add(new Point(start, 0));
        totalDistance[start] = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int cur = point.y;
            int dis = point.distance;
            if (cur == end) return;

            if (isVisited[cur] == 0) {
                isVisited[cur] = 1;
                for (int i = 0; i < map[cur].size(); i++) {
                    int distance = Math.min(dis + map[cur].get(i).distance, totalDistance[map[cur].get(i).y]);
                    if (distance < totalDistance[map[cur].get(i).y]) {
                        totalDistance[map[cur].get(i).y] = distance;
                        queue.add(new Point(map[cur].get(i).y, distance));
                    }
                }
            }
        }
    }

    private static class Point implements Comparable<Point> {
        int y, distance;


        public Point(int y, int distance) {
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Point o) {
            return distance - o.distance;
        }
    }
}
