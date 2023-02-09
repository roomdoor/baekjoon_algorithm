package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P11000 {

	static int n;
	static int[][] room;
	static PriorityQueue<Integer> endTime;

	public static void main(String[] args) throws IOException {
		input();
		culRoom();

		System.out.println(endTime.size());
	}

	private static void culRoom() {
		for (int i = 0; i < n; i++) {
			if (!endTime.isEmpty() && endTime.peek() <= room[i][0]) {
				endTime.poll();
			}
			endTime.add(room[i][1]);
		}
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		room = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			room[i][0] = Integer.parseInt(st.nextToken());
			room[i][1] = Integer.parseInt(st.nextToken());
		}

		// 2차원 배열 정렬
		Arrays.sort(room, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int result = o1[0] - o2[0];
				if (result != 0) {
					return result;
				}
				return o1[1] - o2[1];
			}
		});

		endTime = new PriorityQueue<>();
	}

}
