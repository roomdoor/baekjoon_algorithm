package whilep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1110re {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int temp = 0;
        int count = 1;
        temp = n;
        temp = (n / 10 + n % 10) % 10 + (n % 10) * 10;

        while (temp != n) {
            temp = (temp / 10 + temp % 10) % 10 + (temp % 10) * 10;
            count++;
        }

        System.out.println(count);


    }
}
