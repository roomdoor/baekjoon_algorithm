package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9251re {
    public static int[][] LCS;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String A = bf.readLine();
        String B = bf.readLine();
        LCS = new int[A.length() + 1][B.length() + 1];

        makeLCS(A, B);

        System.out.println(LCS[A.length()][B.length()]);
    }

    public static void makeLCS(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    LCS[i + 1][j + 1] = LCS[i][j] + 1;
                } else {
                    LCS[i + 1][j + 1] = Math.max(LCS[i + 1][j], LCS[i][j + 1]);
                }
            }
        }
    }

    public static void print(String A, String B) {
        System.out.print(" ");
        for (int i = 0; i < B.length(); i++) {
            System.out.print(" " + B.charAt(i));
        }
        System.out.println();

        for (int i = 1; i < A.length() + 1; i++) {
            System.out.print(A.charAt(i - 1) + " ");
            for (int j = 1; j < B.length() + 1; j++) {
                System.out.print(LCS[i][j] + " ");
            }
            System.out.println();
        }
    }
}
