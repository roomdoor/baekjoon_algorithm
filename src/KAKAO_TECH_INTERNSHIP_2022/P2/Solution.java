package KAKAO_TECH_INTERNSHIP_2022.P2;

import java.util.*;

public class Solution {
	static int[] q1;
	static int[] q2;
	static long[] dp;

	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		q1 = queue1;
		int len1 = q1.length;
		q2 = queue2;
		int len2 = q2.length;

		dp = new long[len1 + len2 + 1];

		for (int i = 0; i < len1; i++) {
			dp[i + 1] = dp[i] + q1[i];
		}

		for (int i = 0; i < len2; i++) {
			dp[i + len1 + 1] = dp[i + len1] + q2[i];
		}

		long sum = dp[len1 + len2];

		int left = 0;
		int right = len1;
		long mid = dp[right] - dp[left];

		while (mid != sum / 2) {
			answer++;
			// sout("mid = " + mid);
			// sout("left = " + left + " right = " + right);
			if (mid < sum / 2) {
				right++;
				if (right >= dp.length){
					return -1;
				}
			}

			if (mid > sum / 2) {
				left++;
				if (left >= dp.length || left > right){
					return -1;
				}
			}
			mid = dp[right] - dp[left];
		}

		return answer;
	}

	private static void sout(Object o) {
		System.out.println(o);
	}
}