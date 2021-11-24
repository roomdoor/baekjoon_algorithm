package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P10217 {
    public static ArrayList<ArrayList<Airport>> map;
    public static boolean[] isVisited;
    public static long[] timeCost;
    public static long[] montyCost;
    public static StringBuilder sb = new StringBuilder();
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new ArrayList<>();
            isVisited = new boolean[n + 1];
            timeCost = new long[n + 1];
            montyCost = new long[n + 1];

            for (int j = 0; j <= n; j++) {
                map.add(new ArrayList<>());
                timeCost[j] = INF;
                montyCost[j] = INF;
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(bf.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int money = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                map.get(start).add(new Airport(end, money, time));
            }

            bfs(m, n);
            if (timeCost[n] == INF) {
                sb.append("Poor KCM").append("\n");
            } else {
                sb.append(timeCost[n]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void bfs(int m, int n) {
        PriorityQueue<Airport> queue = new PriorityQueue<>();
        queue.add(new Airport(1, 0, 0));
        timeCost[1] = 0;

        while (!queue.isEmpty()) {
            Airport temp = queue.poll();
            int cur = temp.end;
            long money = temp.moneyCost;
            long time = temp.timeCost;
            if (cur == n) {
                timeCost[n] = Math.min(time, timeCost[n]);
                continue;
            }


            for (Airport next : map.get(cur)) {
                int nextAir = next.end;
                long nextMoneyCost = next.moneyCost;
                long nextTimeCost = next.timeCost;

                if (m >= money + nextMoneyCost ) {
                    timeCost[nextAir] = time + nextTimeCost;
                    queue.add(new Airport(nextAir, nextMoneyCost + money, nextTimeCost + time));
                    System.out.println(nextAir);
                    System.out.println("money " + (money + nextMoneyCost) + " time " + (nextTimeCost + time));
                }
            }
        }
    }


    private static class Airport implements Comparable<Airport> {
        int end;
        long moneyCost;
        long timeCost;

        public Airport(int end, long moneyCost, long timeCost) {
            this.end = end;
            this.moneyCost = moneyCost;
            this.timeCost = timeCost;
        }


        @Override
        public int compareTo(Airport o) {
            if (timeCost == o.timeCost) {
                return (int) (moneyCost - o.moneyCost);
            } else {
                return (int) (timeCost - o.timeCost);
            }
        }
    }
}