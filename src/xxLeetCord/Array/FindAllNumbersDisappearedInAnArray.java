package xxLeetCord.Array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arr = new int[nums.length + 1];
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            arr[num] = num;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1,2,3,4,5};
        System.out.println(findDisappearedNumbers(arr));
    }
}
