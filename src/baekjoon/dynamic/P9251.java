package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9251 {

    public static char[] s1Arr;
    public static char[] s2Arr;
    public static Integer[][] lcs;

    public static int LCS(int x, int y) {

        if (x < 0 | y < 0)
            return 0;

        if (lcs[x][y] == null) {
            lcs[x][y] = 0;

            if (s1Arr[x] == s2Arr[y]) {
                lcs[x][y] = LCS(x - 1, y - 1) + 1;
            } else lcs[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
        }
        return lcs[x][y];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s1 = bf.readLine();
        String s2 = bf.readLine();

        int n1 = s1.length();
        int n2 = s2.length();

        s1Arr = new char[n1];
        s2Arr = new char[n2];
        lcs = new Integer[n1][n2];

        int max = Math.max(n1, n2);

        for (int i = 0; i < max; i++) {
            if (i < n1)
                s1Arr[i] = s1.charAt(i);

            if (i < n2)
                s2Arr[i] = s2.charAt(i);
        }

        System.out.println(LCS(n1 - 1, n2 - 1));


    }
}
