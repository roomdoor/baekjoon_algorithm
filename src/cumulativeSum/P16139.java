package cumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P16139 {

	static String s;
	static int q;
	static Map<String, Integer> w;
	static Map<Integer, String> wn;
	static int[][] cs;
	static int[][] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		s = bf.readLine();
		q = Integer.parseInt(bf.readLine());
		w = new HashMap<>();
		wn = new HashMap<>();
		nums = new int[q][2];

		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String x = st.nextToken();
			w.put(x, Math.min(w.getOrDefault(x, Integer.MAX_VALUE), i));
			wn.put(i, x);
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = Integer.parseInt(st.nextToken()) + 1;
		}
		cs = new int[s.length() + 1][w.size()];

		for (int i = 1; i < s.length() + 1; i++) {
			String key = String.valueOf(s.charAt(i - 1));
//			cs[i] = cs[i - 1].clone();

			System.arraycopy(cs[i - 1], 0, cs[i], 0, cs[0].length);

			if (w.containsKey(key)) {
				cs[i][w.get(key)]++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			Integer qStringNumber = w.get(wn.get(i));
			int qEnd = nums[i][1];
			int qStart = nums[i][0];
			int result = cs[qEnd][qStringNumber] - cs[qStart][qStringNumber];
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}