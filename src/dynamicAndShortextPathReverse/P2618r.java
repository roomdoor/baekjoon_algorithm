package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2618r {
    public static int[][] DP;
    public static int[][] AP;
    public static int n;
    public static int w;
    public static int endX;
    public static int endY;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        w = Integer.parseInt(bf.readLine());

        DP = new int[w + 1][w + 1];
        AP = new int[w + 1][2];
        for (int i = 1; i <= w; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            AP[i][0] = x;
            AP[i][1] = y;
        }

        spdp(1, 0, 0);


        for (int i = 0; i <= w; i++) {
            System.out.println(Arrays.toString(DP[i]));
        }

        System.out.println(answer);

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (endX != 0 || endY != 0) {
            if (endX > endY) {
                endX -= endY + 1;
                stack.push(1);
            } else {
                endY -= endX + 1;
                stack.push(2);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append("\n");
        }

        System.out.println(sb.toString());


    }

    public static void spdp(int dp, int x, int y) {
        if (dp > w) {
            if (answer > DP[x][y]) {
                answer = DP[x][y];
                endX = x;
                endY = y;
            }
            return;
        }

        DP[dp][y] = DP[x][y] + dis(x, dp, 1);
        DP[x][dp] = DP[x][y] + dis(y, dp, 2);

        spdp(dp + 1, dp, y);
        spdp(dp + 1, x, dp);
    }

    public static int dis(int start, int end, int type) {
        int star_x = AP[start][0];
        int start_y = AP[start][1];
        int end_x = AP[end][0];
        int end_y = AP[end][1];

        if (start == 0) {
            if (type == 1) {
                star_x = 1;
                start_y = 1;
            } else {
                star_x = n;
                start_y = n;
            }
        }
        return Math.abs(star_x - end_x) + Math.abs(start_y - end_y);
    }
}
