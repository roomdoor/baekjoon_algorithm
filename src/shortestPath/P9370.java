package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9370 {
    public static ArrayList<Point>[] map;
    public static int[] DOption; // destination option 목적지 선택지
    public static int[][] totalDistance;
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
            totalDistance = new int[2][n + 1];
            for (int i = 0; i <= n; i++) totalDistance[0][i] = INF; // 거리 최대치로 초기화

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());

                map[x].add(new Point(y, distance, false));  // 경로 저장
                map[y].add(new Point(x, distance, false));
            }

            DOption = new int[t];
            for (int i = 0; i < t; i++) DOption[i] = Integer.parseInt(bf.readLine()); // 목적지 선택지 저장

            bfs(s, g, h); // 모든 최단 경로 탐색

            answer = new ArrayList<>(); // 가능한 경로 저장
            for (int option : DOption)
                if (totalDistance[1][option] == 1 && totalDistance[0][option] != INF)
                    answer.add(option);

            Collections.sort(answer); // 정답 정렬
            for (int SA : answer) sb.append(SA).append(" ");
            if (!answer.isEmpty()) sb.append("\n");
        }

        System.out.println(sb.toString());

    }


    public static void bfs(int start, int g, int h) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(start, 0, false));
        totalDistance[0][start] = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int cur = point.y;                                  // 현재 위치
            int distance = point.distance;                      // 현재 위치까지 걸린 거리
            boolean isChecked = point.isChecked;                // 필수 경로 경유 체크

            if (!isVisited[cur] && cur != g && cur != h) {
                isVisited[cur] = true;

                for (int i = 0; i < map[cur].size(); i++) {
                    Point next = map[cur].get(i);// cur 에서 갈수 있는 다음 Point
                    int tempDistance = Math.min(distance + next.distance, totalDistance[0][next.y]);    // next 까지 걸린 거리, 저장된 거리 최소값 비교
                    if (tempDistance < totalDistance[0][next.y]) {                                      // 저장된 거리 보다 작으면 저장
                        totalDistance[0][next.y] = tempDistance;

                        if (isChecked || isChecked(cur, next.y, g, h)) {                                // 필수 경로를 거쳐서 왔는지 or 필수 경로를 지나고 있는지
                            totalDistance[1][next.y] = 1;                                               // 필수 경로 거쳐서 온것 체크
                            next.isChecked = true;
                        }

                        queue.add(new Point(next.y, tempDistance, next.isChecked));
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
        boolean isChecked; // 겨쳐야 하는 지점을 지났는지

        public Point(int y, int distance, boolean isChecked) {
            this.y = y;
            this.distance = distance;
            this.isChecked = isChecked;
        }

        @Override
        public int compareTo(Point o) {
            return distance - o.distance;
        }

    }

}
