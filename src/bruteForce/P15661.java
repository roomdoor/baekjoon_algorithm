package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15661 {

	static int N;
	static int[][] S;
	static boolean[] isStart;
	static int result;

	public static void main(String[] args) throws IOException {
		input();
		result = Integer.MAX_VALUE;

		for (int i = 1; i < N; i++) {
			isStart = new boolean[N + 1];
			bt(0, 1, i);
		}

		System.out.println(result);
	}

	private static void bt(int depth, int start, int num) {
		if (depth == num) {
			result = Math.min(result, culScore());
			return;
		}

		for (int i = start; i < N + 1; i++) {
			isStart[i] = true;
			bt(depth + 1, i + 1, num);
			isStart[i] = false;
		}
	}

	private static int culScore() {
		int startTeamScore = 0;
		int linkTeamScore = 0;

		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j < N + 1; j++) {
				if (isStart[i] && isStart[j]) {
					startTeamScore += S[i][j];
				} else if (!isStart[i] && !isStart[j]) {
					linkTeamScore += S[i][j];
				}
			}
		}

		return Math.abs(startTeamScore - linkTeamScore);
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		S = new int[N + 1][N + 1];
		isStart = new boolean[N + 1];
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 1; j < N + 1; j++) {
				if (i > j) {
					S[j][i] += Integer.parseInt(st.nextToken());
				} else {
					S[i][j] += Integer.parseInt(st.nextToken());
				}
			}
		}
	}
}
