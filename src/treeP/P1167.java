package treeP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1167 {
    public static ArrayList<ArrayList<Node>> linkMap = new ArrayList<>();
    public static boolean[] isVisited;
    public static int v;
    private static long max;
    private static int idxMax;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        v = Integer.parseInt(bf.readLine());

        for (int i = 0; i < v + 1; i++) {
            linkMap.add(new ArrayList<>());
        }

        for (int i = 1; i <= v; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            while (s != -1) {
                int dis = Integer.parseInt(st.nextToken());
                linkMap.get(n).add(new Node(s, dis));
                s = Integer.parseInt(st.nextToken());
            }
        }

//        for (int i = 1; i <= v; i++) {
//            bfs(i);
//            System.out.println(i + "부터 " + max + " " + idxMax);
//            bfs(idxMax);
//            System.out.println(max);
//        }

        bfs(1);
        bfs(idxMax);
        System.out.println(max);

    }

    public static void bfs(int idx) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(idx, 0));
        isVisited = new boolean[v + 1];
        isVisited[idx] = true;
        max = 0;
        idxMax = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node next : linkMap.get(cur.b)) {
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
        long dis;

        public Node(int b, long dis) {
            this.b = b;
            this.dis = dis;
        }
    }
}
