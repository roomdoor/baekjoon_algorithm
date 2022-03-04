package recrusion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            deque.offer(i);
            queue.offer(i);
            stack.push(i);
            System.out.println("D : " + deque.toString());
            System.out.println("Q : " + queue.toString());
            System.out.println("S : " + stack.toString());
            System.out.println();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("D : " + deque.pollLast());
            System.out.println("Q ; " + queue.poll());
            System.out.println("S : " + stack.pop());
            System.out.println();
        }

    }
}
