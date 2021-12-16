package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2618rr {
    public static int[][] DP;
    public static ArrayList<AccidentPoint> AP;
    public static int n;
    public static int w;
    public static int answer = Integer.MAX_VALUE;
    public static int endX = 0;
    public static int endY = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        w = Integer.parseInt(bf.readLine());

        DP = new int[w + 1][w + 1];
        AP = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            AP.add(new AccidentPoint(x, y));
        }

//        spdp();

        StringBuilder sb = new StringBuilder();
//        System.out.println(answer);
//        System.out.println(endX + " " + endY);

//        for (int i = 0; i < w + 1; i++) {
//            System.out.println(Arrays.toString(DP[i]));
//        }

        Stack<Integer> stack = new Stack<>();

        while (endX != 0 || endY != 0) {
            if (endX > endY) {
                endX -= endY + 1;
                stack.add(1);
            } else {
                endY -= endX + 1;
                stack.add(2);
            }
        }
        sb.append(answer).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append("\n");
        }
        System.out.println(sb.toString());


    }

//    public static int spdp(int dp, int x, int y) {
//        if (dp == w) {
//            return 0;
//        }
//
//        if (DP[x][y] != 0) return DP[x][y];
//
//
//        spdp(dp + 1, dp, y);
//        spdp(dp + 1, x, dp);
//
//
//    }

    public static int countDis(int x, int y, AccidentPoint accidentPoint) {
        return Math.abs(accidentPoint.x - x) + Math.abs(y - accidentPoint.y);
    }


    private static class AccidentPoint {
        int x;
        int y;

        public AccidentPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class carPoint {
        int x1;
        int y1;
        int x2;
        int y2;

        public carPoint(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    private static class Point implements Comparable<Point> {
        int xP;
        int yP;
        carPoint carPoint;
        int distance;
        int point;

        public Point(int xP, int yP, carPoint carPoint, int distance, int point) {
            this.xP = xP;
            this.yP = yP;
            this.carPoint = carPoint;
            this.distance = distance;
            this.point = point;
        }

        @Override
        public int compareTo(Point o) {
            if (point == o.point) return distance - o.distance;
            else return o.point - point;
        }

    }
}
