package xxLeetCord.Array;

import java.util.Arrays;

public class HeightChecker {
//    public int heightChecker(int[] heights) {
//        int[] expected = heights.clone();
//        Arrays.sort(expected);
//        int count = 0;
//        for (int i = 0; i < expected.length; i++) {
//            if (expected[i] != heights[i]) {
//                count++;
//            }
//        }
//
//        return count;
//    }

    public static int heightChecker1(int[] heights) {
        if(heights == null){
            return 0;
        }
        int diffCount = 0;
        int[] countingSort = new int[100];
        for(int e : heights) {
            countingSort[e-1]++;
        }

        for(int i=0, c=0; i< heights.length && c<countingSort.length;) {
            if(countingSort[c] == 0) {
                c++;
                continue;
            }
            if(heights[i] != c+1) {
                diffCount++;
            }
            --countingSort[c];
            i++;
        }

        return diffCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 4};
        System.out.println(heightChecker1(arr));
    }
}
