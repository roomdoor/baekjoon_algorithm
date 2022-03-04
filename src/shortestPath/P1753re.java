package shortestPath;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753re {
    public static ArrayList<ArrayList<Node>> map;
    public static boolean[] isVisited;
    public static int[] TD;
    public static int INF = Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(bf.readLine());

        map = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            map.add(new ArrayList<>());
        }
        isVisited = new boolean[V + 1];
        TD = new int[V + 1];
        Arrays.fill(TD, INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(u).add(new Node(v, w));
        }
        dijkstra(K);

        for (int i = 1; i <= V ; i++) {
            if (TD[i] != INF) {
                sb.append(TD[i]).append("\n");
            } else {
                sb.append("INF").append("\n");
            }
        }

        System.out.println(sb.toString());

    }

    public static void dijkstra(int K) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, 0));
        TD[K] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;
            int nowDis = curNode.distance;
            if (isVisited[cur]) continue;
            isVisited[cur] = true;

            for (Node node : map.get(cur)) {
                if (TD[node.end] > nowDis + node.distance) {
                    TD[node.end] = nowDis + node.distance;
                    queue.add(new Node(node.end, TD[node.end]));
                }
            }
        }
    }


    private static class Node implements Comparable<Node> {
        int end;
        int distance;

        public Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}
//4 6
//1
//1 2 3
//2 3 3
//3 4 1
//1 3 5
//2 4 5
//1 4 4