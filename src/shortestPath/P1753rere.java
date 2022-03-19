package shortestPath;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1753rere {
    public static List<List<Node>> map;
    public static boolean[] isVisited;
    public static int[] DP;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(bf.readLine());

        map = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            map.add(new ArrayList<>());
        }
        isVisited = new boolean[v + 1];
        DP = new int[v + 1];
        Arrays.fill(DP, INF);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map.get(start).add(new Node(end, cost));
        }
        dijkstra(k);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (DP[i] != INF) {
                sb.append(DP[i]).append("\n");
            } else {
                sb.append("INF").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static void dijkstra(int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(k, 0));
        DP[k] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (isVisited[cur.end]) continue;
            isVisited[cur.end] = true;

            for (Node next : map.get(cur.end)) {
                if (DP[next.end] > cur.cost + next.cost) {
                    DP[next.end] = cur.cost + next.cost;
                    queue.add(new Node(next.end, DP[next.end]));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
