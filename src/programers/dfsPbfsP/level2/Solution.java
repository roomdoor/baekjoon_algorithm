package dfsPbfsP.level2;

public class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(0,numbers,0,target);
        answer = count;
        return answer;
    }

    public static int[] isVisited;
    public static int count = 0;

    public static void dfs(int depth, int[] numbers, int sum, int target) {
        if (depth == numbers.length) {
            if (sum == target) count++;
            return;
        }

        sum += numbers[depth];
        dfs(depth + 1, numbers, sum, target);

        sum -= 2 * numbers[depth];
        dfs(depth + 1, numbers, sum, target);

    }
}
