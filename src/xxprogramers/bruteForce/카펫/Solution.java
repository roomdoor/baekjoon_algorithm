package xxprogramers.bruteForce.카펫;

import java.util.Arrays;

public class Solution {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;

        for (int i = 3; i <= sum / 3; i++) {
            if (sum % i == 0) {
                int j = sum / i;

                if ((i - 2) * (j - 2) == yellow) {
                    answer[0] = j;
                    answer[1] = i;
                    break;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(8, 1)));
    }
}
