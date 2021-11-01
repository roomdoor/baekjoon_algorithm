package xxprogramers.bruteForce.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {

        String numbers = "17";
        System.out.println(solution(numbers));
    }


    public static int solution(String numbers) {
        int answer = 0;
        int length = numbers.length();
        isVisited = new boolean[length];

        for (int i = 0; i < length; i++) {
            int num = 0;
            makeNum(num, numbers, i);
        }

        HashSet<Integer> hashNumList = new HashSet<>(numberList);
        numberList = new ArrayList<Integer>(hashNumList);

        int n = Collections.max(numberList);
        boolean[] isChecked = new boolean[n + 1];
        isChecked[0] = true;
        isChecked[1] = true;
        for (int i = 2; n >= i * i; i++) {
            if (!isChecked[i]) {
                for (int j = 2; i * j <= n; j++) isChecked[j * i] = true;
            }
        }

        for (int i = 0; i < numberList.size(); i++) {
            if (!isChecked[numberList.get(i)]) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean[] isVisited;
    public static ArrayList<Integer> numberList = new ArrayList<>();

    public static void makeNum(int num, String numbers, int depth) {

        if (depth >= numbers.length()) {
            numberList.add(num);
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!isVisited[i]) {
                num *= 10;
                num += (int) numbers.charAt(i) - 48;
                isVisited[i] = true;
                makeNum(num, numbers, depth + 1);
                isVisited[i] = false;
                num /= 10;
            }
        }
    }
}
