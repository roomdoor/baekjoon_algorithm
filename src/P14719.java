import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14719 {

	static int h;
	static int w;
	static int[] map;

	public static void main(String[] args) throws IOException {
		input();

		System.out.println(cul());


	}

	private static int cul() {
		int sum = 0;
		for (int i = 1; i < w - 1; i++) {
			int left = 0;
			int right = 0;

			for (int j = 0; j < i; j++) {
				left = Math.max(left, map[j]);
			}

			for (int j = i; j < w; j++) {
				right = Math.max(right, map[j]);
			}

			if (map[i] <= left && map[i] <= right) {
				sum += Math.min(left, right) - map[i];
			}
		}

		return sum;
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new int[w];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < w; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
	}

}
