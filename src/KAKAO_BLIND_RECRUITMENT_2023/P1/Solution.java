package KAKAO_BLIND_RECRUITMENT_2023.P1;

import java.util.*;
import java.lang.*;
import java.time.LocalDate;

public class Solution {
	public int[] solution(String today, String[] terms, String[] privacies) {
		List<Integer> answer = new ArrayList<>();
		LocalDate t = td(today);


		Map<String, Integer> term = new HashMap<>();
		for (int i = 0; i < terms.length; i++) {
			String[] temp = terms[i].split(" ");
			term.put(temp[0], Integer.parseInt(temp[1]));
		}


		for (int i = 0; i < privacies.length; i++) {
			String[] temp = privacies[i].split(" ");
			int m = term.get(temp[1]);

			String s = temp[0];
			if (td(temp[0]).plusMonths(m).minusDays(1).isBefore(t)) {
				answer.add(i + 1);
			}
		}

		int[] a = new int[answer.size()];

		for (int i = 0; i < answer.size(); i++) {
			a[i] = answer.get(i);
		}

		return a;
	}

	private static LocalDate td(String s) {
		return LocalDate.of(
			Integer.parseInt(s.substring(0,4)),
			Integer.parseInt(s.substring(5,7)),
			Integer.parseInt(s.substring(8,10))
		);
	}


	private static void pp(Object o){
		System.out.println(o);
	}


}
