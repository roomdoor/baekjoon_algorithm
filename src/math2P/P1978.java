package math2P;

//
//문제
//        주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
//
//        입력
//        첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
//
//        출력
//        주어진 수들 중 소수의 개수를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int count = 0;

        for (int i = 0; i < testCase; i++) {
            int temp = 0;
            int num = Integer.parseInt(st.nextToken());

            for (int j = 2; j <= num; j++) {
                if (num % j == 0) {
                    temp++;
                }
            }

            if (temp == 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
