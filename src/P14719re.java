import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14719re {

	static int h;
	static int w;
	static int[] map;
	static int maxH;
	static int minH;

	public static void main(String[] args) throws IOException {
		input();

		System.out.println(cul());


	}

	private static int cul() {
		int sum = 0;
		int curH = maxH;
		while (curH > minH) {

			for (int i = 0; i < w; i++) {
				if (map[i] >= curH) {
					i++;
					int count = 0;

					while (map[i] < curH && i < w) {
						if (i == w - 1) {
							if (map[i] < curH) {
								break;
							} else {
								sum += count;
								break;
							}
						}

						count++;
						i++;
					}
				}
			}
			curH--;
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
			maxH = Math.max(maxH, map[i]);
			minH = Math.min(minH, map[i]);
		}
	}

}
