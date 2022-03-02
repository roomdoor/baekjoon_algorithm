package xxprogramers.xxxSWM.testP;

import java.util.Scanner;

public class testP {
    public static void main(String args[]) {
        String x;
        Scanner sc = new Scanner(System.in);

        x = sc.next();

        String[] laserList = x.split("");

        int boobChecked = 0;
        for (String laser : laserList) {
            if (laser.equals("(")) {
                boobChecked++;
            } else {
                boobChecked--;
            }
        }

        if (boobChecked == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
