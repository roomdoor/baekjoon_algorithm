package dynamicAndShortextPathReverse;

import java.io.*;
import java.util.*;

public class P2618rr {
    public static int[][] DP;
    public static int[][] AP;
    public static int n;
    public static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        w = Integer.parseInt(bf.readLine());

        DP = new int[w + 1][w + 1];
        AP = new int[w + 1][2];
        for (int i = 1; i <= w; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            AP[i][0] = Integer.parseInt(st.nextToken());
            AP[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = spdp(1, 0, 0);
        System.out.println(answer);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < w + 1; i++) {
            System.out.println(Arrays.toString(DP[i]));
        }

        int firstPoint = 0;
        int secondPoint = 0;
        int point = 1;
        while (point <= w) {
            if (DP[firstPoint][secondPoint] - countDis(firstPoint, point, 1) == DP[point][secondPoint]) {
                firstPoint = point;
                point++;
                sb.append(1).append("\n");
            } else {
                secondPoint = point;
                point++;
                sb.append(2).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static int spdp(int ap, int x, int y) {
        if (ap > w) {
            return 0;
        }

        if (DP[x][y] != 0) {
            return DP[x][y];
        }


        int one = spdp(ap + 1, ap, y) + countDis(x, ap, 1);

        int two = spdp(ap + 1, x, ap) + countDis(y, ap, 2);


        return DP[x][y] = Math.min(one, two);
    }

    public static int countDis(int start, int end, int type) {
        int x_start = AP[start][0];
        int y_start = AP[start][1];
        int x_end = AP[end][0];
        int y_end = AP[end][1];

        if (start == 0) {
            if (type == 1) {
                x_start = 1;
                y_start = 1;
            } else {
                x_start = n;
                y_start = n;
            }
        }
        return Math.abs(x_end - x_start) + Math.abs(y_end - y_start);
    }
}
