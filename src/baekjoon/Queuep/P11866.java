package Queuep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class P11866 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            while (count != k - 1) {
                queue.offer(queue.poll());
                count++;
            }
            arr.add(queue.poll());
            count = 0;
        }

        sb.append("<");
        for (int i = 0; i < arr.size(); i++) {
            if (i == arr.size() - 1) sb.append(arr.get(i));
            else sb.append(arr.get(i) + ", ");
        }
        sb.append(">");

        System.out.println(sb.toString());
    }
}
