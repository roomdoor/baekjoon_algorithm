package xxprogramers.arraysP.level2;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        int[] arr = {0, 0, 0, 0, 0, 0, 0, 2};

        System.out.println(solution(arr) + " 내꺼");


    }

    public static int solution(int[] citations) {
        int answer = 0;
        int length = citations.length;
        Arrays.sort(citations);

        for (int i = 0; i < length; i++) {

            if (citations[i] <= 1000 & citations[i] >= length - i) {
                answer = length - i;
                break;
            }
        }

        return answer;
    }


}
