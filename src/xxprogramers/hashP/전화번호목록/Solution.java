package xxprogramers.hashP.전화번호목록;

import java.util.HashMap;

public class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();
        for (String n : phone_book) {
            map.put(n, 0);
        }

        for (String n : phone_book) {
            for (int i = 1; i < n.length(); i++) {
                if (map.containsKey(n.substring(0, i))) {
                    return answer = false;
                }
            }
        }

        return answer;
    }

}
