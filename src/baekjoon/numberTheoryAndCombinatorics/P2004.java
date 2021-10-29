package numberTheoryAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2004 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        long five = calFive(a) - calFive(b) - calFive(a - b);
        long two = calTwo(a) - calTwo(b) - calTwo(a - b);
        System.out.println(Math.min(five, two));

    }

    public static long calFive(long n) {
        long count = 0;

        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }


    public static long calTwo(long n) {
        long count = 0;

        while (n >= 2) {
            count += n / 2;
            n /= 2;
        }
        return count;
    }
}
