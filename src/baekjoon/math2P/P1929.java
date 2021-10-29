package math2P;


//       에라토스테네스 체 모르면 시간초과하는 문제
//
//
//문제
//        M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
//
//        출력
//        한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Boolean> sosu = new ArrayList<>();
        sosu.add(0, false);
        sosu.add(1, false);

        for (int i = 2; i <= N; i++) {
            sosu.add(i, true);
        }

        for (int i = 2; i * i <= N; i++) {
            if (sosu.get(i)) {
                for (int j = i * i; j <= N; j += i) {
                    sosu.set(j, false);
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (sosu.get(i)) {
                System.out.println(i);
            }
        }
    }
}
