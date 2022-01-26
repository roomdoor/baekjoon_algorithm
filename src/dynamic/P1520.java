package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1520 {
    public static int[][] map;
    public static int[][] count;
    public static boolean[][] isVisited;
    public static int[] dx = new int[]{1, -1, 0, 0};
    public static int[] dy = new int[]{0, 0, 1, -1};
    public static int row;
    public static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        count = new int[row][col];
        count[0][0] = 1;
        isVisited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        mapFill();

        System.out.println(bfs());
    }

    public static int bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(0, 0, map[0][0]));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int height = cur.height;
            if (x == row - 1 && y == col - 1) {
                continue;
            }

            if (!isVisited[x][y]) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (isPossible(nx, ny, height)) {
                        queue.offer(new Point(nx, ny, map[nx][ny]));
                        count[nx][ny] += count[x][y];
                        isVisited[x][y] = true;
                    }
                }
            }
        }
        return count[row - 1][col - 1];
    }

    public static boolean isPossible(int x, int y, int num) {
        return x >= 0 && y >= 0 && x < row && y < col && map[x][y] < num;
    }

    private static class Point implements Comparable<Point> {
        int x;
        int y;
        int height;

        public Point(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        @Override
        public int compareTo(Point o) {
            return o.height - this.height;
        }
    }

    public static void mapFill() {
        int num = row * col;

        for (int i = 0; i < row; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < col; j++) {
                    map[i][j] = num;
                    num--;
                }
            } else {
                for (int j = col - 1; j >= 0; j--) {
                    map[i][j] = num;
                    num--;
                }
            }
        }
    }
}
