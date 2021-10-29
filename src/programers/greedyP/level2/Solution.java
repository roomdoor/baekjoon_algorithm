package greedyP.level2;

public class Solution {
    public int solution(String name) {
        int answer = 0;

        for (int i = 0; i < name.length(); i++) {
            int c = name.charAt(i);
            if (c >= 78) answer += 26 - c + 65;
            else answer += c - 65;
        }
        return answer;
    }
}
