package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P19598 {
	static int n;
	static int[][] scrum;
	static PriorityQueue<Integer> queue;
	public static void main(String[] args) throws IOException {
		input();

		for (int i = 1; i < n; i++) {
			if (queue.peek() <= scrum[i][0]) {
				queue.poll();
			}
			queue.add(scrum[i][1]);
		}

		System.out.println(queue.size());

	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		scrum = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			scrum[i][0] = Integer.parseInt(st.nextToken());
			scrum[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(scrum, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] - o2[0] == 0) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});

		queue = new PriorityQueue<>();
		queue.add(scrum[0][1]);
	}

}
