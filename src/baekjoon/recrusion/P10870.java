package recrusion;
//문제
//        피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
//
//        이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
//
//        n=17일때 까지 피보나치 수를 써보면 다음과 같다.
//
//        0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
//
//        n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 n이 주어진다. n은 20보다 작거나 같은 자연수 또는 0이다.
//
//        출력
//        첫째 줄에 n번째 피보나치 수를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        System.out.println(function(N));
        ArrayList<Integer> sum = new ArrayList<>();
        sum.add(0);
        sum.add(1);

        for (int i = 2; i <= N; i++) {
          sum.add(sum.get(i-1) + sum.get(i-2));

        }
        System.out.println(sum.get(N));

    }

    public static int function(int num) {
        if (num >= 2) {
            return function(num - 1) + function(num - 2);
        } else if (num == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}
