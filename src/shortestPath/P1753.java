package shortestPath;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1753 {
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Node>[] map;
    public static boolean[] isVisited;
    public static int[] totalDistance;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int firstPoint = Integer.parseInt(bf.readLine());


        map = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) map[i] = new ArrayList<>();
        totalDistance = new int[v + 1];
        Arrays.fill(totalDistance, Integer.MAX_VALUE);
        totalDistance[firstPoint] = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            map[start].add(new Node(end, distance));
        }

        for (int i = 1; i <= v; i++) {
            bfs(firstPoint, i, v);
            if (totalDistance[i] != Integer.MAX_VALUE) sb.append(totalDistance[i]).append("\n");
            else sb.append("INF").append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void bfs(int start, int end, int v) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start, 0));
        isVisited = new boolean[v + 1];

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;
            int distance = curNode.distance;
            if (cur == end) return;

            if (!isVisited[cur]) {
                isVisited[cur] = true;

                for (Node node : map[cur]) {
                    if (totalDistance[node.end] > distance + node.distance) {
                        totalDistance[node.end] = distance + node.distance;
                        queue.add(new Node(node.end, totalDistance[node.end]));
                    }
                }
            }


        }
    }

    private static class Node {
        int end;
        int distance;

        public Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }
}
