package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(twoPointer(arr));
    }

    public static String twoPointer(int[] arr) {
        int resulte = Integer.MAX_VALUE;
        int start = 0;
        int end = arr.length - 1;
        String answer = "";

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (resulte > Math.abs(sum)) {
                resulte = Math.min(Math.abs(resulte), Math.abs(sum));
                answer = arr[start] + " " + arr[end];
            }
            if (sum < 0) {
                start++;
            }
            if (sum > 0) {
                end--;
            }
            if (sum == 0) {
                return arr[start] + " " + arr[end];
            }
        }
        return answer;
    }
}
