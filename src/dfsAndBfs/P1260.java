package dfsAndBfs;

import javafx.print.Collation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1260 {
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static boolean[] isChecked;

    public static void dfs(int x) {
        if (isChecked[x])
            return;

        isChecked[x] = true;
        sb.append(x).append(" ");
        for (int arr : list.get(x)) {
            if (!isChecked[arr]) {
                dfs(arr);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        isChecked[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(" ");
            for (int y : list.get(x))
                if (!isChecked[y]) {
                    isChecked[y] = true;
                    queue.add(y);
                }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            list.add(arrayList);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }

        for (int i = 1; i <= n; i++)
            Collections.sort(list.get(i));


        isChecked = new boolean[n + 1];
        dfs(v);

        sb.append("\n");

        isChecked = new boolean[n + 1];
        bfs(v);

        System.out.println(sb.toString());
    }
}
