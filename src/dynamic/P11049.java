package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11049 {
    public static Point[][] DP;
    public static Point[] cost;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        DP = new Point[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(DP[i], new Point(0, 0, INF));
        }
        cost = new Point[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cost[i] = new Point(a, b, 0);
        }
        System.out.println(count(1, n).count);

    }

    public static Point count(int x, int y) {
        if (x == y) {
            return cost[x];
        }


        if (x + 1 == y) {
            return DP[x][y] = new Point(cost[x].a, cost[y].b, cost[x].a * cost[x].b * cost[y].b);
        }

        if (DP[x][y].count != INF) {
            return DP[x][y];
        }

        for (int mid = 1; mid < y; mid++) {
            Point sx = count(x, mid);
            Point ey = count(mid + 1, y);
            int tempCount = sx.a * sx.b * ey.b + sx.count + ey.count;
            if (DP[x][y].count > tempCount) {
                DP[x][y].a = sx.a;
                DP[x][y].b = ey.b;
                DP[x][y].count = tempCount;
            }
        }

        return DP[x][y];
    }

    private static class Point {
        int a;
        int b;
        int count;

        public Point(int a, int b, int count) {
            this.a = a;
            this.b = b;
            this.count = count;
        }
    }

}
