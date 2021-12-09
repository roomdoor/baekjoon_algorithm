package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2618r {
    public static ArrayList<Pointer> accidentPoint;
    public static int[][] DP;
    public static int n;
    public static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        w = Integer.parseInt(bf.readLine());

        accidentPoint = new ArrayList<>();
        DP = new int[w + 1][w + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < w; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            accidentPoint.add(new Pointer(x, y));
        }


    }

    public static void SPDP() {

    }

    public static int countDis(int x, int y, Pointer p) {
        return Math.abs(x - p.x) + Math.abs(y - p.y);
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
