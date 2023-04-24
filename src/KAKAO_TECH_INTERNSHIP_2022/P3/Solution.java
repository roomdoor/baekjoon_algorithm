package KAKAO_TECH_INTERNSHIP_2022.P3;

import java.util.*;

public class Solution {
	static int al;
	static int co;
	static int[][] p;
	static int goalAl;
	static int goalCo;
	static int[][] dp;
	static int answer;
	static int INF = Integer.MAX_VALUE;
	public int solution(int alp, int cop, int[][] problems) {
		al = alp;
		co = cop;
		// {alp_req, cop_req, alp_rwd, cop_rwd, cost}
		p = problems;
		goalAl = 0;
		goalCo = 0;

		for (int i = 0; i < p.length; i++) {
			goalAl = Math.max(goalAl, p[i][0]);
			goalCo = Math.max(goalCo, p[i][1]);
		}

		// sout("al = " + al);
		// sout("co = " + co);
		// sout("goalAl = " + goalAl);
		// sout("goalCo = " + goalCo);

		if (goalAl <= al && goalCo <= co) {
			return 0;
		}

		al = al > goalAl ? goalAl : al;
		co = co > goalCo ? goalCo : co;

		dp = new int[goalAl + 2][goalCo + 2];

		for (int[] dpr : dp) {
			Arrays.fill(dpr, INF);
		}

		dp[al][co] = 0;
		dynamic();

		// for (int i = al; i <= goalAl; i++) {
		//     for (int j = co; j <= goalCo; j++) {
		//         sout1(dp[i][j] + " ");
		//     }
		//     sout(" ");
		// }

		return dp[goalAl][goalCo];
	}

	private static void dynamic() {
		for (int i = al; i <= goalAl; i++) {
			for (int j = co; j <= goalCo; j++) {
				// sout("(i, j) = " + i + ", " + j);

				dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
				dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

				for (int k = 0; k < p.length; k++) {

					if (isPossible(p[k], i, j)) {
						int nextAl = i + p[k][2];
						int nextCo = j + p[k][3];

						nextAl = nextAl > goalAl ? goalAl : nextAl;
						nextCo = nextCo > goalCo ? goalCo : nextCo;

						int curTiem = dp[nextAl][nextCo];
						int nextTime = dp[i][j] + p[k][4];
						dp[nextAl][nextCo] = Math.min(curTiem, nextTime);

						// sout("k = " + k + " " +
						//      "dp[" + nextAl + "][" + nextCo + "] = "
						//      + dp[nextAl][nextCo]);
						// sout("");
					}
				}

			}
		}
	}

	private static boolean isPossible(int[] problem, int i, int j) {
		return i >= problem[0] && j >= problem[1];
	}


	private static void sout(Object o) {
		System.out.println(o);
	}

	private static void sout1(Object o) {
		System.out.print(o);
	}
}