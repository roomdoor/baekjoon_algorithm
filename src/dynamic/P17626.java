package dynamic;

import java.util.Scanner;

public class P17626 {

	static int n;
	static int[] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n + 1];
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			int min = 5;
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, dp[i - j * j]);
			}
			dp[i] = min + 1;
		}

		System.out.println(dp[n]);
	}
}

// 1 1
// 2 2
// 3 3
// 4 1
// 5 2
// 6 3
// 7 4
// 8 2
// 9 1

