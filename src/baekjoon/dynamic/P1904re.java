package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1904re {

    public static int[] arr = new int[1000002];

    public static int fibo(int n) {

        if (arr[n] == 0) {
            arr[n] = fibo(n - 1) + fibo(n - 2);
            return arr[n] % 15746;
        }
        return arr[n] % 15746;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        arr[0] = 1;
        arr[1] = 2;

        System.out.println(fibo(n -1));

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

