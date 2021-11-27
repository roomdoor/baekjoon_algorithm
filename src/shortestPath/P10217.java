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
    public static int[] timeCost;
    public static int[] montyCost;
    public static StringBuilder sb = new StringBuilder();
    public static int INF = Integer.MAX_VALUE;
    public static PriorityQueue<Airport> queue = new PriorityQueue<>();


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
            timeCost = new int[n + 1];
            montyCost = new int[n + 1];

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
            queue.add(new Airport(1, 0, 0));
            timeCost[1] = 0;

            dpBfs(m, n, INF);

            if (timeCost[n] == INF) {   // 출력 입력
                sb.append("Poor KCM").append("\n");
            } else {
                sb.append(timeCost[n]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void dpBfs(int m, int n, int beforeTimeCost) {
        if (!queue.isEmpty()) {
            Airport temp = queue.poll();
            int cur = temp.end;
            int money = temp.moneyCost;
            int time = temp.timeCost;
            if (cur == n) {
                return;
            }

            for (Airport next : map.get(cur)) {
                int nextAir = next.end;
                int nextMoneyCost = next.moneyCost;
                int nextTimeCost = next.timeCost;

                if (m >= money + nextMoneyCost) {
                    if (timeCost[nextAir] > time + nextTimeCost) {
                        int bTimeCost = timeCost[nextAir];
                        timeCost[nextAir] = time + nextTimeCost;
                        queue.add(new Airport(nextAir, nextMoneyCost + money, nextTimeCost + time));
                        dpBfs(m, n, bTimeCost);
                    }
                } else {
                    timeCost[cur] = beforeTimeCost;
                    return;
                }
            }
        }
    }


    private static class Airport implements Comparable<Airport> {
        int end;
        int moneyCost;
        int timeCost;

        public Airport(int end, int moneyCost, int timeCost) {
            this.end = end;
            this.moneyCost = moneyCost;
            this.timeCost = timeCost;
        }


        @Override
        public int compareTo(Airport o) {
            if (timeCost == o.timeCost) {
                return (moneyCost - o.moneyCost);
            } else
                return (timeCost - o.timeCost);
        }
    }
}