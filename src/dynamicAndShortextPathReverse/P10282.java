package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P10282 {

	static int n;
	static int d;
	static int c;
	static List<List<int[]>> map = new ArrayList<>();
	static int[] dp;
	static int INF = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bf.readLine());

		while (testCase-- > 0) {
			input(bf);

			dijktra();
		}
		System.out.println(sb.toString());
	}

	private static void dijktra() {
		PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - y[1]);
		queue.add(new int[]{c, 0});

		dp[c] = 0;
		int count = 0;
		int totalTime = 0;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int now = poll[0];
			int time = poll[1];

			if (time > dp[now]) {
				continue;
			}

			count++;
			totalTime = Math.max(totalTime, time);

			for (int[] next : map.get(now)) {
				int nextNode = next[0];
				int nextTime = time + next[1];

				if (dp[nextNode] > nextTime) {
					dp[nextNode] = nextTime;
					queue.add(new int[]{nextNode, nextTime});
				}
			}
		}

		sb.append(count).append(" ").append(totalTime).append("\n");
	}

	private static void input(BufferedReader bf) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			map.add(new ArrayList<>());
		}

		dp = new int[n + 1];
		Arrays.fill(dp, INF);

		for (int i = 0; i < d; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			map.get(b).add(new int[]{a, s});
		}
	}
}
