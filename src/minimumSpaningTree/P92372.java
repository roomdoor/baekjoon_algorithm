package minimumSpaningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P92372 {
    public static ArrayList<ArrayList<Integer>> map;
    public static boolean[] isChecked;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            isChecked = new boolean[n + 1];
            map = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                map.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                map.get(start).add(end);
                map.get(end).add(start);
            }

            sb.append(MST(1)).append("\n");

        }

        System.out.println(sb.toString());
    }

    public static int MST(int start) {
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            isChecked[cur] = true;

            for (int next : map.get(cur)) {
                if (!isChecked[next]) {
                    count++;
                    isChecked[next] = true;
                    queue.offer(next);

                }
            }
        }
        return count;
    }
}
