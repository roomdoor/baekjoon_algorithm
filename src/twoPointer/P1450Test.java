package twoPointer;

import java.util.ArrayList;

public class P1450Test {
    public static void main(String[] args) {


        in


        System.out.println();
    }
    public static void RC(int DP, int[] arr, boolean[] isVisited, ArrayList<Long> num, long sum, int n) {
        if (DP == n) {
            num.add(sum);
            return;
        }

        for (int i = DP; i < arr.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                System.out.println(arr[i]);
                RC(DP + 1, arr, isVisited, num, sum, n);
                isVisited[i] = false;
            }
        }
    }
}
