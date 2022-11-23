package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P13164 {

	static int N;
	static int K;
	static long[] students;
	static int result;
	static boolean[] isChecked;


	public static void main(String[] args) throws IOException {
		input();

		result = 0;
		PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - y[1]);

		for (int i = 0; i < N - 1; i++) {
			int diff = (int) (students[i + 1] - students[i]);
			queue.add(new int[]{i, diff});

			if (queue.size() > K - 1) {
				queue.poll();
			}
		}

		int minIndex = 0;
		while (!queue.isEmpty()) {
			long point = queue.poll()[0];
			result += students[(int) point] - students[minIndex];
			minIndex = (int) (point + 1);
		}
		result += students[N - 1] - students[minIndex];

		System.out.println(result);
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		students = new long[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			students[i] = Long.parseLong((st.nextToken()));
		}
	}
}
