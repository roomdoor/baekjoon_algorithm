package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1003 {

    public static int[] fibonacciArr = new int[41];

    public static int fibonacci(int n) {

        if (n == 0) {
            fibonacciArr[0] = 0;
            return 0;
        }
        if (n == 1) {
            fibonacciArr[1] = 1;
            return 1;
        }
        if (n > 0 & (fibonacciArr[n - 1] == 0 || fibonacciArr[n - 2] == 0)) {
            fibonacciArr[n] = fibonacci(n - 1) + fibonacci(n - 2);
        } else {
            fibonacciArr[n] = fibonacciArr[n - 1] + fibonacciArr[n - 2];
        }
        return fibonacciArr[n];

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {

            int num = Integer.parseInt(bf.readLine());
            if (num > 0) {
                System.out.println(fibonacci(num - 1) + " " + fibonacci(num));
            } else System.out.println(1 + " " + 0);
        }
    }
}

//  0           1   0
//  1           0   1
//  2           1   1
//  3           1   2
//  4           2   3
//  5           3   5
//  6           5   8
//  7           8   13
//  8           13  21
//
//0	0
//1	1
//2	1
//3	2
//4	3
//5	5
//6	8
//7	13
//8	21
//9	34
//10	55
//11	89
//12	144
//13	233
//14	377
//15	610
//16	987
//17	1597
//18	2584
//19	4181
//20	6765
//21	10946
//22	17711
//23	28657
//24	46368
//25	75025
//26	121393
//27	196418
//28	317811
//29	514229
//30	832040
//31	1346269
//32	2178309
//33	3524578
//34	5702887
//35	9227465
//36	14930352
//37	24157817
//38	39088169
//39	63245986
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

