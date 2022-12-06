package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11723 {

	static int n;
	static Integer[] map = new Integer[20];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String m = st.nextToken();
			int x;
			switch (m) {
				case "add":
					x = Integer.parseInt(st.nextToken());
					if (map[x - 1] == null) {
						map[x - 1] = x;
					}
					break;

				case "remove":
					x = Integer.parseInt(st.nextToken());
					if (map[x - 1] != null) {
						map[x - 1] = null;
					}
					break;

				case "check":
					x = Integer.parseInt(st.nextToken());
					if (map[x - 1] == null) {
						sb.append(0).append("\n");
					} else {
						sb.append(1).append("\n");
					}
					break;

				case "toggle":
					x = Integer.parseInt(st.nextToken());
					if (map[x - 1] == null) {
						map[x - 1] = x;
					} else {
						map[x - 1] = null;
					}
					break;

				case "all":
					for (int j = 0; j < 20; j++) {
						map[i] = j + 1;
					}
					break;

				case "empty":
					map = new Integer[20];
					break;
			}
		}

		System.out.println(sb.toString());
	}

}
