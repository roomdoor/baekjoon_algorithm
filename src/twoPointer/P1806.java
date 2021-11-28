package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int end = 1;

        while (start < end && end < arr.length) {
            int sum = 0;

            for (int i = start; i < end; i++) {
                sum += arr[i];
            }

            if (sum < s) {
                end++;
            }

            if (sum >= s) {
                answer = Math.min(answer, end - start);
                if (answer == 1) {
                    return answer;
                }
                start++;
            }
        }

        if (answer == Integer.MAX_VALUE) {
            return 0;
        } else {
            return answer;
        }
    }
}
