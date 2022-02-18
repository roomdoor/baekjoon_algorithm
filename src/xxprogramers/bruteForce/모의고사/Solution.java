package xxprogramers.bruteForce.모의고사;

public class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[][] mg = new int[][]{
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] scoreMg = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == mg[0][i % 5]) {
                scoreMg[0]++;
            }

            if (answers[i] == mg[1][i % 8]) {
                scoreMg[1]++;
            }

            if (answers[i] == mg[2][i % 10]) {
                scoreMg[2]++;
            }
        }

        int max = 0;

        max = Math.max(scoreMg[0], Math.max(scoreMg[1], scoreMg[2]));

        if (max == scoreMg[0]) {
            answer = new int[]{1};

            if (max == scoreMg[1]) {
                answer = new int[]{1, 2};

                if (max == scoreMg[2]) {
                    answer = new int[]{1, 2, 3};
                }

            } else if (max == scoreMg[2]) {
                answer = new int[]{1, 3};
            }
        } else if (max == scoreMg[1]) {
            answer = new int[]{2};

            if (max == scoreMg[2]) {
                answer = new int[]{2, 3};
            }
        } else {
            answer = new int[]{3};
        }

        return answer;
    }
}
