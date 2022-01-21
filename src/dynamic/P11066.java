package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11066 {
    public static int[][] page;
//    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(bf.readLine());
            page = new int[k][k];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < k; j++) {
                page[j][j] = Integer.parseInt(st.nextToken());
            }
            int answer = pageSum(0, k - 1);
            sb.append(answer).append("\n");

//            print(k);

        }

        System.out.println(sb.toString());

    }

    public static int pageSum(int a, int b) {
        if (a == b) {
            return page[a][a];
        }

        int time1 = pageSum(a, b - 1) + pageSum(b, b);
        int time2 = pageSum(a, a) + pageSum(a + 1, b);
        if (a + 2 < b) {
            int time3 = pageSum(a, a) + pageSum(a + 1, b - 1) + pageSum(b, b);
            return page[a][b] = Math.min(Math.min(time1, time2), time3);
        }
        return page[a][b] = Math.min(time1, time2);


    }

    public static void print(int k) {
        for (int j = 0; j < k; j++) {
            for (int l = 0; l < k; l++) {
                if (page[j][l] == 0) {
                    System.out.print("   ");
                } else {
                    System.out.print(page[j][l] + " ");
                }

            }
            System.out.println();
        }
    }
}
