package DandCp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11444 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine());
        long[][] arr = {{1, 1}, {1, 0}};

        if (n == 1 || n == 0) {
            System.out.println(n);
        } else {
            n--;
            System.out.println(matrixCal(n, arr)[0][0] % mod);
        }
    }

    public static int mod = 1000000007;

    public static long[][] matrixCal(long n, long[][] temp) {
        if (n == 1L) {
            return temp;
        }

        long[][] result = matrixCal(n / 2, temp);
        result = multi(result, result);

        if (n % 2 == 1) result = multi(temp, result);

        return result;
    }

    public static long[][] multi(long[][] m1, long[][] m2) {
        long[][] temp = new long[2][2];

        temp[0][0] = ((m1[0][0] * m2[0][0]) + (m1[0][1] * m2[1][0])) % mod;
        temp[0][1] = ((m1[0][0] * m2[0][1]) + (m1[0][1] * m2[1][1])) % mod;
        temp[1][0] = ((m1[1][0] * m2[0][0]) + (m1[1][1] * m2[1][0])) % mod;
        temp[1][1] = ((m1[1][0] * m2[0][1]) + (m1[1][1] * m2[1][1])) % mod;

        return temp;
    }
}
