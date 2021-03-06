package dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class P2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        isChecked = new boolean[n][n];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < n; j++) {
                int x = line.charAt(j) - 48;
                map[i][j] = x;
            }
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                bfs(i, j, n);


        sb.append(answer.size()).append("\n");
        answer.sort(Comparator.naturalOrder());
//        Collections.sort(answer);
        for (Integer integer : answer) {
            sb.append(integer).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static StringBuilder sb = new StringBuilder();
    public static int[][] map;
    public static boolean[][] isChecked;
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static int count;

    public static void bfs(int x, int y, int n) {
        if (!isChecked[x][y] && map[x][y] == 1) {
            count = 1;
            Queue<Point> queue = new ArrayDeque<>();
            isChecked[x][y] = true;
            queue.add(new Point(x, y));

            while (!queue.isEmpty()) {
                Point point = queue.poll();
                int xNew = point.x;
                int yNew = point.y;
                if (xNew < n - 1 && !isChecked[xNew + 1][yNew] && map[xNew + 1][yNew] == 1) {
                    count++;
                    queue.add(new Point(xNew + 1, yNew));
                    isChecked[xNew + 1][yNew] = true;
                }

                if (yNew < n - 1 && !isChecked[xNew][yNew + 1] && map[xNew][yNew + 1] == 1) {
                    count++;
                    queue.add(new Point(xNew, yNew + 1));
                    isChecked[xNew][yNew + 1] = true;
                }
                if (xNew > 0 && !isChecked[xNew - 1][yNew] && map[xNew - 1][yNew] == 1) {
                    count++;
                    queue.add(new Point(xNew - 1, yNew));
                    isChecked[xNew - 1][yNew] = true;
                }
                if (yNew > 0 && !isChecked[xNew][yNew - 1] && map[xNew][yNew - 1] == 1) {
                    count++;
                    queue.add(new Point(xNew, yNew - 1));
                    isChecked[xNew][yNew - 1] = true;
                }
            }
            answer.add(count);
        }
    }


    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
