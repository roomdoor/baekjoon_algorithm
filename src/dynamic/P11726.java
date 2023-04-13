package dynamic;

import java.util.Scanner;

public class P11726 {

	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		System.out.println(DP(n));
	}

	private static int DP(int x) {
		if (dp[x] == 0) {
			return dp[x] = (DP(x - 1) + DP(x - 2)) % 10007;
		}

		return dp[x] % 10007;
	}
}

// 1 \
// 2 \\, =
// 3 \\\, =\, \= -> a1 + a2
// 4 \\\\, =\\, \=\, \\=, == -> a2 + a3
// 5 \\\\\, =\\\, \=\\, \\=\, \\\=, ==\, =\=, \== -> a3 + a4
