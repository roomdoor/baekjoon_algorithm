package cumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16139re {

	static String s;
	static int q;
	static int[][] countString;
	static int[][] qRange;
	static String[] qString;


	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		s = bf.readLine();
		q = Integer.parseInt(bf.readLine());
		qRange = new int[q][2];
		qString = new String[q];
		countString = new int[s.length() + 1][26];

		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			qString[i] = st.nextToken();
			qRange[i][0] = Integer.parseInt(st.nextToken());
			qRange[i][1] = Integer.parseInt(st.nextToken()) + 1;
		}

		for (int i = 1; i < s.length() + 1; i++) {
			countString[i] = countString[i - 1].clone();
			countString[i][s.charAt(i - 1) - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			int stringNumber = qString[i].charAt(0) - 'a';
			int start = qRange[i][0];
			int end = qRange[i][1];
			int startSum = countString[start][stringNumber];
			int endSum = countString[end][stringNumber];
			int result = endSum - startSum;

			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}