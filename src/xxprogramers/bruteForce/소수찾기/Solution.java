package xxprogramers.bruteForce.소수찾기;

import java.util.ArrayList;

public class Solution {
    public static int solution(String numbers) {
        int answer = 0;

        int NL = numbers.length();
        int maxN = 1;
        for (int i = 0; i < NL; i++) {
            maxN *= 10;
        }

        // 소수 찾기
        boolean[] sosu = new boolean[maxN];
        for (int i = 2; i < maxN; i++) {
            for (int j = i * 2; j < maxN; j += i) {
                sosu[j] = true;
            }
        }
        sosu[0] = true;
        sosu[1] = true;

        ArrayList<Integer> NUM = new ArrayList<>();
        boolean[] isVisited = new boolean[maxN];
        boolean[] isChecked = new boolean[NL];

        makeNum(0, 0, NL, numbers, isChecked, isVisited, NUM);

        for (int n : NUM) {
            if (!sosu[n]) {
                answer++;
            }
        }

        return answer;
    }

    public static void makeNum(int DP, int temp, int count, String numbers, boolean[] isChecked, boolean[] isVisited, ArrayList<Integer> NUM) {
        if (DP == count) {
            return;
        }

        for (int i = 0; i < count; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                temp = temp * 10 + (numbers.charAt(i) - 48);
                if (!isVisited[temp]) {
                    NUM.add(temp);
                    isVisited[temp] = true;
                }else return;
                makeNum(DP + 1, temp, count, numbers, isChecked, isVisited, NUM);
                temp /= 10;
                isChecked[i] = false;
            }
        }
    }
}
