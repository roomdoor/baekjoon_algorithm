package cumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660_row_sum {

	static int[][] map;
	static int[][] culPoint;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		input();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			sb.append(cul(culPoint[i][0], culPoint[i][1], culPoint[i][2], culPoint[i][3]));
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static int cul(int sx, int sy, int ex, int ey) {
		int sum = 0;
		if (sy == 0) {
			for (int i = sx; i <= ex; i++) {
				sum += map[i][ey];
			}
		} else {
			for (int i = sx; i <= ex; i++) {
				sum += map[i][ey] - map[i][sy - 1];
			}
		}

		return sum;
	}


	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		culPoint = new int[m][4];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				if (j != 0) {
					map[i][j] = map[i][j - 1] + Integer.parseInt(st.nextToken());
				} else {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			culPoint[i][0] = Integer.parseInt(st.nextToken()) - 1;
			culPoint[i][1] = Integer.parseInt(st.nextToken()) - 1;
			culPoint[i][2] = Integer.parseInt(st.nextToken()) - 1;
			culPoint[i][3] = Integer.parseInt(st.nextToken()) - 1;
		}
	}

}
