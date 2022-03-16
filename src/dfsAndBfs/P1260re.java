package dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1260re {
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map.get(start).add(end);
            map.get(end).add(start);
        }

        for (int i = 1; i <= n; i++) {
            if (map.get(i).size() > 1) {
                Collections.sort(map.get(i));
            }
        }

        isVisited = new boolean[n + 1];
        dfs(v);
        sb.append("\n");
        isVisited = new boolean[n + 1];
        bfs(v);

        System.out.println(sb.toString());
    }

    public static void dfs(int start) {
        if (isVisited[start]) {
            return;
        }

        sb.append(start).append(" ");
        isVisited[start] = true;

        for (int next : map.get(start)) {
            if (!isVisited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for (int next : map.get(cur)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
