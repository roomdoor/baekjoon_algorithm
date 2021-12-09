package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2618 {
    public static ArrayList<Pointer> accidentPoint;
    public static int[][] DP;
    public static ArrayList<carPoint> CPLOne;
    public static ArrayList<carPoint> CPLTwo;
    public static int n;
    public static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        w = Integer.parseInt(bf.readLine());
        Pointer one = new Pointer(1, 1);
        Pointer two = new Pointer(n, n);

        accidentPoint = new ArrayList<>();
        CPLOne = new ArrayList<>();
        CPLOne.add(new carPoint(one, two));
        CPLOne.add(new carPoint(one, two));
        CPLTwo = new ArrayList<>();
        CPLTwo.add(new carPoint(one, two));
        CPLTwo.add(new carPoint(one, two));
        DP = new int[3][w + 1];
        accidentPoint.add(new Pointer(0, 0));

        for (int i = 0; i < w; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            accidentPoint.add(new Pointer(x, y));
        }

        for (int i = 1; i <= w; i++) {
            SPDP(i);
        }

        System.out.println(Arrays.deepToString(DP));

        System.out.println(Math.min(DP[1][w], DP[2][w]));

    }

    public static void SPDP(int dp) {
        int x = accidentPoint.get(dp).x;
        int y = accidentPoint.get(dp).y;


        Pointer one = CPLOne.get(dp).one;
        Pointer two = CPLOne.get(dp).two;

        if (DP[1][dp - 1] + countDis(x, y, one) > DP[2][dp - 1] + countDis(x, y, one)) {
            DP[1][dp] = DP[2][dp - 1] + countDis(x, y, one);
            CPLOne.add(dp, new carPoint(accidentPoint.get(dp), two));
        } else {
            DP[1][dp] = DP[1][dp - 1] + countDis(x, y, one);
            CPLOne.add(dp, new carPoint(one, accidentPoint.get(dp)));
        }

        one = CPLTwo.get(dp).one;
        two = CPLTwo.get(dp).two;

        if (DP[1][dp - 1] + countDis(x, y, two) > DP[2][dp - 1] + countDis(x, y, two)) {
            DP[2][dp] = DP[2][dp - 1] + countDis(x, y, two);
            CPLTwo.add(dp, new carPoint(accidentPoint.get(dp), two));
        } else {
            DP[2][dp] = DP[1][dp - 1] + countDis(x, y, two);
            CPLTwo.add(dp, new carPoint(one, accidentPoint.get(dp)));
        }
    }

    public static int countDis(int x, int y, Pointer p) {
        int dis = Math.abs(x - p.x) + Math.abs(y - p.y);
        return dis;
    }

    private static class carPoint {
        Pointer one;
        Pointer two;

        public carPoint(Pointer one, Pointer two) {
            this.one = one;
            this.two = two;
        }
    }

    private static class Pointer {
        int x;
        int y;

        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
