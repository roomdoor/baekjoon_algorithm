package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16234 {

	static int[][] map;
	static boolean[][] isVisited;
	static int n;
	static int l;
	static int r;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};


	public static void main(String[] args) throws IOException {
		input();

		System.out.println(cul());

	}

	private static int cul() {
		int day = 0;
		boolean isMoved = true;
		while (isMoved) {
			isMoved = false;
			isVisited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!isVisited[i][j]) {
						isMoved = bfs(i, j) | isMoved;
					}
				}
			}
			if (isMoved) {
				day++;

			}
		}
		return day;
	}

	private static boolean bfs(int startX, int startY) {
		boolean result = false;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{startX, startY});
		List<int[]> sumList = new ArrayList<>();

		long sum = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];

			if (isVisited[x][y]) {
				continue;
			}

			sum += map[x][y];
			sumList.add(new int[]{x, y});
			isVisited[x][y] = true;

			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];

				if (isPossible(nextX, nextY, x, y)) {
					queue.add(new int[]{nextX, nextY});
					result = true;
				}
			}
		}

		for (int i = 0; i < sumList.size(); i++) {
			int[] point = sumList.get(i);
			map[point[0]][point[1]] = (int) sum / sumList.size();
		}

		return result;
	}

	private static boolean isPossible(int x, int y, int beX, int beY) {
		return x >= 0 && y >= 0 && x < n && y < n && !isVisited[x][y]
			&& Math.abs(map[x][y] - map[beX][beY]) >= l && Math.abs(map[x][y] - map[beX][beY]) <= r;
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
