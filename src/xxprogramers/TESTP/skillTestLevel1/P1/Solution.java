package xxprogramers.TESTP.skillTestLevel1.P1;

public class Solution {
    public int[] solution(int n, int m) {
        int answer1 = 0;
        int answer2;
        if (n > m) {
            int temp = m;
            m = n;
            n = temp;
        }

        for (int i = n; i > 0; i--) {
            if (n % i == 0 && m % i == 0) {
                answer1 = i;
                break;
            }
        }

        answer2 = n / answer1 * m;

        return new int[]{answer1, answer2};
    }
}
