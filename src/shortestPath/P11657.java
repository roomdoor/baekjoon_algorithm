package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class P11657 {
    public static ArrayList<ArrayList<Node>> map;
    public static Long[] TD;
    public static Long INF = Long.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TD = new Long[N + 1];
        map = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            map.add(new ArrayList<>());
            TD[i] = INF;
        }
        TD[1] = 0L;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            map.get(A).add(new Node(B, C));
        }

        if (BMF(N)) sb.append(-1);
        else {
            for (int i = 2; i <= N; i++) {
                if (Objects.equals(TD[i], INF)) sb.append(-1).append("\n");
                else sb.append(TD[i]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static boolean BMF(int N) {
        boolean isChanged = false;
        for (int k = 0; k < N - 1; k++) {
            isChanged = false;

            for (int i = 1; i <= N; i++) {
                for (Node next : map.get(i)) {

                    if (Objects.equals(TD[i], INF)) break;

                    if (TD[next.end] > TD[i] + next.distance) {
                        TD[next.end] = TD[i] + next.distance;
                        isChanged = true;
                    }
                }
            }
            if (!isChanged) break;
        }

        if (isChanged) {
            for (int i = 1; i <= N; i++) {
                for (Node next : map.get(i)) {
                    if (Objects.equals(TD[i], INF)) break;
                    if (TD[next.end] > TD[i] + next.distance) {
                        TD[next.end] = TD[i] + next.distance;
                        return true;
                    }
                }
            }
        }

        return false;
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