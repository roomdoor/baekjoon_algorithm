package sort;

//문제
//        수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
//
//        산술평균 : N개의 수들의 합을 N으로 나눈 값
//        중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
//        최빈값 : N개의 수들 중 가장 많이 나타나는 값
//        범위 : N개의 수들 중 최댓값과 최솟값의 차이
//        N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
//
//        출력
//        첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
//
//        둘째 줄에는 중앙값을 출력한다.
//
//        셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
//
//        넷째 줄에는 범위를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P2108 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());

        int[] check = new int[8001];
        double sum = 0;
        double count = 0;
        double avg;
        int middleNum = 0;
        int manyNum;
        int maxMin;
        int max = 0;
        int min = 0;

        for (int i = 0; i < n; i++) {

            check[Integer.parseInt(bf.readLine()) + 4000] += 1;

        }

        for (int i = 0; i < 8001; i++) {
            for (int j = 0; j < check[i]; j++) {
                sum += i - 4000;
                count += 1;

                if (count == 1) min = i - 4000;
                if (count == n) max = i - 4000;
                if (count * 2 - 1 == n) {
                    middleNum = i - 4000;
                }

            }

        }

        avg = sum / n;

//        if (((avg * 10) % 10) >= 5) {
//            if (avg >= 0)
//                average = (int) (avg) + 1;
//            else
//                average = (int) (avg) - 1;
//        } else {
//            average = (int) avg;
//        }


        int many = Arrays.stream(check).max().getAsInt();
        ArrayList<Integer> checkManyNum = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (check[i] == many) {
                checkManyNum.add(i - 4000);
            }
        }


        if (checkManyNum.size() > 1) {
            manyNum = checkManyNum.get(1);
        } else {
            manyNum = checkManyNum.get(0);
        }


        maxMin = max - min;


        sb.append(Math.round(avg)).append("\n").append(middleNum).append("\n").append(manyNum).append("\n").append(maxMin);
        System.out.println(sb.toString());
    }
}
