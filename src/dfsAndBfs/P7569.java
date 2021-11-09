package dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7569 {
    public static int[][][] map;
    public static int[] dx = {1, -1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, 1, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};
    public static int n;
    public static int m;
    public static int h;
    public static int count = 0;
    public static int blank = 0;
    public static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[m][n][h];


        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < n; k++) {
                    map[j][k][i] = Integer.parseInt(st.nextToken());

                    if (map[j][k][i] == 1) queue.add(new int[]{j, k, i});
                    else if (map[j][k][i] == 0) blank++;
                }
            }
        }


        bfs();

        System.out.println(count);

    }


    public static void bfs() {
        while (!queue.isEmpty() && blank > 0) {
            for (int j = queue.size(); j > 0; j--) {
                int[] temp = queue.poll();
                for (int i = 0; i < 6; i++) {
                    int newX = temp[0] + dx[i];
                    int newY = temp[1] + dy[i];
                    int newZ = temp[2] + dz[i];
                    if (isPossible(newX, newY, newZ)) {
                        queue.add(new int[]{newX, newY, newZ});
                        map[newX][newY][newZ] = 1;
                        blank--;
                    }
                }
            }
            count++;
        }

        if (queue.isEmpty() && blank > 0)
            count = -1;

    }

    public static boolean isPossible(int x, int y, int z) {
        return z >= 0 && x >= 0 && y >= 0 && x < m && y < n && z < h && map[x][y][z] == 0;
    }
}
