package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int temp = 0;
        Integer min = null;


        StringTokenizer sub = new StringTokenizer(bf.readLine(), "-");

        while (sub.hasMoreTokens()) {

            StringTokenizer sum = new StringTokenizer(sub.nextToken(), "+");

            while (sum.hasMoreTokens())
                temp += Integer.parseInt(sum.nextToken());


            if (min == null) min = temp;
            else min -= temp;
            temp = 0;

        }

        System.out.println(min);


    }
}
