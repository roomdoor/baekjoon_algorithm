package numberTheoryAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1676 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int count = 0;

        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }

        System.out.println(count);
    }
}
