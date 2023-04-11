package dynamic;

import java.util.Scanner;

public class P1463rere {

	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		dp = new int[n + 1];
		dp[1] = 1;

		System.out.println(dynamicProgram(n) - 1);


	}

	private static int dynamicProgram(int x) {
		if (dp[x] == 0) {
			dp[x] = Integer.MAX_VALUE;

			if (x % 3 == 0) {
				dp[x] = Math.min(dynamicProgram(x / 3) + 1, dp[x]);
			}

			if (x % 2 == 0) {
				dp[x] = Math.min(dynamicProgram(x / 2) + 1, dp[x]);
			}

			dp[x] = Math.min(dynamicProgram(x - 1) + 1, dp[x]);

			return dp[x];
		} else {
			return dp[x];
		}
	}
}
