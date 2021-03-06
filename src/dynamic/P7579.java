package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7579 {
    public static int[][] memory;
    public static int[] DP;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        memory = new int[2][n];

        int maxM = 0;
        int maxC = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            memory[0][i] = Integer.parseInt(st.nextToken());
            maxM += memory[0][i];
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            memory[1][i] = Integer.parseInt(st.nextToken());
            maxC += memory[1][i];
        }

        isVisited = new boolean[maxC + 1];
        DP = new int[maxC + 1];
        Arrays.fill(DP, -1);
        makeDP(0, maxC, maxM, n);

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < DP.length; i++) {
            if (DP[i] >= m && DP[i] != -1) {
                answer = Math.min(answer, i);
            }
        }
        System.out.println(answer);
    }

    public static void makeDP(int count, int c, int m, int n) {
        if (DP[c] < m || DP[c] == -1) {
            DP[c] = m;
        }

        if (count == n) return;

        makeDP(count + 1, c - memory[1][count], m - memory[0][count], n);
        makeDP(count + 1, c, m, n);
    }
}
