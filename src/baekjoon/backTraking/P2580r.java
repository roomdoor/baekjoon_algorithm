package backTraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2580r {

    public static int[][] arr;
    public static ArrayList<int[]> blockPoint = new ArrayList<>();
    public static int blockCount;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        arr = new int[9][9];
        blockCount = 0;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    blockPoint.add(new int[]{i, j});
                    blockCount++;
                }
            }
        }

        makeSdoku(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    public static void makeSdoku(int depth) {

        if (depth == blockPoint.size()) {
            return;
        }

        int x = blockPoint.get(depth)[0];
        int y = blockPoint.get(depth)[1];

        for (int i = 1; i <= 9; i++) {
            if (isPosible(x, y, i)) {
                arr[x][y] = i;
                makeSdoku(depth + 1);

            }
        }
    }


    public static boolean isPosible(int x, int y, int value) {

        for (int i = 0; i < 9; i++) {
            if (arr[x][i] == value || arr[i][y] == value) {
                return false;
            }
        }

        int threePointX = (x / 3) * 3;
        int threePointY = (y / 3) * 3;
        for (int i = threePointX; i < threePointX + 3; i++) {
            for (int j = threePointY; j < threePointY + 3; j++) {
                if (arr[i][j] == value) return false;
            }
        }
        return true;
    }
}
