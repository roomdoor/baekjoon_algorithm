package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1932 {

    public static int[][] triangle;
    public static int[][] maxTriangle;
    public static int n;


    public static int makeMaxTriangle(int depth, int idx) {

        if (depth == n - 1) {
            return maxTriangle[depth][idx];
        }

        if (maxTriangle[depth][idx] == 0) {
            maxTriangle[depth][idx] = Math.max(makeMaxTriangle(depth + 1, idx), makeMaxTriangle(depth + 1, idx + 1)) + triangle[depth][idx];
        }

        return maxTriangle[depth][idx];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        triangle = new int[n][n];
        maxTriangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
                if (i == n - 1)
                    maxTriangle[i][j] = triangle[i][j];
            }
        }

        System.out.println(makeMaxTriangle(0, 0));

    }
}

