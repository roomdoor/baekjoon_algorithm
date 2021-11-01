package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149 {
    public static int n;
    public static int[][] RGBprice;
    public static int[][] minPrice;

    public static int makeMin(int depth, int idx) {

        if (minPrice[depth][idx] == 0) {

            if (idx == 0)
                minPrice[depth][idx] = Math.min(makeMin(depth - 1, 1), makeMin(depth - 1, 2)) + RGBprice[depth][idx];
            else if (idx == 1)
                minPrice[depth][idx] = Math.min(makeMin(depth - 1, 0), makeMin(depth - 1, 2)) + RGBprice[depth][idx];
            else
                minPrice[depth][idx] = Math.min(makeMin(depth - 1, 0), makeMin(depth - 1, 1)) + RGBprice[depth][idx];
        }
        return minPrice[depth][idx];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        RGBprice = new int[n][3];
        minPrice = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            RGBprice[i][0] = Integer.parseInt(st.nextToken());
            RGBprice[i][1] = Integer.parseInt(st.nextToken());
            RGBprice[i][2] = Integer.parseInt(st.nextToken());
        }

        minPrice[0][0] = RGBprice[0][0];
        minPrice[0][1] = RGBprice[0][1];
        minPrice[0][2] = RGBprice[0][2];

        System.out.println(Math.min(makeMin(n - 1, 0), Math.min(makeMin(n - 1, 1), makeMin(n - 1, 2))));
    }
}
