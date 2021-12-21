package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P9019 {
    public static int[] DP;
    public static int[] trace;
    public static String[] traceS;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());

        for (int i = 0; i < testCase; i++) {
            DP = new int[10001];
            Arrays.fill(DP, Integer.MAX_VALUE);
            trace = new int[10001];
            traceS = new String[10001];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            DP[a] = 0;

            bfs(a, b);
            print(a, b);

        }
        System.out.println(sb.toString());

    }

    public static void bfs(int a, int b) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] first = new int[]{a, 0};
        queue.offer(first);

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int cur = temp[0];
            int count = temp[1];

            int d = D(cur);
            int s = S(cur);
            int l = L(cur);
            int r = R(cur);

            if (DP[d] > count + 1) {
                queue.add(new int[]{d, count + 1});
                DP[d] = count + 1;
                trace[d] = cur;
                traceS[d] = "D";
            }

            if (DP[s] > count + 1) {
                queue.add(new int[]{s, count + 1});
                DP[s] = count + 1;
                trace[s] = cur;
                traceS[s] = "S";
            }

            if (DP[l] > count + 1) {
                queue.add(new int[]{l, count + 1});
                DP[l] = count + 1;
                trace[l] = cur;
                traceS[l] = "L";
            }

            if (DP[r] > count + 1) {
                queue.add(new int[]{r, count + 1});
                DP[r] = count + 1;
                trace[r] = cur;
                traceS[r] = "R";
            }
        }
    }

    public static void print(int a, int b) {
        int temp = b;
        Stack<String> stack = new Stack<>();
        while (temp != a) {
            stack.push(traceS[temp]);
            temp = trace[temp];
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.append("\n");
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
        n = (n % 1000) * 10 + n / 1000;
        return n;
    }

    public static int R(int n) {
        n = ((n % 10) * 1000) + n / 10;
        return n;
    }
}