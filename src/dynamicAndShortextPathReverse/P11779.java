package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11779 {
    public static ArrayList<ArrayList<BusWay>> map;
    public static int INF = Integer.MAX_VALUE;
    public static int[] TD;
    public static boolean[] isVisited;
    public static int wayCount;
    public static ArrayList<Integer> wayPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        TD = new int[n + 1];
        Arrays.fill(TD, INF);
        isVisited = new boolean[n + 1];
        TD[1] = 0;
        map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            map.get(start).add(new BusWay(end, dis, 0, null));
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        disCount(start, end);

        System.out.println(TD[end]);
        System.out.println(wayCount);
        for (int point : wayPoint) {
            System.out.print(point + " ");
        }
    }

    public static void disCount(int start, int end) {
        PriorityQueue<BusWay> queue = new PriorityQueue<>();
        ArrayList<Integer> trace = new ArrayList<>();
        trace.add(start);
        queue.add(new BusWay(start, 0, 1, trace));

        while (!queue.isEmpty()) {
            BusWay now = queue.poll();
            int cur = now.end;
            int dis = now.dis;
            int count = now.count;
            ArrayList<Integer> path = now.pathTrace;
            if (cur == end) {
                wayCount = path.size();
                wayPoint = path;
                return;
            }

            if (!isVisited[cur]) {
                isVisited[cur] = true;

                for (BusWay temp : map.get(cur)) {
                    if (TD[temp.end] > dis + temp.dis) {
                        TD[temp.end] = dis + temp.dis;
                        path.add(temp.end);
                        ArrayList<Integer> newPath = (ArrayList<Integer>) path.clone();
                        queue.add(new BusWay(temp.end, TD[temp.end], count + 1, newPath));
                        path.remove(count);
                    }
                }
            }
        }
    }

    private static class BusWay implements Comparable<BusWay> {
        int end;
        int dis;
        int count;
        ArrayList<Integer> pathTrace;

        public BusWay(int end, int dis, int count, ArrayList<Integer> pathTrace) {
            this.end = end;
            this.dis = dis;
            this.count = count;
            this.pathTrace = pathTrace;
        }

        @Override
        public int compareTo(BusWay o) {
            return (int) (this.dis - o.dis);
        }
    }
}
