package minimumSpaningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1197Kruskal {
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parents = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            queue.offer(new Node(start, end, cost));
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int newStart = find(cur.start);
            int newEnd = find(cur.end);
            int cost = cur.cost;

            if (newStart != newEnd) {
                answer += cost;
                union(cur.start, cur.end);
            }
        }

        System.out.println(answer);
    }

    public static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }


    private static class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}

//7 9
//1 2 29
//1 5 75
//2 3 35
//2 6 34
//3 4 7
//4 6 23
//4 7 13
//5 6 53
//6 7 25