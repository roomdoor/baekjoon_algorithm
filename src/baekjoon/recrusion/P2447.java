package recrusion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2447 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        arr = new char[N][N];

        makeStar(0, 0, false, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    public static char[][] arr;

    public static void makeStar(int x, int y, boolean block, int N) {

        // N 이 1이되어 최소 단위가 되었을때 * or " " 을 찍음

        if (block) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) makeStar(i, j, true, size);
                else makeStar(i, j, false, size);
            }
        }

    }
}
