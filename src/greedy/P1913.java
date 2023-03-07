package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1913 {

	static int n;
	static int[][] meeting;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(sol());

	}

	public static int sol() {
		int count = 1;
		int endTime = meeting[0][1];
		for (int i = 1; i < n; i++) {
			if (endTime <= meeting[i][0]) {
				endTime = meeting[i][1];
				count++;
			}
		}
		return count;
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		meeting = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] - o2[1] == 0) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
	}
}