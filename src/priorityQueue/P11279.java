package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11279 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());


        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(bf.readLine());
            switch (x) {

                case 0:
                    if (queue.isEmpty()) {
                        sb.append(0).append("\n");
                    } else {
                        sb.append(queue.poll()).append("\n");
                    }
                    break;

                default:
                    queue.add(x);
            }
        }

        System.out.println(sb.toString());
    }
}
