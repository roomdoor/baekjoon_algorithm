package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2293re {
    public static int[] coin;
    public static int[] coinSum;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        coin = new int[n];
        coinSum = new int[k + 1];
        coinSum[0] = 1;

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(bf.readLine());
        }

        makeCoinSum(n, k);
        System.out.println(coinSum[k]);
    }

    public static void makeCoinSum(int n, int k) {
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                coinSum[j] += coinSum[j - coin[i]];
            }
        }
    }
}
