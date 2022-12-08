package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15486 {

	static int n;
	static int[][] map;
	static int[] dp;
	static int result = -1;

	public static void main(String[] args) throws IOException {
		input();

		for (int i = 1; i < n + 2; i++) {
			result = Math.max(result, dp[i]);

			if (i + map[i][0] < n + 2) {
				dp[i + map[i][0]] = Math.max(dp[i + map[i][0]], result + map[i][1]);
			}
		}

		System.out.println(result);
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		map = new int[n + 2][2];
		dp = new int[n + 2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			map[i + 1] = new int[]{t, p};
		}
	}
}
