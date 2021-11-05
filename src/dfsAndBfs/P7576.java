package dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
    public static int[][] map;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int n;
    public static int m;
    public static int count = 0;
    public static int blank = 0;
    public static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) queue.add(new int[]{i, j});
                else if (map[i][j] == 0) blank++;
            }
        }

        bfs();

        System.out.println(count);

    }


    public static void bfs() {
        while (!queue.isEmpty() && blank > 0) {
            for (int j = queue.size(); j > 0; j--) {
                int[] temp = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = temp[0] + dx[i];
                    int newY = temp[1] + dy[i];
                    if (isPossible(newX, newY)) {
                        queue.add(new int[]{newX, newY});
                        map[newX][newY] = 1;
                        blank--;
                    }
                }
            }
            count++;
        }

        if (queue.isEmpty() && blank > 0)
            count = -1;

    }

    public static boolean isPossible(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n && map[x][y] == 0;
    }
}
