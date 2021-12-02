package twoPointer;

import java.util.ArrayList;

public class P1450Test {
    public static void main(String[] args) {


        int[] arr = new int[]{1, 2, 3};
        boolean[] isVisited = new boolean[3];
        ArrayList<Long> num = new ArrayList<>();

        for (int i = 0; i < 4; i++) {

            RC(0, arr, isVisited, num, 0, i, 0);
        }
//        RC(0, arr, isVisited, num, 0, 2, 0);


        System.out.println(num.toString());
    }

    public static void RC(int DP, int[] arr, boolean[] isVisited, ArrayList<Long> num, long sum, int n, int k) {
        if (DP == n) {
            num.add(sum);
            return;
        }

        for (int i = k; i < arr.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                sum += arr[i];
                RC(DP + 1, arr, isVisited, num, sum, n, i);
                isVisited[i] = false;
                sum -= arr[i];
            }
        }
    }
}
