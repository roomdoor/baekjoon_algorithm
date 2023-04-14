package dynamic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;

public class P2407 {

	static BigInteger[][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		dp = new BigInteger[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = new BigInteger(String.valueOf(1));
			if (i <= m) {
				dp[i][i] = new BigInteger(String.valueOf(1));;
			}
		}

		System.out.println(dynamic(n, m));


	}
	private static BigInteger dynamic(int n, int m) {
		if (dp[n][m] == null) {
			dp[n][m] = dynamic(n - 1, m).add(dynamic(n - 1, m - 1));
		}

		return dp[n][m];
	}

}

// 5C3 = 10
// 4C3 = 4
// 4C2 = 6

// 6C3 = 20
// 5C3 = 10
// 5C2 = 10

// 10C2 = 45
// 9C2 = 36
// 9C1 = 9
