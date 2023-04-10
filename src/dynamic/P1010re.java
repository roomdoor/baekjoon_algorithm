package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010re {

	static int n;
	static int m;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		dp = new long[31][31];
		for (int i = 0; i < 31; i++) {
			dp[i][i] = dp[0][i] = 1;
		}

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			System.out.println(cul(n, m));
		}


	}

	private static long cul(int x, int y) {
		if (x == y) {
			return 1;
		}

		if (dp[x][y] != 0) {
			return dp[x][y];
		} else {
			return dp[x][y] = cul(x - 1, y - 1) + cul(x, y - 1);
		}
	}
// nCr = n - 1Cr + n-1Cr-1
}
