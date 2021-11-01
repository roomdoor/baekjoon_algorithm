package backTraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663r {

    public static int count = 0;
    public static int[] chessBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        count = 0;
        chessBoard = new int[n];

        makeQ(n, 0);

        System.out.println(count);


    }

    public static void makeQ(int n, int depth) {

        if (n == depth) {
            count++;
            return;
        }

        if (depth == 0) {
            for (int i = 0; i < n; i++) {
                chessBoard[depth] = i;
                makeQ(n, depth + 1);
            }
        } else {
            for (int i = 0; i < n; i++) {
                chessBoard[depth] = i;
                if (isChecked(depth)) {
                    makeQ(n, depth + 1);
                }
            }
        }
    }

    public static boolean isChecked(int depth) {
        for (int i = 0; i < depth; i++) {
            if (chessBoard[i] == chessBoard[depth] || depth - i == Math.abs(chessBoard[i] - chessBoard[depth]))
                return false;
        }
        return true;
    }
}


