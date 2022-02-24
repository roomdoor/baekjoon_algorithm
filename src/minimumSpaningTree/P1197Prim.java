package minimumSpaningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1197Prim {
    public static List<List<Node>> map;
    public static boolean[] isVisited;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        isVisited = new boolean[v];
        map = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            map.get(start).add(new Node(end, cost));
            map.get(end).add(new Node(start, cost));
        }

        for (List<Node> list : map) {
            Collections.sort(list);
        }
        prim(0);
        System.out.println(answer);
    }

    public static void prim(int cur) {
        if (isVisited[cur]) {
            return;
        }
        isVisited[cur] = true;
        for (Node next : map.get(cur)) {
            if (!isVisited[next.b]) {
                answer += next.cost;
                prim(next.b);
                isVisited[next.b] = true;
            }
        }
    }


    private static class Node implements Comparable<Node> {
        int b;
        int cost;

        public Node(int b, int cost) {
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
