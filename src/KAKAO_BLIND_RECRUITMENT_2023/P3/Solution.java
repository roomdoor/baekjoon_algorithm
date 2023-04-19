package KAKAO_BLIND_RECRUITMENT_2023.P3;

import java.util.*;

public class Solution {
	static int[][] u;
	static int[] em;
	static int[] dc;
	static int[] up;
	static boolean[] canPlus;
	static int count = 0;
	static int[] ctp;
	public int[] solution(int[][] users, int[] emoticons) {
		int[] answer = {};
		em = emoticons;
		Arrays.sort(em);
		u = users;

		dc = new int[em.length];
		Arrays.fill(dc, 40);
		up = new int[u.length];
		canPlus = new boolean[u.length];
		ctp = new int[u.length + 1];
		dfs(0);



		return new int[]{count, ctp[count]};
	}


	private static void dfs(int k) {
		cul();
		// sout("dfs=================");
		// sout(Arrays.toString(dc));
		// sout(Arrays.toString(up));
		for(int i = k; i < em.length; i ++) {
			if(dc[i] > 0) {
				dc[i] -=10;
				dfs(i);
				dc[i] +=10;
			}
		}
	}

	private static void cul() {
		// sout("cul=================");
		up = new int[u.length];
		canPlus = new boolean[u.length];
		for (int i = 0; i < u.length; i++) {
			for (int j = 0; j < em.length; j++) {
				if (dc[j] >= u[i][0]) {
					up[i] += (int) em[j] * (100 - dc[j]) / 100;
				}
			}

			if (u[i][1] <= up[i]) {
				canPlus[i] = true;
				// sout("up[" + i + "] = " + up[i]);
			}
		}

		int tempCount = 0;
		for (boolean b : canPlus) {
			if(b) tempCount++;
		}

		// sout("tempCount = " + tempCount);

		if (count <= tempCount) {
			count = tempCount;
			int tempP = 0;
			for (int i = 0; i < u.length; i++) {
				if (!canPlus[i]) {
					tempP += up[i];
				}
			}
			ctp[count] = Math.max(ctp[count], tempP);
			// sout("===============================");
			// sout("count = " + count + " ctp[count] = " +  ctp[count]);
			// sout("dc = " + Arrays.toString(dc));
			// sout("up = " + Arrays.toString(up));

		}
	}


	private static void sout(Object o) {
		System.out.println(o);
	}
}

// 1. user 가 플친 가입 가능한지 확인
// 2. user 플친 가입 가능할 때 최소 할인 값 구해야함
// 3. 유저마다 구해진 최소 할인값중 최대 값으로 이모티콘 할인 해야함
// 4. 플친 가입 안되는 유저에게 해당 할인값으로 이모티콘 값 결제
