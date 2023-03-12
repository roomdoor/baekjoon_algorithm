import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
		List<Integer> cols = new ArrayList<>();
		int sum = 0;
		int now = map[0];
		int point = 1;
		int max = 0;

		while (point < w - 1) {
			if (now > map[point]) {
				max = Math.max(map[point], max);
				cols.add(map[point]);
			} else {
				max = Math.min(now, map[point]);
				sum += culWater(cols, max);
				cols = new ArrayList<>();
				now = map[point];
				max = 0;
			}
			point++;
		}

		if (map[point] != 0) {
			max = Math.min(now, map[point]);
			sum += culWater(cols, max);
		}

		return sum;
	}

	private static int culWater(List<Integer> cols, int max) {
		int sum = 0;
		for (Integer col : cols) {
			sum += max - col;
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
