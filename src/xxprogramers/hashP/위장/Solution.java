package xxprogramers.hashP.위장;

import java.util.HashMap;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        String[][] clothes = new String[][]{{"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (map.get(clothes[i][1]) == null) {
                map.put(clothes[i][1], 1);
            } else {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
        }

        Set<String> keySet = map.keySet();

        for (String key : keySet) {
            answer *= map.get(key) + 1;
        }
        return answer - 1;
    }
}
