package Queuep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P18258 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            String method = st.nextToken();

            switch (method) {

                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    queue.offer(num);
                    break;

                case "pop":
                    if (queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.poll()).append("\n");
                    break;

                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    if (queue.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;

                case "front":
                    if (queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.peek()).append("\n");
                    break;

                case "back":
                    if (queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.peekLast()).append("\n");
                    break;

            }
        }

        System.out.println(sb.toString());

    }
}
