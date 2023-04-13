package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579rere {

	static int[] stairs;
	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		stairs = new int[n + 1];
		dp = new Integer[n + 1];
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(bf.readLine());
		}

		if (n >= 1) {
			dp[1] = stairs[1];
		}

		if (n >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}

		System.out.println(DP(n));
	}

	private static int DP(int x) {
		if (dp[x] == null) {
			dp[x] = Math.max(DP(x - 3) + stairs[x - 1], DP(x - 2)) + stairs[x];
		}

		return dp[x];
	}
}
