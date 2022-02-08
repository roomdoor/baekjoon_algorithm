package minimumSpaningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1197 {
    public static ArrayList<ArrayList<Point>> map;
    public static boolean[] isChecked;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        isChecked = new boolean[v];
        map = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            map.get(a).add(new Point(b, c));
            map.get(b).add(new Point(a, c));
        }
        System.out.println(MST(v));

    }

    public static int MST(int v) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        Point start = new Point(2, 0);
        queue.offer(start);
        int answer1 = 0;
        int answer2 = 0;
        int mstCount = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            isChecked[cur.b] = true;
            for (Point next : map.get(cur.b)) {
                if (!isChecked[next.b]) {
                    int nextCost = cur.cost + next.cost;
                    answer1 = nextCost;
                    if (mstCount < v - 1) {
                        answer2 += nextCost;
                    }
                    mstCount++;
                    queue.offer(new Point(next.b, nextCost));
                }
            }
        }

        return Math.min(answer1, answer2);
    }

    private static class Point implements Comparable<Point> {
        int b;
        int cost;

        public Point(int b, int cost) {
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }


}
