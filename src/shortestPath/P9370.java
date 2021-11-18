package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9370 {
    public static ArrayList<Point>[] map;
    public static int[] DOption; // destination option 목적지 선택지
    public static int[] totalDistance;
    public static boolean[] isVisited;
    public static int INF = Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());

        for (int c = 0; c < testCase; c++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());   // 교차로
            int m = Integer.parseInt(st.nextToken());   // 도로
            int t = Integer.parseInt(st.nextToken());   // 목적지

            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());   // 출발지
            int g = Integer.parseInt(st.nextToken());   // 지나간 교차로
            int h = Integer.parseInt(st.nextToken());   // 지나간 교차로

            map = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) map[i] = new ArrayList<>();
            isVisited = new boolean[n + 1];
            totalDistance = new int[n + 1];
            for (int i = 0; i <= n; i++) totalDistance[i] = INF; // 거리 최대치로 초기화

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());
                if (isChecked(x, y, g, h)) {
                    map[x].add(new Point(y, 2 * distance - 1));  // 경로 저장
                    map[y].add(new Point(x, 2 * distance - 1));

                } else {
                    map[x].add(new Point(y, 2 * distance));  // 경로 저장
                    map[y].add(new Point(x, 2 * distance));
                }
            }

            DOption = new int[t];
            for (int i = 0; i < t; i++) DOption[i] = Integer.parseInt(bf.readLine()); // 목적지 선택지 저장

            dijkstra(s, g, h); // 모든 최단 경로 탐색

            answer = new ArrayList<>(); // 가능한 경로 저장
            for (int option : DOption)
                if (totalDistance[option] != INF && totalDistance[option] % 2 == 1)
                    answer.add(option);

            Collections.sort(answer); // 정답 정렬
            for (int SA : answer) sb.append(SA).append(" ");
            if (!answer.isEmpty()) sb.append("\n");
        }

        System.out.println(sb.toString());

    }


    public static void dijkstra(int start, int g, int h) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(start, 0));
        totalDistance[start] = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int cur = point.y;                                  // 현재 위치
            int distance = point.distance;                      // 현재 위치까지 걸린 거리


            if (!isVisited[cur]) {
                isVisited[cur] = true;

                for (int i = 0; i < map[cur].size(); i++) {
                    Point next = map[cur].get(i);// cur 에서 갈수 있는 다음 Point
                    int tempDistance = distance + next.distance;    // next 까지 걸린 거리, 저장된 거리 최소값 비교
                    if (tempDistance <= totalDistance[next.y]) {                                      // 저장된 거리 보다 작으면 저장
                        totalDistance[next.y] = tempDistance;

                        queue.add(new Point(next.y, tempDistance));
                    }
                }
            }

        }

    }

    public static boolean isChecked(int cur, int y, int g, int h) {
        return (cur == g && y == h) || (cur == h && y == g);
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
