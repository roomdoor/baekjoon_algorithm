package dynamic;

import java.util.Scanner;

public class P2839 {

	static int[] dp;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n + 1];

		if (n >= 3) {
			dp[3] = 1;
		}

		if (n >= 5) {
			dp[5] = 1;
		}

		for (int i = 6; i <= n; i++) {
			if (dp[i - 5] != 0 & dp[i - 3] != 0) {
				dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
			} else if (dp[i - 5] != 0) {
				dp[i] = dp[i - 5] + 1;
			} else if (dp[i - 3] != 0) {
				dp[i] = dp[i - 3] + 1;
			}
		}

//		for (int i = 0; i <= n; i++) {
//			System.out.print("n = " + i + "  ");
//			System.out.println(dp[i] == 0 ? -1 : dp[i]);
//		}

		System.out.println(dp[n] == 0 ? -1 : dp[n]);
	}
}
