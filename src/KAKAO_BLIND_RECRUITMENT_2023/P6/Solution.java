package KAKAO_BLIND_RECRUITMENT_2023.P6;

import java.util.*;

public class Solution {
	static int[][] map;
	static StringBuilder answer;
	static int n;
	static int m;
	static int x;
	static int y;
	static int r;
	static int c;
	static int k;
	static int count;

	public String solution(int n1, int m1, int x1, int y1, int r1, int c1, int k1) {
		n = n1;
		m = m1;
		x = x1;
		y = y1;
		r = r1;
		c = c1;
		k = k1;
		count = 0;

		answer = new StringBuilder();
		map = new int[n + 1][m + 1];

		int dis = culDis();
		if (dis > k) {
			return "impossible";
		}

		if ((k - dis) % 2 == 1) {
			return "impossible";
		}

		makeK();
		esc();

		return answer.toString();
	}

	public static void esc(){

		// d
		while (x < r) {
			answer.append("d");
			x++;
			count++;
		}

		// sout("d = " + answer);

		// l
		while (y > c) {
			answer.append("l");
			y--;
			count++;
		}

		// sout("l = " + answer);

		// r
		while (y < c) {
			answer.append("r");
			y++;
			count++;
		}

		// sout("r = " + answer);

		// u
		while (x > r) {
			answer.append("u");
			x--;
			count++;
		}

		// sout("u = " + answer);
	}

	private static void makeK() {
		int temp = 0;
		while (culDis() < k - temp) {
			if (canD()) {
				temp++;
				answer.append("d");
				x++;

			}else if(canL()) {
				temp++;
				answer.append("l");
				y--;

			}
			else if(canR()) {
				temp++;
				answer.append("r");
				y++;

			}
			else if(canU()) {
				temp++;
				answer.append("u");
				x--;
			}

			// sout("temp = " + temp + " make K = " + answer);
		}
	}

	private static boolean canD() {
		return x < n;
	}

	private static boolean canL() {
		return y > 1;
	}

	private static boolean canR() {
		return y < m;
	}

	private static boolean canU() {
		return x > 1;
	}


	private static int culDis() {
		int row = Math.abs(x - r);
		int cul = Math.abs(y - c);

		return row + cul;
	}


	private static void sout(Object o) {
		System.out.println(o);
	}
}

// dduu
// dlru

// ddduuuddduuu
// dddlllrrruuu

// llrr

// rlrl

// udud

