package sort;

//문제
//        N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
//
//        출력
//        첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());

        boolean[] isChecked = new boolean[2001];

        for (int i = 0; i < n; i++) {
            isChecked[Integer.parseInt(bf.readLine()) + 1000] = true;
        }

        int count = 0;

        for (int i = 0; i < 2001; i++) {
            if (isChecked[i]) {
                sb.append(i - 1000).append("\n");
                count++;
                if (count == n) {
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
