package treeP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4803 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) return;

            ArrayList<ArrayList<Integer>> map = new ArrayList<>();
            int[] isVisited = new int[n + 1];
            for (int i = 0; i < n + 1; i++) map.add(new ArrayList<>());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                int one = Integer.parseInt(st.nextToken());
                int two = Integer.parseInt(st.nextToken());
                map.get(one).add(two);
                map.get(two).add(one);
            }

            int count = treeCheck(n, m, map, isVisited, 0);

            print(count, caseNum);

            caseNum++;
        }
    }

    public static int treeCheck(int n, int m, ArrayList<ArrayList<Integer>> map, int[] isVisited, int count) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean isPossible = true;

        for (int i = 1; i <= n; i++) {
            if (isVisited[i] == 0) {
                isPossible = true;
                queue.offer(i);
                isVisited[i] = i;
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int temp : map.get(cur)) {
                        if (isVisited[temp] == 0) {
                            isVisited[temp] = cur;
                            queue.offer(temp);
                        } else if (temp != isVisited[cur]) {
                            isPossible = false;
                            break;
                        }
                    }
                }
                if (isPossible) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void print(int count, int caseNum) {
        if (count == 0) {
            System.out.println("Case " + caseNum + ": No trees.");
        } else if (count == 1) {
            System.out.println("Case " + caseNum + ": There is one tree.");
        } else {
            System.out.println("Case " + caseNum + ": A forest of " + count + " trees.");
        }
    }
}
