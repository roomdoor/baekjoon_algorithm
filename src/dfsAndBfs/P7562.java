package dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {
    public static int[][] chessBoard;
    public static int[][] isVisited;
    public static int line;
    public static int endX;
    public static int endY;
    public static int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    public static int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(bf.readLine());

        for (int i = 0; i < testCase; i++) {
            line = Integer.parseInt(bf.readLine());
            chessBoard = new int[line][line];
            isVisited = new int[line][line];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            isVisited[startX][startY] = 0;
            bfs(startX, startY, 0);
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void bfs(int x, int y, int count) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y, count));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x == endX && point.y == endY) {
                answer = point.count;
                return;
            }

            for (int i = 0; i < 8; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];
                int nowCount = point.count;

                if (isPossible(newX, newY)) {
                    isVisited[newX][newY] = nowCount + 1;
                    queue.add(new Point(newX, newY, nowCount + 1));
                }
            }
        }
    }

    public static boolean isPossible(int x, int y) {
        return x >= 0 && x < line && y >= 0 && y < line && isVisited[x][y] == 0;
    }


    private static class Point {
        int x;
        int y;
        int count;

        public Point(int startX, int startY, int count) {
            this.x = startX;
            this.y = startY;
            this.count = count;
        }
    }

}
