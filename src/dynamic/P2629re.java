package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2629re {
    public static int[] weight;
    public static boolean[] isChecked;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = STI(bf.readLine());
        weight = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = STI(st.nextToken());
        }

        int marble = STI(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < marble; i++) {
            int m = STI(st.nextToken());
            isChecked = new boolean[n];
        }

        System.out.println(sb.toString());
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(weight[0]);

        while (!queue.isEmpty()) {
            int newNum = queue.poll();
            isChecked[newNum] = true;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                if (!isChecked[newNum *])
                    queue.offer()
            }

        }


    }


    public static int STI(String s) {
        return Integer.parseInt(s);
    }
}
