package dynamic;

import java.util.Scanner;

public class P9655 {

	static int n;
	static Boolean[] dp;

	public static void main(String[] args) {

		input();

		if (n % 2 != 0) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}

	}

	// 상근(false) SK, 창영(true) CY
	private static void cul(int x) {
		if (dp[x] == null) {

		} else {

		}
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		dp = new Boolean[n + 1];
		dp[1] = true;
	}

}

// 1 = SK
// 2 = CY
// 3 = SK
// 4 = CY
// 5 = if 1 -> CY if 3 -> CY -> CY
// 6 = if 1 -> CY if 3 -> SK