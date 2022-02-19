package xxprogramers.dfsPbfsP.타겟넘버;

public class Solution {
    public static int solution(int[] numbers, int target) {
        return bfs(numbers, target, 0, numbers.length, 0);
    }

    public static int bfs(int[] numbers, int target, int nowN, int count, int DP) {
        if (DP == count) {
            if (target == nowN) {
                return 1;
            }
            return 0;
        }

        return bfs(numbers, target, nowN + numbers[DP], count, DP + 1)
                + bfs(numbers, target, nowN - numbers[DP], count, DP + 1);
    }

    public static void main(String[] args) {
        int[] num = new int[]{4, 1, 2, 1};
        System.out.println(solution(num, 4));
    }

}
