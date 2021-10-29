package whilep;

import java.util.Scanner;

public class P1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int b = a;
        int c = 1;
        int d = -1;
        int n = 0;

        while (a != d){
            c = b + b/10;
            d = (b%10)*10 + c%10;
            b = d;
            n++;

        }
        System.out.println(Integer.toString(n));
    }
}
