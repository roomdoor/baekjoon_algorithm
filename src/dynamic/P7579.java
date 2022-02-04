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

        isVisited = new boolean[maxM + 1];
        DP = new int[maxM + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        makeDP(maxC, maxM, n, m);

        System.out.println(memory[m]);
    }

    public static void makeDP(int c, int m, int n, int max) {
        if (DP[m] > c) {
            DP[m] = c;
        } else if (m < max) return;

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]){
                isVisited[i] =true;
                c -= memory[1][m];
                m -= memory[0][m];
            }
        }


    }
}
