package dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206r {
    public static int[][] map;
    public static boolean[][][] isVisited;
    public static int n;
    public static int m;
    public static int[] dx = new int[]{1, -1, 0, 0};
    public static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        isVisited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<queuePoint> queue = new ArrayDeque<>();
        queue.add(new queuePoint(0, 0, 1, 0));

        while (!queue.isEmpty()) {
            queuePoint temp = queue.poll();
            if (temp.x == n - 1 && temp.y == m - 1) {
                return temp.distance;
            }

            for (int i = 0; i < 4; i++) {
                int newX = temp.x + dx[i];
                int newY = temp.y + dy[i];
                int distance = temp.distance;
                int wallCrush = temp.wallCrush;

                if (isPossible(newX, newY, wallCrush)) {
                    if (map[newX][newY] == 1 && wallCrush == 0) {
                        queue.add(new queuePoint(newX, newY, distance + 1, 1));
                        isVisited[newX][newY][0] = true;

                    } else if (map[newX][newY] == 0) {
                        queue.add(new queuePoint(newX, newY, distance + 1, wallCrush));
                        isVisited[newX][newY][wallCrush] = true;
                    }
                }
            }
        }
        return -1;
    }


    public static boolean isPossible(int x, int y, int wallCrush) {
        return x >= 0 && y >= 0 && x < n && y < m && !isVisited[x][y][wallCrush];
    }

    private static class queuePoint {
        int x;
        int y;
        int distance;
        int wallCrush;

        public queuePoint(int x, int y, int distance, int wallCrush) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.wallCrush = wallCrush;
        }
    }

}