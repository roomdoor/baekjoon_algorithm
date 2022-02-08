package dfsAndBfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1707 {
    public static ArrayList<ArrayList<Integer>> map;
    public static int[] isChecked;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bf.readLine());
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            isChecked = new int[v + 1];
            map = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                map.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(bf.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                map.get(start).add(end);
                map.get(end).add(start);
            }

            makeAnswer(bfs(1, v));
        }

        System.out.println(sb.toString());
    }

    public static boolean bfs(int start, int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        isChecked[start] = 1;
        int bipartiteGraph = -1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : map.get(cur)) {
                if (isChecked[next] == isChecked[cur]) {
                    return false;
                }
                if (isChecked[next] == 0) {
                    isChecked[next] = bipartiteGraph;
                    queue.offer(next);
                }
            }
            bipartiteGraph *= -1;
        }

        for (int i = 1; i <= v; i++) {
            if (isChecked[i] == 0) {
                return bfs(i, v);
            }
        }
        return true;
    }

    private static void makeAnswer(boolean bfs) {
        if (bfs) {
            sb.append("YES").append("\n");
        } else {
            sb.append("NO").append("\n");
        }
    }
}
