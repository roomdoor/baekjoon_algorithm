import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17136 {

	static String[][] map = new String[10][10];
	static int[] paper = {0, 5, 5, 5, 5, 5};

	public static void main(String[] args) throws IOException {
		input();

		check(0, 0, 5, 0);

		System.out.println(result);
	}

	private static int check(int x, int y, int size, int result) {
		boolean isMatched = true;

		if (y + size > 10) {
			x++;
			y = 0;
		}

		if (x + size > 10) {
			return;
		}

		out:
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (!map[i][j].equals("1")) {
					y = j + 1;
					isMatched = false;
					break out;
				}
			}
		}

		if (isMatched) {
			if (paper[size] <= 0) {
				boolean isCovered = false;

				switch (size) {
					case 4:
						if (paper[2] >= 4) {
							isCovered = true;
							result += 4;
							paper[2] -= 4;
						}
						break;

					case 3:
						if (paper[2] >= 1 && paper[1] >= 5) {
							isCovered = true;
							result += 6;
							paper[2]--;
							paper[1] -= 5;
						}
						break;

					case 2:
						if (paper[1] >= 4) {
							isCovered = true;
							result += 4;
							paper[1] -= 4;
						}
						break;
				}

				if (!isCovered) {
					result = -1;
					return false;
				}

			} else {
				paper[size]--;
			}

			for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
					map[i][j] = "0";
				}
			}
			result++;
			y = y + size;
		}
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			map[i] = bf.readLine().split(" ");
		}
	}
}
