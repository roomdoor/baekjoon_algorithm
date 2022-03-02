package xxprogramers.xxxKDT.p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionRERE {
    public static int[] solution(int n, int[] passenger, int[][] train) {
        List<List<Integer>> map = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] trains : train) {
            map.get(trains[0]).add(trains[1]);
            map.get(trains[1]).add(trains[0]);
        }

        boolean[] isVisited = new boolean[n + 1];

        int[] maxStation = {0, 0};
        return dfs(1, passenger[0], passenger, map, maxStation, isVisited);
    }


    static int[] dfs(int cur, int p, int[] passengers, List<List<Integer>> map, int[] maxStation, boolean[] isVisited) {
        if (isVisited[cur]) return maxStation;
        isVisited[cur] = true;
        if (maxStation[1] < p) {
            maxStation[0] = cur;
            maxStation[1] = p;
        } else if (maxStation[1] == p && maxStation[0] < cur) {
            maxStation[0] = cur;
        }

        for (int next : map.get(cur)) {
            if (!isVisited[next]) {
                maxStation = dfs(next, p + passengers[next - 1], passengers, map, maxStation, isVisited);
                isVisited[next] = false;
            }
        }
        return maxStation;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] p = new int[]{1, 1, 1, 1, 1, 1};
        int[][] train = new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}, {5, 6}, {3, 4}};

        System.out.println(Arrays.toString(solution(n, p, train)));
    }
}
