package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        long k = Long.parseLong(bf.readLine());

        BS(1, k, k);
        System.out.println(answer);
    }

    public static int n;
    public static long answer;

    public static void BS(long min, long max, long k) {
        if (min >= max) {
            answer = (min + max) / 2;
            return;
        }

        long mid = (min + max) / 2;
        int count = 0;
        for (int i = 1; i <= n; i++)
            count += Math.min(n, mid / i);

        if (count >= k) {
            BS(min, mid, k);
        } else {
            BS(mid + 1, max, k);
        }
    }
}
