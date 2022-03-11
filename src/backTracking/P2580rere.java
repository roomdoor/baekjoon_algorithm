package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2580rere {
    public static int[][] map = new int[9][9];
    public static ArrayList<int[]> blankPoint = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    blankPoint.add(new int[]{i, j});
                }
            }
        }

        makeSudoku(0);

    }

    public static void makeSudoku(int blankIndex) {
        if (blankIndex == blankPoint.size()) {
            print();
            System.exit(0);
        }

        int x = blankPoint.get(blankIndex)[0];
        int y = blankPoint.get(blankIndex)[1];

        for (int i = 1; i <= 9; i++) {
            if (isPossible(x, y, i)) {
                map[x][y] = i;
                makeSudoku(blankIndex + 1);
                map[x][y] = 0;
            }
        }
    }

    public static boolean isPossible(int x, int y, int value) {
        int dx = x / 3;
        int dy = y / 3;

        for (int i = 0; i < 9; i++) {
            if (map[x][i] == value) return false;
            if (map[i][y] == value) return false;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[dx * 3 + i][dy * 3 + j] == value) return false;
            }
        }

        return true;
    }

    public static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(" ");
            }
            if (i != 8) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}