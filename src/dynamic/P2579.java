package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579 {

    public static int n;
    public static int[] arr;
    public static Integer[] maxArr;
    public static int[] maxArrFor;

    public static int maxNum(int n) {

        if (maxArr[n] == null) {
            maxArr[n] = Math.max(maxNum(n - 2), maxNum(n - 3) + arr[n - 1]) + arr[n];
        }

        return maxArr[n];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        arr = new int[n + 1];
        maxArr = new Integer[n + 1];
        maxArrFor = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        maxArr[0] = arr[0];
        maxArr[1] = arr[1];

        if (n > 1) {
            maxArr[2] = arr[1] + arr[2];
        }

        System.out.println("재귀 풀이" + maxNum(n));



        maxArrFor[1] = arr[1];

        if (n > 1)
            maxArrFor[2] = arr[2] + arr[1];


        for (int i = 3; i <= n; i++) {
            maxArrFor[i] = Math.max(maxArrFor[i - 3] + arr[i - 1], maxArrFor[i - 2]) + arr[i];
        }
        System.out.println("반복문 풀이 " + maxArrFor[n]);

    }
}
