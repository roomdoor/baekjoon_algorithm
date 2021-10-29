package math2P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        double r = Double.parseDouble(bf.readLine());

        double num1 = r * r * Math.PI;
        double num2 = r * r * 2;

        System.out.println(num1);
        System.out.println(num2);
    }
}
