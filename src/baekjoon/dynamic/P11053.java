package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11053 {

    public static int[] arr;
    public static Integer[] DP;

    public static int count(int depth) {

        if (DP[depth] == null) {
            DP[depth] = 1;

            for (int i = depth - 1; i >= 0; i--) {
                if (arr[depth] > arr[i]) {
                    DP[depth] = Math.max(DP[depth], count(i) + 1);
                }
            }
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


        for (int i = 0; i < n; i++) {
            count(i);
        }

        int max = DP[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, DP[i]);
        }

        System.out.println(max);
    }
}
