package dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    public static int[][] map;
    public static int[][] isChecked;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int m;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isChecked = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < m; j++)
                map[i][j] = line.charAt(j) - 48;
        }

        bfs(0,0);

        System.out.println(isChecked[n - 1][m - 1]);

    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        if (isPossible(x, y)) {
            queue.add(new int[]{x, y});
            isChecked[x][y] += 1;

            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = temp[0] + dx[i];
                    int newY = temp[1] + dy[i];
                    if (isPossible(newX, newY)) {
                        queue.add(new int[]{newX, newY});
                        if (isChecked[newX][newY] == 0)
                            isChecked[newX][newY] = isChecked[temp[0]][temp[1]] + 1;
                        else
                            isChecked[newX][newY] = Math.min(isChecked[x][y] + 1, isChecked[newX][newY]);
                    }
                }
            }
        }
    }

    public static boolean isPossible(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m && isChecked[x][y] == 0 && map[x][y] == 1;
    }
}