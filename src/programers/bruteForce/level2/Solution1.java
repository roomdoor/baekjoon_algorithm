package bruteForce.level2;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        int x = 10;
        int y = 2;

        System.out.println(Arrays.toString(Arrays.stream(solution(x, y)).toArray()));

    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;
        int row = 1;
        int col = 1;

        for (int i = col; col <= sum; i++) {
            if (sum % i == 0) {
                col = i;
                row = sum / i;
                if ((row - 2) * (col - 2) == yellow) {
                    break;
                }
            }
        }

        answer[0] = row;
        answer[1] = col;

        return answer;
    }
}
