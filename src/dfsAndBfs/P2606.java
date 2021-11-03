package dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2606 {
//    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static boolean[] isChecked;
    public static int count = -1;

    public static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        isChecked[start] = true;

        while (!queue.isEmpty()) {
            count++;
            int y = queue.poll();
            sb.append(y).append(" ");
            for (int x : list.get(y)) {
                if (!isChecked[x]) {
                    queue.add(x);
                    isChecked[x] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        isChecked = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            list.add(arr);
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));

        }

        bfs(1);

        System.out.println(count);
//        System.out.println(sb.toString());

    }

}
