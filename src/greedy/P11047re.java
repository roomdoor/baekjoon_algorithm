package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047re {
    public static int[] coin;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        coin = new int[n];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(bf.readLine());
        }

        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (coin[i] <= k) {
                int temp = k / coin[i];
                k -= temp * coin[i];
                answer += temp;
            }
        }

        System.out.println(answer);
    }
}
