package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1092 {

	static int N;
	static int M;
	static int[] cranes;
	static int[] boxes;
	static boolean[] isMoved;

	public static void main(String[] args) throws IOException {
		input();

		if (cranes[N - 1] < boxes[M - 1]) {
			System.out.println(-1);
			return;
		}

		int time = 0;
		int count = 0;
		while (count < M) {
			int before = M - 1;
			for (int i = N - 1; i >= 0; i--) {
				for (int j = before; j >= 0; j--) {
					if (boxes[j] <= cranes[i] && !isMoved[j]) {
						isMoved[j] = true;
						count++;
						before = j - 1;
						break;
					}
				}
			}
			time++;
		}

		System.out.println(time);
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		cranes = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			cranes[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cranes);

		M = Integer.parseInt(bf.readLine());
		boxes = new int[M];
		isMoved = new boolean[M];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(boxes);
	}
}
