package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15270 {

	static int n;
	static int m;
	static int max;
	static int[][] map;
	static boolean[] isChecked;


	public static void main(String[] args) throws IOException {
		input();
		dfs(0, 0);
		if (max < n) {
			max++;
		}
		System.out.println(max);

	}

	private static void dfs(int index, int count) {
		if (index >= m) {
			max = Math.max(count, max);
			return;
		}

		if (isChecked[map[index][0]] || isChecked[map[index][1]]) {
			dfs(index + 1, count);
		} else {
			isChecked[map[index][0]] = true;
			isChecked[map[index][1]] = true;
			dfs(index + 1, count + 2);

			isChecked[map[index][0]] = false;
			isChecked[map[index][1]] = false;
			dfs(index + 1, count);
		}
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][2];
		isChecked = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
	}

}
