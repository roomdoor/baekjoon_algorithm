package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1956 {
    public static long[][] TD; // total distance
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int city = Integer.parseInt(st.nextToken());
        int road = Integer.parseInt(st.nextToken());

        TD = new long[city][city];
        for (int i = 0; i < city; i++) {
            for (int j = i + 1; j < city; j++) {
                TD[i][j] = INF;
                TD[j][i] = INF;
            }
        }


        for (int i = 0; i < road; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());

            TD[start][end] = Math.min(TD[start][end], distance);
        }

        FW(city);

        long answer = INF;
        for (int i = 0; i < city; i++) {
            for (int j = i + 1; j < city; j++) {
                answer = Math.min(answer, TD[i][j] + TD[j][i]);
            }
        }
        if (answer == INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void FW(int city) {
        for (int k = 0; k < city; k++) {
            for (int i = 0; i < city; i++) {
                if (i == k) continue;
                for (int j = 0; j < city; j++) {
                    if (j == k || j == i) continue;
                    TD[i][j] = Math.min(TD[i][j], TD[i][k] + TD[k][j]);
                }
            }
        }
    }
}