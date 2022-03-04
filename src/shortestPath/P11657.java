package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11657 {
    public static ArrayList<ArrayList<Node>> map;
    public static Long[] TD;
    public static boolean[] isVisited;
    public static Long INF = Long.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TD = new Long[N + 1];
        Arrays.fill(TD, INF);
        TD[1] = 0L;
        isVisited = new boolean[N + 1];
        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            map.get(A).add(new Node(B, C));
        }

        if (BMF(N, M)) {
            sb.append(-1).append("\n");
        } else {
            for (int i = 2; i <= N; i++) {
                if (TD[i] != INF) {
                    sb.append(TD[i]).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean BMF(int N, int M) {
        boolean isChecked = false;

        for (int i = 0; i < N - 1; i++) {
            BMFChecked(N, isChecked);
        }

        return BMFChecked(N, isChecked);
    }

    public static boolean BMFChecked(int N, boolean isChecked) {
        for (int i = 1; i <= N; i++) {
            for (Node next : map.get(i)) {
                if (TD[i] != INF && TD[next.end] > TD[i] + next.distance) {
                    TD[next.end] = TD[i] + next.distance;
                    isChecked = true;
                }
            }
        }
        return isChecked;
    }

    private static class Node {
        int end;
        int distance;

        public Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }
}
