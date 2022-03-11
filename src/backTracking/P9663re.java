package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663re {

    public static int count = 0;
    public static int[] chessBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        count = 0;
        chessBoard = new int[n];

        nQueen(n, 0);
        System.out.println(count);


    }

    public static void nQueen(int n, int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isPossible(row, i, n)) {
                chessBoard[row] = i;
                nQueen(n, row + 1);
            }
        }
    }

    private static boolean isPossible(int row, int num, int n) {
        for (int i = 0; i < row; i++) {
            if (chessBoard[i] == num || Math.abs(row - i) == Math.abs(num - chessBoard[i])) {
                return false;
            }
        }
        return true;
    }


}


