package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9019r {
    public static int[] trace;
    public static String[] traceS;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());

        for (int i = 0; i < testCase; i++) {
            trace = new int[10001];
            Arrays.fill(trace, -1);
            traceS = new String[10001];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bfs(a, b);
            print(a, b);
            System.out.println(sb.reverse().toString());

        }
    }

    public static void bfs(int a, int b) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(a);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == b) return;

            int d = D(cur);
            int s = S(cur);
            int l = L(cur);
            int r = R(cur);

            if (trace[d] == -1) {
                queue.offer(d);
                trace[d] = cur;
                traceS[d] = "D";
            }

            if (trace[s] == -1) {
                queue.offer(s);
                trace[s] = cur;
                traceS[s] = "S";
            }

            if (trace[l] == -1) {
                queue.offer(l);
                trace[l] = cur;
                traceS[l] = "L";
            }

            if (trace[r] == -1) {
                queue.offer(r);
                trace[r] = cur;
                traceS[r] = "R";
            }
        }

    }

    public static void print(int a, int b) {
        sb = new StringBuilder();
        while (b != a) {
            sb.append(traceS[b]);
            b = trace[b];
        }
    }

    public static int D(int n) {
        return (2 * n) % 10000;
    }

    public static int S(int n) {
        if (n < 1) {
            return 9999;
        } else return n - 1;
    }

    public static int L(int n) {
        n = ((n % 1000) * 10) + (n / 1000);
        return n;
    }

    public static int R(int n) {
        n = ((n % 10) * 1000) + (n / 10);
        return n;
    }
}