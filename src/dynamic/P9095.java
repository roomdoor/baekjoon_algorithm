package dynamic;

import java.util.Scanner;

public class P9095 {

	static int[] dp;
	static int[] nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(sc.nextLine());
		int n = 0;
		nums = new int[t];

		for (int i = 0; i < t; i++) {
			nums[i] = Integer.parseInt(sc.nextLine());
			n = Math.max(n, nums[i]);
		}

		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		for (int r : nums) {
			sb.append(dp[r]).append("\n");
		}

		System.out.println(sb);
	}
}

//	1	1	 1
//	2	2	 1+1, 2
//	3	4	 1+1+1, 2+1, 1+2, 3
//	4	7	 1+1+1+1, 2+1+1, 1+2+1, 1+1+2, 2+2, 1+3, 3+1
//	5	10	 1+1+1+1+1, 2+1+1+1, 1+2+1+1, 1+1+2+1, 1+1+1+2, 3+1+1, 1+3+1, 1+1+3, 2+3, 3+2

