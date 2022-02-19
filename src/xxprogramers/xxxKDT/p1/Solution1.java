package xxprogramers.xxxKDT.p1;

import java.util.Arrays;

public class Solution1 {
    public static int solution(int[] arr) {
        int answer = -1;
        int temp = 1001;
        Arrays.sort(arr);

        for (int i = arr[arr.length - 1]; i >= 0; i--) {
            int a = 0;
            int b = 0;

            for (int j = 0; j < arr.length; j++) {
                if (i > arr[j]) {
                    b++;
                } else {
                    a++;
                }
            }

            if (Math.abs(a - b) <= temp) {
                temp = Math.abs(a - b);
                answer = i;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 52, 125, 10, 25, 201, 244, 192, 128, 23, 203, 98, 154, 255};
        int[] arr1 = new int[]{0, 0, 255, 255, 0, 0, 255, 255, 255};
        int[] arr2 = new int[]{100, 100, 100, 100};

        System.out.println("정답: " + (solution(arr)));
        System.out.println();
        System.out.println("정답: " + (solution(arr1)));
        System.out.println();
        System.out.println("정답: " + (solution(arr2)));
        System.out.println();


    }
}
