package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1025 {

	static int N;
	static int M;
	static int[][] map;
	static long result = -1;

	public static void main(String[] args) throws IOException {
		input();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				searchNum(i, j);
			}
		}

		System.out.println(result);
	}

	private static void searchNum(int i, int j) {
		for (int k = 0; k < N; k++) {
			for (int l = 0; l < M; l++) {
				if (k == 0 && l == 0) {
					if (isSqrt(map[i][j])) {
						result = Math.max(result, map[i][j]);
					}
					continue;
				}
				makeNum(i, j, map[i][j], k, l);
				makeNum(i, j, map[i][j], -k, l);
				makeNum(i, j, map[i][j], k, -l);
				makeNum(i, j, map[i][j], -k, -l);
			}
		}
	}

	private static void makeNum(int startI, int startJ, long num, int rowAdd, int colAdd) {
		if (rowAdd == 0 && colAdd == 0) {
			return;
		}

		int nextX = startI + rowAdd;
		int nextY = startJ + colAdd;
		if (isPossible(nextX, nextY)) {
			num *= 10;
			num += map[nextX][nextY];
			if (isSqrt(num)) {
				result = Math.max(result, num);
			}
			makeNum(nextX, nextY, num, rowAdd, colAdd);
		}
	}

	private static boolean isPossible(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	public static boolean isSqrt(long num) {
		double r = Math.sqrt(num);
//		r = 3
//		3.000000000001 -> 3
//		2.999999999999 -> 2
//

		long lr = (long) (r + 0.5);
		return lr * lr == num;
	}


	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			long line = Integer.parseInt(bf.readLine());
			int j = M - 1;
			while (line > 0) {
				map[i][j] = (int) (line % 10);
				line /= 10;
				j--;
			}
		}
	}
}
