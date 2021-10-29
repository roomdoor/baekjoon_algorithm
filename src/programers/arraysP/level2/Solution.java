package arraysP.level2;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[] arrr = {3, 4, 52, 6, 74, 3, 85, 4, 6, 5, 3, 5, 6, 6, 04, 648, 8, 0, 300, 46, 486, 40, 640, 3, 86, 68, 84, 640, 8604, 60, 8, 456, 6, 86};
        System.out.println(solution(arrr));
    }

    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        String[] stringNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (stringNumbers[0].charAt(0) == '0') {
            return "0";
        } else {
            for (String s : stringNumbers) sb.append(s);
            answer = sb.toString();
            return answer;
        }
    }
}
