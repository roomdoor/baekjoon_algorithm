package dynamic;

import java.util.Scanner;

public class P11727 {

	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		System.out.println(dynamic(n));
	}

	private static int dynamic(int x) {
		if (dp[x] == 0) {
			dp[x] = (dynamic(x - 1) + 2 * dynamic(x - 2)) % 10007;
		}

		return dp[x];

	}

}


// 1 \
// 2 \\, =, ㅁ -> 3
// 3 \\\, =\, \=, ㅁ\, \ㅁ -> 5
// 4 \\\\, =\\, \=\, \\=, ㅁ\\, \ㅁ\, \\ㅁ, ==, =ㅁ, ㅁ=, ㅁㅁ ->  11
// 5 \\\\\, =\\\, \=\\, \\=\, \\\=, ==\, =\=, \== -> a3 + a4

