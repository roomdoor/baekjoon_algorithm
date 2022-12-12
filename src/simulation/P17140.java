package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P17140 {

	static int[][] map = new int[100][100];

	static int r;
	static int c;
	static int k;
	static int time;
	static int maxRow = 3;
	static int maxCul = 3;


	public static void main(String[] args) throws IOException {
		input();

		while (map[r - 1][c - 1] != k && time <= 100) {
			timeMethod();
		}

		if (time > 100) {
			System.out.println(-1);

		} else {
			System.out.println(time);
		}
	}

	private static void timeMethod() {
		time++;

		if (maxRow >= maxCul) {
			int tempMaxCul = 0;

			for (int i = 0; i < maxRow; i++) {
				Map<Integer, Integer> countMap = new HashMap<>();

				for (int j = 0; j < maxCul; j++) {
					if (map[i][j] == 0) {
						continue;
					}

					int count = countMap.getOrDefault(map[i][j], 0);
					countMap.put(map[i][j], count + 1);
				}

				PriorityQueue<int[]> q =
					new PriorityQueue<>((x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);

				for (Entry<Integer, Integer> count : countMap.entrySet()) {
					q.add(new int[]{count.getKey(), count.getValue()});
				}

				int k = 0;
				for (int j = 0; j < maxCul; j++) {
					map[i][j] = 0;
				}

				while (!q.isEmpty() && k < 100) {
					int[] poll = q.poll();
					map[i][k++] = poll[0];
					map[i][k++] = poll[1];
				}

				tempMaxCul = Math.max(tempMaxCul, k);
			}
			maxCul = tempMaxCul;

		} else {
			int tempMaxRow = 0;

			for (int i = 0; i < maxCul; i++) {
				Map<Integer, Integer> countMap = new HashMap<>();
				for (int j = 0; j < maxRow; j++) {
					if (map[j][i] == 0) {
						continue;
					}

					int count = countMap.getOrDefault(map[j][i], 0);
					countMap.put(map[j][i], count + 1);
				}

				PriorityQueue<int[]> q =
					new PriorityQueue<>((x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);

				for (Entry<Integer, Integer> count : countMap.entrySet()) {
					q.add(new int[]{count.getKey(), count.getValue()});
				}

				int k = 0;
				for (int j = 0; j < maxRow; j++) {
					map[j][i] = 0;
				}

				while (!q.isEmpty() && k < 100) {
					int[] poll = q.poll();
					map[k++][i] = poll[0];
					map[k++][i] = poll[1];
				}

				tempMaxRow = Math.max(tempMaxRow, k);
			}
			maxRow = tempMaxRow;
		}
	}

	private static void print() {
		for (int[] ints : map) {
			if (ints[0] == 0) {
				break;
			}
			for (int j = 0; j < map[0].length; j++) {
				if (ints[j] == 0) {
					break;
				}
				System.out.print(ints[j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
