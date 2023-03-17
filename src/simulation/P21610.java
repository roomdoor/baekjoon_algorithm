package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P21610 {

	static int n;
	static int m;
	static int[][] map;
	static int[][] move;
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static List<int[]> clouds;
	static boolean[][] isClouded;


	public static void main(String[] args) throws IOException {
		input();

		// 처음 구름 생성
		clouds = new ArrayList<>();
		clouds.add(new int[]{n - 1, 0});
		clouds.add(new int[]{n - 1, 1});
		clouds.add(new int[]{n - 2, 0});
		clouds.add(new int[]{n - 2, 1});

		for (int i = 0; i < m; i++) {
			// 구름 이동
			moveClouds(i);

			// 물복사버그
			bugWater();

			// 새 구름 생성
			makeCloud();
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result += map[i][j];
			}
		}

		System.out.println(result);
	}

	private static void bugWater() {
		for (int[] cloud : clouds) {
			for (int j = 0; j < 4; j++) {
				int dir = (2 * j + 1);
				int diagonalX = cloud[0] + dx[dir];
				int diagonalY = cloud[1] + dy[dir];

				if (isBugged(diagonalX, diagonalY)) {
					map[cloud[0]][cloud[1]]++;
				}
			}
		}
	}

	private static void moveClouds(int i) {
		int direction = move[i][0];
		int distance = move[i][1] % n;

		int x = distance * dx[direction - 1];
		int y = distance * dy[direction - 1];

		isClouded = new boolean[n][n];
		for (int[] cloud : clouds) {
			cloud[0] = (cloud[0] + x) >= 0 ? (cloud[0] + x) % n : n + (cloud[0] + x);
			cloud[1] = (cloud[1] + y) >= 0 ? (cloud[1] + y) % n : n + (cloud[1] + y);
			map[cloud[0]][cloud[1]]++;
			isClouded[cloud[0]][cloud[1]] = true;
		}
	}

	private static void makeCloud() {
		clouds = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (isPossibleMakeCloud(i, j)) {
					clouds.add(new int[]{i, j});
					map[i][j] -= 2;
				}
			}
		}

		isClouded = new boolean[n][n];
	}

	private static boolean isBugged(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < n && map[x][y] > 0;
	}


	private static boolean isPossibleMakeCloud(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < n && map[x][y] >= 2 && !isClouded[x][y];
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		move = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			move[i][0] = Integer.parseInt(st.nextToken());
			move[i][1] = Integer.parseInt(st.nextToken());
		}
	}

}
