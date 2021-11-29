package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(twoPointer(arr, s));

    }

    public static int twoPointer(int[] arr, int s) {
        int answer = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = arr[0];
        int impossible = 0;
        for (int num : arr) {
            impossible += num;
        }
        if (impossible < s) {
            return 0;
        }

        while (start <= end) {
            if (sum < s && end < arr.length - 1) {
                end++;
                sum += arr[end];
            } else {
                if (sum >= s) {
                    answer = Math.min(answer, end - start + 1);
                    if (answer == 1) {
                        return 1;
                    }
                    sum -= arr[start];
                    start++;
                } else return answer;
            }
        }
        return answer;
    }
}
