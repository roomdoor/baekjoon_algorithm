package dynamicAndShortextPathReverse;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int count = 0;
        while (count < 10) {
            if (x < 20) continue;
            x++;
            count++;
        }

        System.out.println(x + " " + count);
    }
}
