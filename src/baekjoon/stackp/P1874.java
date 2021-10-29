package stackp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(bf.readLine());

            while (num <= value) {
                stack.push(num);
                sb.append("+").append("\n");
                num++;
            }

            if (stack.peek() == value) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                System.out.println("NO");
                System.exit(0);
            }
        }

        System.out.println(sb.toString());

    }
}