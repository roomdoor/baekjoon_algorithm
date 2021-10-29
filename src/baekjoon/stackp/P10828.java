package stackp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        stack = new int[n];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            String method = st.nextToken();

            switch (method) {

                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;

                case "pop":
                    sb.append(pop()).append("\n");
                    break;

                case "size":
                    sb.append(size()).append("\n");
                    break;

                case "empty":
                    sb.append(empty()).append("\n");
                    break;

                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }

        Stack stack1 = new Stack();

        System.out.println(sb.toString());


    }

    public static int[] stack;
    public static int size = 0;

    public static void push(int num) {
        stack[size] = num;
        size++;
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        }
        int temp = stack[size - 1];
        stack[size - 1] = 0;
        size--;
        return temp;
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        } else
            return 0;
    }

    public static int top() {
        if (size == 0) {
            return -1;
        }
        return stack[size - 1];
    }
}
