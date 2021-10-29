package mathodp;

import java.util.Scanner;
//문제
//        어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
//
//        출력
//        첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
public class P1065 {

    public static int hanSu(int N){
        int count = 0;
        int hundred;
        int ten;
        int one;
        if (N < 100) {
            count = N;
        } else {
            count = 99;
            for (int i = 100; i <= N; i++) {
                hundred = i / 100;
                ten = (i / 10) % 10;
                one = i % 10;

                if (hundred - ten == ten - one) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(hanSu(N));
    }

}



