package xxLeetCord.Array;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[10001];

        for (int n : nums) {
            arr[Math.abs(n)]++;
        }

        int[] result = new int[nums.length];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                while (arr[i] > 0) {
                    result[count] = i * i;
                    count++;
                    arr[i]--;
                }
            }
        }

        return result;
    }
}
