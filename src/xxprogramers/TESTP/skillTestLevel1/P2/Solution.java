package xxprogramers.TESTP.skillTestLevel1.P2;

public class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();

        if (len == 1) {
            return s;
        } else if (len % 2 == 0) {
            answer += s.charAt(len / 2 - 1);
            answer += s.charAt(len / 2);
            return answer;

        } else {
            return answer += s.charAt(len / 2);
        }
    }
}
