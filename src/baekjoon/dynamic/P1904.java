package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1904 {

    public static StringBuilder sb = new StringBuilder();
    public static int[] fibonacci = new int[1000001];

    public static int binaryMaker(int n) {

        if (n == 1) return 1;

        if (n == 2) return 2;

        else {
            if (fibonacci[n - 1] != 0 && fibonacci[n - 2] != 0)
                fibonacci[n] = (fibonacci[n - 1] + fibonacci[n - 2])  % 15746;

            else {
                fibonacci[n] = (binaryMaker(n - 1) + binaryMaker(n - 2)) % 15746;
            }
            return fibonacci[n];
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        System.out.println(binaryMaker(n));


    }
}

//  1   1                                                               1                   1
//  2   00  11                                                          1   1               2
//  3   001 100 111                                                     1   2               3
//  4   0011    1001    1100    1111    0000                            1   3   1           5
//  5   00001   00100   10000   00111   10011   11100   11111           1   4   3           8
//  6   000000                                                          1   5   6   1       13
//      000011  001001  001100  100100  100001  110000
//      001111  100111  110011  111001  111100
//  7                                                                   1   6   10  4       21
//  8                                                                   1   7   15  10  1   34

