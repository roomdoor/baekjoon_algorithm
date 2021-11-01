package xxprogramers.arraysP.level1;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {

        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] com = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        solution(arr, com);

    }

    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        //copy range 사용 하면  for 문  하나 필요 없어짐
        // temp ArrayList 도 Array로 사용 가능
//        for(int i=0; i<commands.length; i++){
//            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
//            Arrays.sort(temp);
//            answer[i] = temp[commands[i][2]-1];
//        }

        for (int i = 0; i < commands.length; i++) {
            ArrayList<Integer> temp = new ArrayList();
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                temp.add(array[j]);
            }
            Collections.sort(temp);
            answer[i] = temp.get(commands[i][2] - 1);
        }

        return answer;
    }
}
