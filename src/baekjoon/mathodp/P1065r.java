package mathodp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//문제
//        어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
//
//        출력
//        첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
public class P1065r {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        boolean[] isChecked = new boolean[n + 1];
        int[] num = new int[3];


        for (int i = 100; i < n + 1; i++) {
            int temp = i;
            num[0] = temp % 10;
            num[1] = (temp / 10) % 10;
            num[2] = (temp / 100) % 10;

            if (num[0] - num[1] == num[1] - num[2]) {
                isChecked[i] = true;
            }
        }


        int count = 0;

        if (n < 100) {
            count = n;
        } else {
            count = 99;
            for (int i = 100; i < n + 1; i++) {
                if (isChecked[i]) {
                    count++;
                }
            }
        }

        if (n == 1000) {
            count--;
        }

        System.out.println(count);
    }
}



