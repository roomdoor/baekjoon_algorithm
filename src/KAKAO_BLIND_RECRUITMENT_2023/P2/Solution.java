package KAKAO_BLIND_RECRUITMENT_2023.P2;

public class Solution {

	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;

		int md = n - 1;
		int mp = n - 1;

		while (md >= 0 || mp >= 0) {
			while (md > 0 && deliveries[md] == 0) {
				md--;
			}
			while (mp > 0 && pickups[mp] == 0) {
				mp--;
			}

			// sout(md + " " + mp);

			answer += (Math.max(md, mp) + 1) * 2L;
			int cc = cap;

			// max md 조정
			for (int i = md; i >= 0; i--) {
				// 배달할거 있을 때
				if (deliveries[i] > 0) {
					// 해당 장소 다 내릴 수 있을 때
					if (deliveries[i] <= cc) {
						cc -= deliveries[i];
						deliveries[i] = 0;
						md = i;
						if (cc == 0) {
							break;
						}

						// 해당 장소에 물량 덜 채웠을 때
					} else {
						deliveries[i] -= cc;
						cc = 0;
						md = i;
						break;
					}
				}else {
					md--;
				}
			}

			cc = 0;
			// max mp 조정
			for (int i = mp; i >= 0; i--) {
				// 수거할 꺼 있을 때
				if (pickups[i] > 0) {
					if (cc < cap) {
						if (cc + pickups[i] <= cap) {     // 다 수거 될 때
							cc += pickups[i];
							pickups[i] = 0;
							mp = i;
							if (cc == cap) {
								break;
							}
						} else {                           // 다 못가지고 갈때
							pickups[i] -= cap - cc;
							cc = 0;
							mp = i;
							break;
						}
					}
				}else {
					mp--;
				}

			}
		}

		return answer - 2;
	}

	public static void sout(Object o) {
		System.out.println(o);
	}
}
