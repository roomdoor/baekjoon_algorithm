package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P15685 {

	static int n;
	static boolean[][] map = new boolean[102][102];
	static int[] dx = new int[]{1, 0, -1, 0};
	static int[] dy = new int[]{0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			int d = Integer.parseInt(s[2]);
			int g = Integer.parseInt(s[3]);

			makeCurve(x, y, d, g);
		}

		int count = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (map[j][i] && map[j][i + 1] && map[j + 1][i + 1] && map[j + 1][i]) {
					count++;
				}
			}
		}

		System.out.println(count);
	}

	private static void makeCurve(int x, int y, int d, int g) {
		Deque<Integer> deque1 = new ArrayDeque<>();
		Deque<Integer> deque2 = new ArrayDeque<>();

		addMap(x, y, d);
		x += dx[d];
		y += dy[d];
		deque1.offerLast(d);

		for (int i = 1; i <= g; i++) {
			if (i % 2 == 1) {
				deque2 = new ArrayDeque<>(deque1);
				while (!deque1.isEmpty()) {
					int nextD = (deque1.pollLast() + 1) % 4;
					addMap(x, y, nextD);
					x += dx[nextD];
					y += dy[nextD];
					deque2.offerLast(nextD);
				}

			} else {
				deque1 = new ArrayDeque<>(deque2);
				while (!deque2.isEmpty()) {
					int nextD = (deque2.pollLast() + 1) % 4;
					addMap(x, y, nextD);
					x += dx[nextD];
					y += dy[nextD];
					deque1.offerLast(nextD);
				}
			}
		}
		map[y][x] = true;

	}

	private static void addMap(int x, int y, int d) {
		if (!map[y][x]) {
			map[y][x] = true;
		}
	}
}
