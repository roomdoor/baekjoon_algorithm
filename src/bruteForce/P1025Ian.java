package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] map;
		int answer = -1;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] arr = new String[N + 1];
		map = new int[N][M];

		for (int i = 0; i < N; ++i) {
			arr[i] = br.readLine();
			for (int j = 0; j < M; ++j) {
				map[i][j] = arr[i].charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = -N; k < N; k++) {
					for (int l = -M; l < M; l++) {
						int col = i;
						int row = j;
						if (k == 0 && l == 0) {
							continue;
						}
						int value = 0;
						while (col >= 0 && row >= 0 && col < N && row < M) {
							value *= 10;
							value += map[col][row];

							int root = (int) Math.sqrt(value);
							if (root * root == value) {
								answer = Math.max(answer, value);
							}
							col += k;
							row += l;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}
