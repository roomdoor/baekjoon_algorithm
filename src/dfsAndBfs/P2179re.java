package dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2179re {
    public static int[][] map;
    public static int[][] isVisited;
    public static int[][] dxdy = {{1, -1, 0, 0}, {0, 0, 1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVisited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }

        bfs(0, 0, n, m);

        System.out.println(isVisited[n - 1][m - 1]);
    }

    public static void bfs(int x, int y, int n, int m) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        isVisited[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dxdy[0][i];
                int nextY = cur[1] + dxdy[1][i];
                if (isPossible(nextX, nextY, n, m)) {
                    queue.add(new int[]{nextX, nextY});
                    isVisited[nextX][nextY] = isVisited[cur[0]][cur[1]] + 1;
                }
            }
        }
    }

    public static boolean isPossible(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m && map[x][y] == 1 && isVisited[x][y] == 0;
    }
}
