import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16234re {

	static int N;
	static int L;
	static int R;
	static boolean[][] isVisited;
	static int[][] map;
	static int[] dx = new int[]{1, 0, -1, 0};
	static int[] dy = new int[]{0, 1, 0, -1};
	static int result = 0;


	public static void main(String[] args) throws IOException {
		input();

		boolean isChanged = true;

		while (isChanged) {
			isChanged = false;
			isVisited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!isVisited[i][j]) {
						isChanged = isChanged | bfs(i, j);
					}
				}
			}

			if (isChanged) {
				result++;
			}
		}

		System.out.println(result);
	}

	private static boolean bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		List<int[]> sharedNations = new ArrayList<>();
		queue.add(new int[]{i, j});
		int count = 0;
		int sum = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];

			if (isVisited[x][y]) {
				continue;
			}

			isVisited[x][y] = true;
			sharedNations.add(new int[]{x, y});
			count++;
			sum += map[x][y];

			for (int k = 0; k < 4; k++) {
				int nextX = x + dx[k];
				int nextY = y + dy[k];
				if (isPossible(nextX, nextY) && isOpened(x, y, nextX, nextY)) {
					queue.add(new int[]{nextX, nextY});
				}
			}
		}

		if (count != 1) {
			int changedNum = sum / count;
			for (int[] nation : sharedNations) {
				map[nation[0]][nation[1]] = changedNum;
			}
			return true;
		}

		return false;
	}

	private static boolean isOpened(int x, int y, int nextX, int nextY) {
		int abs = Math.abs(map[x][y] - map[nextX][nextY]);
		return abs >= L && abs <= R;
	}

	private static boolean isPossible(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N && !isVisited[x][y];
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		isVisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}