package dfsAndBfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class P1012 {
    public static StringBuilder sb = new StringBuilder();
    public static int[][] map;
    public static boolean[][] isChecked;
    public static ArrayList<Integer> answer;

    public static void bfs(int x, int y, int m, int n) {
        if (!isChecked[x][y] && map[x][y] == 1) {
            Queue<Point> queue = new ArrayDeque<>();
            isChecked[x][y] = true;
            queue.add(new Point(x, y));

            while (!queue.isEmpty()) {
                Point point = queue.poll();
                int xNew = point.x;
                int yNew = point.y;
                if (xNew < m - 1 && !isChecked[xNew + 1][yNew] && map[xNew + 1][yNew] == 1) {
                    queue.add(new Point(xNew + 1, yNew));
                    isChecked[xNew + 1][yNew] = true;
                }

                if (yNew < n - 1 && !isChecked[xNew][yNew + 1] && map[xNew][yNew + 1] == 1) {
                    queue.add(new Point(xNew, yNew + 1));
                    isChecked[xNew][yNew + 1] = true;
                }
                if (xNew > 0 && !isChecked[xNew - 1][yNew] && map[xNew - 1][yNew] == 1) {
                    queue.add(new Point(xNew - 1, yNew));
                    isChecked[xNew - 1][yNew] = true;
                }
                if (yNew > 0 && !isChecked[xNew][yNew - 1] && map[xNew][yNew - 1] == 1) {
                    queue.add(new Point(xNew, yNew - 1));
                    isChecked[xNew][yNew - 1] = true;
                }
            }
            answer.add(1);
        }
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bf.readLine());

        for (int c = 0; c < testCase; c++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            answer = new ArrayList<>();
            isChecked = new boolean[m][n];
            map = new int[m][n];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }

            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    bfs(i, j, m, n);

            sb.append(answer.size()).append("\n");
        }

        System.out.println(sb.toString());

    }
}
