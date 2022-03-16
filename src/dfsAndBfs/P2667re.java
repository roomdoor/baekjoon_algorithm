package dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2667re {
    public static int[][] map;
    public static List<Integer> answer = new ArrayList<>();
    public static boolean[][] isVisited;
    public static int[][] dxdy = {{1, -1, 0, 0}, {0, 0, 1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0 && !isVisited[i][j]) {
                    answer.add(0);
//                    bfs(n, i, j, count);
                    dfs(n, i, j, count);
                    count++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(answer);
        sb.append(answer.size()).append("\n");
        for (int num : answer) {
            sb.append(num).append("\n");
        }

        System.out.println(sb.toString());

    }

    public static void dfs(int n, int x, int y, int count) {
        isVisited[x][y] = true;
        answer.set(count, answer.get(count) + 1);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dxdy[0][i];
            int nextY = y + dxdy[1][i];
            if (isPossible(nextX, nextY, n)) {
                dfs(n, nextX, nextY, count);
            }
        }


    }

    public static void bfs(int n, int startX, int starrY, int count) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] start = {startX, starrY};
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (isVisited[cur[0]][cur[1]]) continue;
            isVisited[cur[0]][cur[1]] = true;
            answer.set(count, answer.get(count) + 1);

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dxdy[0][i];
                int nextY = cur[1] + dxdy[1][i];
                if (isPossible(nextX, nextY, n)) {
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

    }

    public static boolean isPossible(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n && map[x][y] != 0 && !isVisited[x][y];
    }


}
