package xxprogramers.skillChkeck.level3.p1;

import java.util.PriorityQueue;

public class Solution {

	static int n;
	static int m;
	static int r;
	static int c;
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, -1, 1, 0};
	static String[] dWays = {"d", "l", "r", "u"};
	static boolean[][] isVisited;

	public static String solution(int n, int m, int x, int y, int r, int c, int k) {
		Solution.n = n;
		Solution.m = m;
		Solution.r = r;
		Solution.c = c;
		isVisited = new boolean[n + 1][m + 1];

		String shortestWay = bfs(x, y, r, c, k);
		String answer = "impossible";

		if (!shortestWay.equals("impossible")) {
			answer = ""; // ??????
		}

		return answer;
	}

	private static String bfs(int x, int y, int r, int c, int k) {
		if (!isPossible1(x, y, r, c, k)) {
			return "impossible";
		}

		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(x, y, 0, ""));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int curX = cur.x;
			int curY = cur.y;
			int curCount = cur.count;

			if (curX == r && curY == c) {
				return cur.way;
			}

			if (isVisited[curX][curY] || curCount > k) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nexX = curX + dx[i];
				int nexY = curY + dy[i];

				if (isPossible(nexX, nexY)) {
					isVisited[nexX][nexY] = true;
					queue.add(new Point(nexX, nexY, curCount + 1, cur.way + dWays[i]));
				}
			}
		}

		return "impossible";
	}

	private static boolean isPossible1(int x, int y, int r, int c, int k) {
		int count1 = Math.abs(x - r);
		int count2 = Math.abs(y - c);
		return (count1 + count2) % 2 == k % 2 && count2 + count2 <= k;
	}

	private static boolean isPossible(int x, int y) {
		return x >= 1 && y >= 1 && x <= n && y <= m && !isVisited[x][y];
	}

	private static class Point implements Comparable<Point> {

		int x;
		int y;
		int count;
		String way;

		public Point(int x, int y, int count, String way) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.way = way;
		}


		@Override
		public int compareTo(Point o) {
			return curDis(this.x, this.y) - curDis(o.x, o.y);
		}

	}

	private static int curDis(int x, int y) {
		return Math.abs(x - r) + Math.abs(y - c);
	}

	public static void main(String[] args) {
		System.out.println(solution(3, 4, 2, 3, 3, 1, 5));

		System.out.println(Solution.isPossible1(1, 1, 2, 2, 2));
	}
}
