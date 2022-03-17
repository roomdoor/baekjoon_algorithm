package dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206re {
    public static int[][] map;
    public static int[][][] isVisited;
    public static int max = Integer.MAX_VALUE;
    public static int[][] dxdy = new int[][]{{1, -1, 0, 0}, {0, 0, 1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVisited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }

        System.out.println(bfs(n, m));


    }

    public static int bfs(int n, int m) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        isVisited[0][0][0] = 1;
        isVisited[0][0][1] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == n - 1 && cur[1] == m - 1) {
                return isVisited[cur[0]][cur[1]][cur[2]];
            }
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dxdy[0][i];
                int nextY = cur[1] + dxdy[1][i];
                if (isPossible(nextX, nextY, n, m)) {
                    if (map[nextX][nextY] == 0) {                           // 길이 있을 때
                        if (isVisited[nextX][nextY][cur[2]] == 0) {
                            isVisited[nextX][nextY][cur[2]] = isVisited[cur[0]][cur[1]][cur[2]] + 1;
                            queue.add(new int[]{nextX, nextY, cur[2]});
                        }
                    } else if (cur[2] == 0) {                               // 길이 없고 벽을 안 부셨을 때
                        if (isVisited[nextX][nextY][1] == 0) {
                            isVisited[nextX][nextY][1] = isVisited[cur[0]][cur[1]][cur[2]] + 1;
                            queue.add(new int[]{nextX, nextY, 1});
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isPossible(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
