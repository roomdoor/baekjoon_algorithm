import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P16954 {

	static String[][] map;
	static String[] newLine = {".", ".", ".", ".", ".", ".", ".", "."};
	static int[] dx = new int[]{1, 0, -1, 0, -1, -1, 1, 1, 0};
	static int[] dy = new int[]{0, 1, 0, -1, 1, -1, -1, 1, 0};

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(bfs());

	}

	private static int bfs() {
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> dis(o1) - dis(o2));
		queue.add(new int[]{7, 0, 0});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int time = cur[2];

			if (x == 0 && y == 7 || time >= 7) {
				return 1;
			}

			for (int i = 0; i < 9; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if (isPossible(nextX, nextY, time)) {
					queue.add(new int[]{nextX, nextY, time + 1});
				}
			}

		}

		return 0;
	}

	private static boolean isPossible(int x, int y, int time) {
		return x >= 0 && y >= 0 && x < 8 && y < 8 && isBlock(x, y, time);
	}

	private static boolean isBlock(int x, int y, int time) {
		if (x - time >= 0) {
			if (map[x - time][y].equals("#")) {
				return false;
			} else {
				return x - time - 1 < 0 || !map[x - time - 1][y].equals("#");
			}
		} else {
			return true;
		}
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new String[8][8];
		for (int i = 0; i < 8; i++) {
			map[i] = bf.readLine().split("");
		}
	}

	private static int dis(int[] point) {
		return point[0] + 7 - point[1];
	}
}
