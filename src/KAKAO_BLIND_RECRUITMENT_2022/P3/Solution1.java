package KAKAO_BLIND_RECRUITMENT_2022.P3;

import java.util.Arrays;

public class Solution1 {

	static int n;
	static int[] info;
	static int maxDiff = 0;
	static int[] check = new int[11];
	static int[] answer = new int[11];


	public int[] solution(int n1, int[] info1) {
		n = n1;
		info = info1;

		int diff = 0;
		for (int i = 0; i < 11; i++) {
			if (info[i] > 0) {
				diff -= 10 - i;
			}
		}

		cul(0, 0, diff);


		if (maxDiff <= 0) {
			return new int[]{-1};
		}

		return answer;
	}

	private static void cul(int x, int y, int diff) {
		// sout("diff = " + diff + " " + Arrays.toString(check));

		if (y == n) {

			if (diff > maxDiff) {
				answer = check.clone();
				maxDiff = diff;
				// sout1();
			}else if(diff == maxDiff) {
				if (change()) {
					// sout1();
				}
			}
			return;
		}

		for (int i = x; i < 11; i++) {
			for (int j = 0; j <= n - y; j++) {
				if (info[i] < j) {
					int temp = check[i];
					check[i] = j;
					int a = info[i] > 0 ? 2 : 1;
					cul(i + 1, y + j, diff + (10 - i) * a);
					check[i] = temp;
					// cul(i + 1, y, sum);
					break;
				}else {
					int temp = check[i];
					check[i] = j;
					cul(i + 1, y + j, diff);
					check[i] = temp;

				}
			}
		}
	}

	private static boolean change() {
		for (int i = 10; i >=0; i--) {
			if (answer[i] == check[i]) continue;
			if(answer[i] < check[i]) {
				answer = check.clone();
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	private static void sout1() {
		sout("-------------------");
		sout("maxDiff = " + maxDiff);
		sout(Arrays.toString(info));
		sout(Arrays.toString(answer));
		sout("-------------------");
	}

	private static void sout(Object o) {
		System.out.println(o);
	}
}
