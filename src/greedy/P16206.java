package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16206 {

	static int n;
	static int m;
	static int[] cakes;
	static int max;

	public static void main(String[] args) throws IOException {
		input();

		cul();
		System.out.println(max);

	}

	private static void cul() {
		int before = m;
		while (m >= 0) {
			for (int i = 0; i < n; i++) {
				if (cakes[i] >= 10 && cakes[i] % 10 == 0) {
					if (cakes[i] == 10) {
						max++;
						cakes[i] = 0;
					} else {
						int num = cakes[i] / 10;
						if (num - 1 <= m) {
							cakes[i] -= num * 10;
							max += num;
							m -= num - 1;
						} else {
							max += m;
							return;
						}
					}
				}
			}

			for (int i = 0; i < n; i++) {
				if (cakes[i] > 10 && cakes[i] % 10 != 0) {
					int num = cakes[i] / 10;
					if (num <= m) {
						cakes[i] -= num * 10;
						max += num;
						m -= num;
					} else {
						max += m;
						return;
					}
				}
			}
			if (before == m) {
				return;
			}
			before = m;
		}
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cakes = new int[n];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			cakes[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cakes);
	}
}