package xxprogramers.sort.K번째수;

import java.util.Arrays;

public class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int answerLen = commands.length;
        int[] answer = new int[answerLen];

        for (int i = 0; i < answerLen; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int target = commands[i][2] - 1;
            int len = end - start + 1;
            int[] temp = new int[len];

            for (int j = start; j <= end; j++) {
                temp[j - start] = array[j];
            }

            Arrays.sort(temp);
            answer[i] = temp[target];
        }

        return answer;
    }
}


//
//    public static void main(String[] args) {
//        int[][] arr = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
//        int[] a = new int[]{1, 5, 2, 6, 3, 7, 4};
//
//        System.out.println(Arrays.toString(solution(a, arr)));
//    }
