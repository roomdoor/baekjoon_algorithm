package KAKAO_BLIND_RECRUITMENT_2022.P3;

import java.util.*;
import java.lang.*;

public class Solution {
	static int n;
	static int[] info;
	static int[][] ls;  // 라이언이 얻을 수 있는 점수 기대값
	// {과녁 점수, 화살 수, 벌어지는 점수 차이}
	public int[] solution(int n1, int[] info1) {
		n = n1;
		info = info1;
		int[] answer = new int[11];
		ls = new int[11][3];

		// ls array 채움 {과녁 점수,
		//              점수를 얻기 위해 필요한 화살 수,
		//              얻을 수 있는 점수 차이}
		for (int i = 0; i < 11; i ++) {
			if (info[i] > 0) {          // 어피치가 맞춘 관녁일 때
				ls[i][0] = 10 - i;          // 과녁 점수
				ls[i][1] = info[i] + 1;     // 점수를 얻기 위해 필요한 화살 수
				ls[i][2] = (10 - i) * 2;    // 점수 차이 (라이언이 얻는 점수
				//         + 어피치가 잃는 점수)
			}else {                     // 어피치가 맞추지 못한 과녁일 때
				ls[i][0] = 10 - i;          // 과녁 점수
				ls[i][1] = 1;               // 점수를 얻기 위해 필요한 화살 수
				ls[i][2] = 10 - i;          // 점수 차이 (라이언이 얻는 점수
			}
		}

		//PriorityQueue 로 화살의 기대값을 기준으로 화살 출력 (점수 차이 / 화살 수)
		PriorityQueue<int[]> q = new PriorityQueue<>(
			(x, y) -> y[2] / y[1] == x[2] / x[1] ?
				x[1] - y[1]: (y[2] / y[1]) - (x[2] / x[1]));

		for (int[] x : ls) {
			q.add(x);
		}

		// sout("====================");
		// 기대값이 높은 과녁부터 화살을 쏘면서 기록
		int ta = 0;                     // 현재까지 사용한 화살 수
		while (!q.isEmpty() && ta < n) {    // 11 개 다 확인 or 화살 다 씀
			int[] check = q.poll();             // 현재 기대값이 가장 높은 과녁

			if (ta + check[1] > n) continue;    // 남은 화살로 이 과녁에 점수 못 얻을 때

			ta += check[1];                     // 사용한 화살 수 갱신
			answer[10 - check[0]] = check[1];   // 라이언이 쏜 화살 기록
			sout("-------------------------");
			sout("기대값 가진 과녁 = " + Arrays.toString(check));
			sout("사용한 화살 갯수 = " + ta);
			sout("현재까지 과녁 = " + Arrays.toString(answer));
		}

		int lSum = 0;   // 라이언 점수 총합
		int aSum = 0;   // 어피치 점수 총합
		int count = 0;  // 사용한 화살 수 -> 위 알고리즘에서 모든 화살 사용 안되는 경우 있음

		for (int i = 0; i < 11 ; i++) { // info, answer 돌면서 점수 기록
			count += answer[i];
			if (answer[i] > info[i] && answer[i] > 0) {
				lSum += 10 - i;
			}else if (info[i] > 0){
				aSum += 10 - i;
			}
		}

		sout("=============");
		sout("사용한 화살 수 = " + count);
		sout("라이언 점수 = " + lSum);
		sout("어피치 점수 = " + aSum);

		if (lSum <= aSum) {     // 라이언 어피치 점수 비교 후 라이언 이길 수 있는지 확인
			return new int[]{-1};
		}

		if (count < n) {        // 위 알고리즘에서 최대 점수를 얻을 수 있는 경우의 수
			// + 높은 점수에 최소의 화살 사용
			answer[10] += n - count;
		}

		return answer;
	}

	private static void sout(Object o) {
		System.out.println(o);
	}
}