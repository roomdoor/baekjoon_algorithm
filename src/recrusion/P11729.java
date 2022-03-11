package recrusion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11729 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        hanoi(n, 1, 3, 2);


        int answer = (int) Math.pow(2, n) - 1;
        System.out.println(answer);
        System.out.println(sb.toString());

    }

    public static void hanoi(int n, int start, int end, int non) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        hanoi(n - 1 , start, non, end);

        sb.append(start).append(" ").append(end).append("\n");

        hanoi(n - 1, non, end, start);
    }
}
