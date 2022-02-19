package xxprogramers.xxxKDT.p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static int[] solution(int n, int[] passenger, int[][] train) {
        List<List<Integer>> map = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] trains : train) {
            map.get(trains[0]).add(trains[1]);
            map.get(trains[1]).add(trains[0]);
        }

        return bfs(passenger, map);
    }


    static int[] bfs(int[] passengers, List<List<Integer>> map) {
        PriorityQueue<Station> queue = new PriorityQueue<>();

        queue.add(new Station(1, passengers[0]));
        boolean[] isVisited = new boolean[passengers.length + 1];
        isVisited[1] = true;

        int[] maxStation = {0, 0};

        while (!queue.isEmpty()) {
            Station cur = queue.poll();

            for (int next : map.get(cur.num)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.add(new Station(next, cur.passenger + passengers[next - 1]));

                    if (maxStation[1] == cur.passenger + passengers[next - 1]) {
                        if (maxStation[0] < next) {
                            maxStation[0] = next;
                        }
                    } else if (maxStation[1] < cur.passenger + passengers[next - 1]) {
                        maxStation[0] = next;
                        maxStation[1] = cur.passenger + passengers[next - 1];
                    }
                }
            }
        }

        return maxStation;
    }

    private static class Station implements Comparable<Station> {
        int passenger;
        int num;

        public Station(int num, int passenger) {
            this.num = num;
            this.passenger = passenger;
        }

        @Override
        public String toString() {
            return "Station{" +
                    "passenger=" + passenger +
                    ", num=" + num +
                    '}';
        }

        @Override
        public int compareTo(Station o) {
            return o.passenger - this.passenger;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[] p = new int[]{1, 1, 1, 1, 1, 1};
        int[][] train = new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}};

        System.out.println(Arrays.toString(solution(n, p, train)));
    }
}
