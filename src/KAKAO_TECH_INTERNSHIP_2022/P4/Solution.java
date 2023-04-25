package KAKAO_TECH_INTERNSHIP_2022.P4;

import java.util.*;

public class Solution {
	static int n;
	static int[][] p;
	static int[] g;
	static int[] s;
	static int[] answer;
	static List<List<int[]>> m;
	static Set<Integer> sSet;
	static Set<Integer> gSet;
	static boolean[] isVisited;
	static int[] dp;

	public int[] solution(int n1, int[][] paths, int[] gates, int[] summits) {
		answer = new int[]{50000, 10000001};
		n = n1;
		p = paths;
		g = gates;
		s = summits;
		m = new ArrayList<>();
		sSet = new HashSet<>();
		gSet = new HashSet<>();
		dp = new int[n + 1];

		Arrays.fill(dp, 100000001);


		for (int x : s) {
			sSet.add(x);
		}

		for (int x : g) {
			gSet.add(x);
			dp[x] = 0;
		}

		init();

		// int count = 0;
		// for (List<int[]> mm : m) {
		//     sout("count = " + count++);
		//     for (int[] w : mm) {
		//         sout("way = " + Arrays.toString(w));
		//     }
		//     sout("");
		// }


		check();

		for (int x : s) {
			if (dp[x] < answer[1]) {
				answer[0] = x;
				answer[1] = dp[x];
			}else if (dp[x] == answer[1]) {
				answer[0] = Math.min(answer[0], x);
			}
		}

		return answer;
	}

	private static void check() {
		PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
		for (int x : g) {
			q.add(new int[]{x, 0});
		}


		while(!q.isEmpty()) {

			int[] cur = q.poll();
			// sout("cur point = " + Arrays.toString(cur));
			// sout("dp = " + Arrays.toString(dp));
			int cp = cur[0];
			int ci = cur[1];

			if (answer[1] < ci) {
				continue;
			}

			if (sSet.contains(cp)) {
				if (answer[1] > ci) {
					answer[0] = cp;
					answer[1] = ci;
					continue;
				}else if (answer[1] == ci) {
					answer[0] = Math.min(answer[0], cp);
					continue;
				}else {
					continue;
				}
			}

			List<int[]> ways = m.get(cp);

			for (int[] w : ways) {
				int next = w[0];
				int newI = w[1];
				if (gSet.contains(next)){
					// sout("stop gate = " + next);
					continue;
				}


				int nextI = Math.max(ci, newI);
				if (dp[next] > nextI) {
					q.add(new int[]{next, nextI});
					dp[next] = nextI;
				}
			}
		}
	}

	private static void init() {
		for (int i = 0; i < n + 1; i++) {
			m.add(new ArrayList<>());
		}

		for (int[] w : p) {
			m.get(w[0]).add(new int[]{w[1], w[2]});
			m.get(w[1]).add(new int[]{w[0], w[2]});
		}
	}


	private static void sout(Object o) {
		System.out.println(o);
	}
}