package stackp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            String ps = bf.readLine();
            sb.append(VPSTest(ps)).append("\n");
        }

        System.out.println(sb.toString());

    }

    public static String VPSTest(String ps) {
        Stack<Integer> stack = new Stack<>();

        for (int j = 0; j < ps.length(); j++) {

            if (ps.charAt(j) == '(')
                stack.push(1);

            else if (stack.empty())
                return "NO";

            else
                stack.pop();
        }

        if (stack.empty()) return "YES";
        else return "NO";
    }
}

