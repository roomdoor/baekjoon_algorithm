package xxprogramers.TESTP;

public class Solution {
    public int[] solution(int[][] v) {
        int x;
        int y;

        if (v[0][0] == v[1][0]) {
            x = v[2][0];
        } else if (v[0][0] == v[2][0]) {
            x = v[1][0];
        } else {
            x = v[0][0];
        }


        if (v[0][1] == v[1][1]) {
            y = v[2][1];
        } else if (v[0][1] == v[2][1]) {
            y = v[1][1];
        } else {
            y = v[0][1];
        }

        int[] answer = {x, y};

        return answer;
    }
}
