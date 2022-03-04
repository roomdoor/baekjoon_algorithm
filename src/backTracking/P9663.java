package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663 {

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

        if (row == 0) {
            for (int i = 0; i < n; i++) {
                chessBoard[row] = i;
                nQueen(n, row + 1);
            }
        } else {
            for (int i = 0; i < n; i++) {
                chessBoard[row] = i;
                if (isPossible(row)) {
                    nQueen(n, row + 1);
                }
            }
        }
    }

    public static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (chessBoard[i] == chessBoard[row] || row - i == Math.abs(chessBoard[row] - chessBoard[i])) {
                return false;
            }
        }
        return true;
    }
}


