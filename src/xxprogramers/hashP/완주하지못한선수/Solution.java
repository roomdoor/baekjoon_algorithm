package xxprogramers.hashP.완주하지못한선수;


import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.merge(p, 1, Integer::sum);
        }

        for (String p : completion) {
            map.replace(p, map.get(p) - 1);
        }

        for (String p : map.keySet()) {
            if (map.get(p) == 1) {
                answer = p;
                break;
            }
        }
        return answer;
    }
}
