package treeP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11725 {
    public static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
    public static int[] parentsBFS;
    public static int[] parentsDFS;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        parentsBFS = new int[n + 1];
        parentsDFS = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map.get(start).add(end);
            map.get(end).add(start);
        }

        bfs(1);
//        dfs(1, 0);
        printAnswer(parentsBFS);
//        System.out.println();
//        printAnswer(parentsDFS);


    }

    public static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        parentsBFS[start] = 1;

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            for (int link : map.get(parent)) {
                if (parentsBFS[link] == 0) {
                    parentsBFS[link] = parent;
                    queue.offer(link);
                }
            }
        } // while end
    }

    public static void dfs(int start, int parent) {
        parentsDFS[start] = parent;
        for (int link : map.get(start)) {
            if (link != parent) dfs(link, start);
        }
    }

    public static void printAnswer(int[] parents) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < parents.length; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
