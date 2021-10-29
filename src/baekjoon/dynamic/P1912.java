package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1912 {

    public static int[] arr;
    public static Integer[] DP;

    public static int dp(int depth) {

        if (DP[depth] == null) {
            DP[depth] = Math.max(arr[depth], dp(depth - 1) + arr[depth]);
        }
        return DP[depth];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        DP = new Integer[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DP[0] = arr[0];
        int max = DP[0];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp(i));
        }

        System.out.println(max);
    }
}
