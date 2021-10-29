package math2P;
//문제
//        세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
//
//        입력
//        세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.
//
//        출력
//        직사각형의 네 번째 점의 좌표를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[][] rec = new int[2][3];
        int x;
        int y;

        for (int j = 0; j < 3; j++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            rec[0][j] = x;
            rec[1][j] = y;
        }

        if (rec[0][0] == rec[0][1]) {
            x = rec[0][2];
        } else if (rec[0][0] == rec[0][2]) {
            x = rec[0][1];
        } else {
            x = rec[0][0];
        }

        if (rec[1][0] == rec[1][1]) {
            y = rec[1][2];
        } else if (rec[1][0] == rec[1][2]) {
            y = rec[1][1];
        } else {
            y = rec[1][0];
        }

        System.out.println(x + " " + y);
    }
}
