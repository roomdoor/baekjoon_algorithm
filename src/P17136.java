import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17136 {

	static String[][] map = new String[10][10];
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		input();

		check(0, 0, 0);

		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	private static void check(int x, int y, int count) {
		if (x >= 9 && y > 9) {
			result = Math.min(result, count);
			return;
		}

		if (count >= result) {
			return;
		}

		if (y > 9) {
			check(x + 1, 0, count);
			return;
		}

		if (map[x][y].equals("1")) {
			for (int i = 5; i >= 1; i--) {
				if (isPossible(x, y, i) && isMatch(x, y, i)) {
					if (paper[i] <= 0) {
						return;
					}
					paper[i]--;
					stick(x, y, i, "0");
					check(x, y + i, count + 1);
					paper[i]++;
					stick(x, y, i, "1");
				}
			}
		} else {
			check(x, y + 1, count);
		}
	}

	private static void stick(int x, int y, int size, String paper) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = paper;
			}
		}
	}

	private static boolean isPossible(int x, int y, int size) {
		return x >= 0 && y >= 0 && x <= 10 - size && y <= 10 - size;
	}

	private static boolean isMatch(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (!map[i][j].equals("1")) {
					return false;
				}
			}
		}
		return true;
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			map[i] = bf.readLine().split(" ");
		}
	}
}
