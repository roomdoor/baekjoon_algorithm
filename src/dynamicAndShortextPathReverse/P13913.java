package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P13913 {
    public static int n;
    public static int k;
    public static int[] DP;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        DP = new int[100001];
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[n] = 0;

        if (n > k) {
            System.out.println(n - k);
            for (int i = n; i >= k; i--) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString());
        } else {
            spdp(n, k);
            System.out.println(DP[k]);

            print();
            System.out.println(sb.toString());
        }
    }

    public static void spdp(int n, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] arr = new int[]{n, 0};
        queue.add(arr);
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int cur = temp[0];
            int count = temp[1];
            if (cur > 0 && DP[cur - 1] > count + 1) {
                DP[cur - 1] = count + 1;
                queue.add(new int[]{cur - 1, count + 1});
            }
            if (cur < k && DP[cur + 1] > count + 1) {
                DP[cur + 1] = count + 1;
                queue.add(new int[]{cur + 1, count + 1});
            }
            if (cur * 2 <= 100000 && DP[cur * 2] > count + 1) {
                DP[cur * 2] = count + 1;
                queue.add(new int[]{cur * 2, count + 1});
            }
        }
    }

    public static void print() {
        Stack<Integer> stack = new Stack<>();
        while (k != n) {
            if (k > 0 && DP[k] - 1 == DP[k - 1]) {
                stack.push(k);
                k -= 1;
            } else if (k < 100000 && DP[k] - 1 == DP[k + 1]) {
                stack.push(k);
                k += 1;
            } else {
                stack.push(k);
                k /= 2;
            }
        }

        sb.append(n).append(" ");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
    }
}
