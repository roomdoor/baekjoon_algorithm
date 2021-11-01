package stackp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String sentence = "1";

        while (true) {
            sentence = bf.readLine();
            if (sentence.equals(".")) break;
            sb.append(VPSTest(sentence)).append("\n");


        }

        System.out.println(sb.toString());
    }

    public static String VPSTest(String ps) {
        Stack<Character> stack = new Stack<>();


        for (int j = 0; j < ps.length(); j++) {
            char c = ps.charAt(j);

            if (c == '[' || c == '(') stack.push(c);

            else if (c == ')') {
                if (stack.empty() || stack.peek() != '(')
                    return "no";

                else stack.pop();
            } else if (c == ']') {
                if (stack.empty() || stack.peek() != '[')
                    return "no";

                else stack.pop();
            }
        }

        if (stack.empty()) return "yes";
        else return "no";
    }
}
