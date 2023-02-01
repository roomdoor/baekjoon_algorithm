package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1817 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		if (n == 0) {
			System.out.println(0);
		} else {
			int curM = 0;
			int count = 0;

			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				int b = Integer.parseInt(st.nextToken());
				if (curM + b > m) {
					count++;
					curM = b;
				} else {
					curM += b;
				}
			}

			count++;

			System.out.println(count);
		}
	}
}
