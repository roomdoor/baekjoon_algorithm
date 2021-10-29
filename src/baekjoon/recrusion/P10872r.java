package recrusion;

//문제
//        0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.
//
//        출력
//        첫째 줄에 N!을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10872r {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        System.out.println(function(N));


    }

    public static int function(int num) {
        if (num >= 2) {
            return num * function(num - 1);
        } else {
            return num;
        }
    }
}
