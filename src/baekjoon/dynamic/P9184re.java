package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9184re {

    public static Integer[][][] wMemory;

    public static int w(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            if (wMemory[20][20][20] == null)
                wMemory[20][20][20] = w(20, 20, 20);

            return wMemory[20][20][20];
        }

        if (a < b && b < c) {
            if (wMemory[a][b][c] == null)
                wMemory[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);

            return wMemory[a][b][c];
        }

        if (wMemory[a][b][c] == null)
            wMemory[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

        return wMemory[a][b][c];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        wMemory = new Integer[21][21][21];
        int a = 0;
        int b = 0;
        int c = 0;

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1)
                break;

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }
    }
}

