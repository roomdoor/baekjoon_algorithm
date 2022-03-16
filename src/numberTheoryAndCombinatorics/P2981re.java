package numberTheoryAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2981re {
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);
        int answer = arr[1] - arr[0];

        for (int i = 2; i < n; i++) {
            answer = gfc(arr[i] - arr[i - 1], answer);
        }

        makeAnswer(answer);

    }

    public static int gfc(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gfc(b, a % b);
        }
    }

    public static void makeAnswer(int a) {
        for (int i = 2; i <= a; i++) {
            if (a % i == 0) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
