package cumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11660_row_cul_sum {

	static int[][] map;
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		input();

		System.out.println(sb);
	}


	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j < n + 1; j++) {
				map[i][j] =
					Integer.parseInt(st.nextToken())
						+ map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
			}

		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());

			sb.append(map[ex][ey] - map[sx - 1][ey] - map[ex][sy - 1] + map[sx - 1][sy - 1]);
			sb.append("\n");
		}
	}

}
