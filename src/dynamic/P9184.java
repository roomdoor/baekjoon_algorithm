package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9184 {

    public static int[][][] answer = new int[21][21][21];

    public static int w(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return answer[20][20][20] = w(20, 20, 20);
        }

        if (answer[a][b][c] != 0) {
            return answer[a][b][c];
        }

        if(a < b && b < c) {
            return answer[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }


        return answer[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int a;
        int b;
        int c;
//
//        for (int i = 0; i < 21; i++) {
//            for (int j = 0; j < 21; j++) {
//                for (int k = 0; k < 21; k++) {
//                    a = i;
//                    b = j;
//                    c = k;
//
//                    System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
//                }
//            }
//        }

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }
    }
}

