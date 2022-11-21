package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P21278 {

	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static List<Integer>[] map;
	public static int[][] distances;
	public static int N;
	public static int M;
	public static int INF = 9999999;


	public static void main(String[] args) throws IOException {
		input();
		distanceCul();

		int answer = INF;
		int[] points = new int[2];

		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j < N + 1; j++) {
				int total = 0;
				total = solve(i, j, total);
				if (total < answer) {
					points = new int[]{i, j};
					answer = total;
				}
			}
		}

		System.out.println(points[0] + " " + points[1] + " " + answer);
	}

	private static int solve(int i, int j, int total) {
		for (int k = 1; k < N + 1; k++) {
			total += 2 * Math.min(distances[i][k], distances[j][k]);
		}
		return total;
	}

	private static void distanceCul() {
		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
				}
			}
		}
	}

	private static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		distances = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i == j) {
					continue;
				}
				distances[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			distances[a][b] = distances[b][a] = 1;
		}
	}
}
