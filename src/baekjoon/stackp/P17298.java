package stackp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        Stack<Integer> answer = new Stack<>();
        int[] arr = new int[n];
        int NGE = -1;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            stack.push(Integer.valueOf(st.nextToken()));
        }

        for (int i = 0; i < n; i++) {

            while (true) {
                if (tempStack.empty() || stack.peek() >= tempStack.peek()) {
                    if (tempStack.empty()) {
                        answer.push(-1);
                        tempStack.push(stack.pop());
                        break;
                    } else tempStack.pop();
                } else {
                    int temp = stack.pop();
                    answer.push(tempStack.peek());
                    tempStack.push(temp);
                    break;
                }
            }
        }

        while (!answer.empty()){
            sb.append(answer.pop()).append(" ");
        }

        System.out.println(sb.toString());

//        시간초과
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                if (arr[i] < arr[j]) {
//                    sb.append(arr[j]).append(" ");
//                    break;
//                } else if (j == n - 1) {
//                    sb.append(-1).append(" ");
//                }
//            }
//        }

        System.out.println(sb.toString());

    }
}
