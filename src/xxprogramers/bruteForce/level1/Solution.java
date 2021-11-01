package xxprogramers.bruteForce.level1;

public class Solution {

    public int[] solution(int[] answers) {

        int[] methGiveUp1 = new int[answers.length];
        int[] methGiveUp2 = new int[answers.length];
        int[] methGiveUp3 = new int[answers.length];

        for (int i = 0; i < answers.length; i++) {
            if (i % 5 == 0) {
                methGiveUp1[i] = 1;
            } else if (i % 5 == 1) {
                methGiveUp1[i] = 2;
            } else if (i % 5 == 2) {
                methGiveUp1[i] = 3;
            } else if (i % 5 == 3) {
                methGiveUp1[i] = 4;
            } else {
                methGiveUp1[i] = 5;
            }
        }

        for (int i = 0; i < answers.length; i++) {
            if (i % 8 == 0) {
                methGiveUp2[i] = 2;
            } else if (i % 8 == 1) {
                methGiveUp2[i] = 1;
            } else if (i % 8 == 2) {
                methGiveUp2[i] = 2;
            } else if (i % 8 == 3) {
                methGiveUp2[i] = 3;
            } else if (i % 8 == 4) {
                methGiveUp2[i] = 2;
            } else if (i % 8 == 5) {
                methGiveUp2[i] = 4;
            } else if (i % 8 == 6) {
                methGiveUp2[i] = 2;
            } else {
                methGiveUp2[i] = 5;
            }
        }
        for (int i = 0; i < answers.length; i++) {
            if (i % 10 == 0) {
                methGiveUp3[i] = 3;
            } else if (i % 10 == 1) {
                methGiveUp3[i] = 3;
            } else if (i % 10 == 2) {
                methGiveUp3[i] = 1;
            } else if (i % 10 == 3) {
                methGiveUp3[i] = 1;
            } else if (i % 10 == 4) {
                methGiveUp3[i] = 2;
            } else if (i % 10 == 5) {
                methGiveUp3[i] = 2;
            } else if (i % 10 == 6) {
                methGiveUp3[i] = 4;
            } else if (i % 10 == 7) {
                methGiveUp3[i] = 4;
            } else if (i % 10 == 8) {
                methGiveUp3[i] = 5;
            } else {
                methGiveUp3[i] = 5;
            }
        }

        int score1 = 0;
        int score2 = 0;
        int score3 = 0;

        for (int j = 0; j < answers.length; j++) {
            if (answers[j] == methGiveUp1[j]) {
                score1++;
            }
            if (answers[j] == methGiveUp2[j]) {
                score2++;
            }
            if (answers[j] == methGiveUp3[j]) {
                score3++;
            }
        }

        int[] score = new int[1];

        if (score1 > score2 & score1 > score3) {
            score = new int[1];
            score[0] = 1;
        } else if (score2 > score3 & score2 > score1) {
            score = new int[1];
            score[0] = 2;

        } else if (score3 > score2 & score3 > score1) {
            score = new int[1];
            score[0] = 3;

        } else if (score1 == score2 & score1 > score3) {
            score = new int[2];
            score[0] = 1;
            score[1] = 2;

        } else if (score1 == score3 & score1 > score2) {
            score = new int[2];
            score[0] = 1;
            score[1] = 3;

        } else if (score2 == score3 & score2 > score1) {
            score = new int[2];
            score[0] = 2;
            score[1] = 3;
        } else if (score2 == score3 & score2 > score1) {
            score = new int[2];
            score[0] = 2;
            score[1] = 3;
        } else if (score2 == score3 & score3 == score1) {
            score = new int[3];
            score[0] = 1;
            score[1] = 2;
            score[2] = 3;
        }


        return score;
    }
}
