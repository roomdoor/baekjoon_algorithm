package recrusion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11729 {
    public static Deque<String> trace;
    public static ArrayList<Stack<Integer>> map;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        trace = new ArrayDeque<>();
        map = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            map.add(new Stack<>());
        }
        for (int i = n; i > 0; i--) {
            map.get(0).push(i);
        }

        hanoiTop(n, 3, 3, 0);

        sb.append(num).append("\n");
        int size = trace.size();
        for (int i = 0; i < size; i++) {
            sb.append(trace.poll()).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int hanoiTop(int n, int beforeI, int beforeJ, int num) {
        if (map.get(2).size() == n) {
            return num;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j || (j == beforeI && i == beforeJ)) continue;
                if (isPossible(i, j)) {
                    map.get(j).push(map.get(i).pop());
                    trace.offer(i + " " + j);
                    if (hanoiTop(n, i, j, num + 1) ) {

                    }
                    map.get(i).push(map.get(j).pop());
                    trace.pollLast();
                }
            }
        }
        return false;
    }

    public static boolean isPossible(int i, int j) {
        return !map.get(i).isEmpty() && (map.get(j).isEmpty() || map.get(i).peek() < map.get(j).peek());
    }

}
