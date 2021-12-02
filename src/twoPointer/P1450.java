package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1450 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> num1 = new ArrayList<>();
        ArrayList<Integer> num2 = new ArrayList<>();
        dfs(0, n / 2, 0, arr, num1, c);
        dfs(n / 2 + 1, n - 1, 0, arr, num2, c);

        Collections.sort(num1);
        Collections.sort(num2);
//        System.out.println(num1.toString());
//        System.out.println(num2.toString());

        System.out.println();
        int result = 0;
        for (Integer integer : num1) {
            for (Integer value : num2) {
                if (integer + value <= c) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void dfs(int start, int end, int sum, int[] arr, ArrayList<Integer> num, long c) {
        if (sum > c) return;

        if (start > end) {
            num.add(sum);
            return;
        }

        dfs(start + 1, end, sum, arr, num, c);
        dfs(start + 1, end, sum + arr[start], arr, num, c);
    }
}
