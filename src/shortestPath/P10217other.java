package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P10217other {
    public static ArrayList<ArrayList<Airport>> map;
    public static int[][] timeCost;
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
            timeCost = new int[n + 1][m + 1];

            for (int j = 0; j <= n; j++) {
                map.add(new ArrayList<>());
                Arrays.fill(timeCost[j], INF);
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(bf.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int money = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                map.get(start).add(new Airport(end, money, time));
            }

            dpBfs(m, n);

            int answer = INF;
            for (int j = 0; j < m + 1; j++) {
                answer = Math.min(answer, timeCost[n][j]);
            }

            if (answer == INF) {   // 출력 입력
                sb.append("Poor KCM").append("\n");
            } else {
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void dpBfs(int m, int n) {
        PriorityQueue<Airport> queue = new PriorityQueue<>();
        queue.add(new Airport(1, 0, 0));
        timeCost[1][0] = 0;

        while (!queue.isEmpty()) {
            Airport airport = queue.poll();
            int cur = airport.end;
            int time = airport.timeCost;
            int cost = airport.moneyCost;
            if (cur == n) break;


            for (Airport next : map.get(cur)) {
                int nextAirport = next.end;
                int nextTime = time + next.timeCost;
                int nextMoney = cost + next.moneyCost;

                if (nextMoney > m) continue;
                if (nextTime >= timeCost[nextAirport][nextMoney]) continue;
                for (int i = nextMoney; i < m + 1; i++) {
                    if (timeCost[nextAirport][i] > nextTime) {
                        timeCost[nextAirport][i] = nextTime;
                    }
                }
                queue.add(new Airport(nextAirport, nextMoney, nextTime));
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