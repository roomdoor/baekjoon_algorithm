package treeP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1967 {

    public static ArrayList<ArrayList<Node>> linked = new ArrayList<>();
    public static boolean[] isVisited;
    public static int n;
    public static int max;
    public static int idxMax;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n + 1; i++) {
            linked.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            linked.get(p).add(new Node(c, d));
            linked.get(c).add(new Node(p, d));
        }

        bfs(5, 0);

//        System.out.println(max +" " + idxMax);
        bfs(idxMax, 0);

        System.out.println(max);
    }

    public static void bfs(int idx, int dis) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(idx, dis));
        isVisited = new boolean[n + 1];
        isVisited[idx] = true;
        max = 0;
        idxMax = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node next : linked.get(cur.b)) {
                if (!isVisited[next.b]) {
                    isVisited[next.b] = true;
                    queue.offer(new Node(next.b, cur.dis + next.dis));
                    if (max < cur.dis + next.dis) {
                        max = cur.dis + next.dis;
                        idxMax = next.b;
                    }
                }
            }
        }
    }

    private static class Node {
        int b;
        int dis;

        public Node(int b, int dis) {
            this.b = b;
            this.dis = dis;
        }
    }
}
