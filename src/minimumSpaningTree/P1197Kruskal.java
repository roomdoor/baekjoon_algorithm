package minimumSpaningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1197Kruskal {
    public static ArrayList<ArrayList<Point>> map;
    public static boolean[] isVisited;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        isVisited = new boolean[v];
        map = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            map.get(a).add(new Point(b, c, 0));
            map.get(b).add(new Point(a, c, 0));
        }
        System.out.println(MST(v));

    }

    public static int MST(int v) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        Point start = new Point(1, 0, 1);
        queue.offer(start);
        int result = 0;

        while (!queue.isEmpty()) {

        }
        return
    }

    private static class Point implements Comparable<Point> {
        int b;
        int cost;
        int count;

        public Point(int b, int cost, int count) {
            this.b = b;
            this.cost = cost;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {
            if (this.cost - o.cost == 0) {
                return o.count - this.count;
            }

            return this.cost - o.cost;
        }
    }


}
