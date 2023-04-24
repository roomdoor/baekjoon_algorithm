package KAKAO_TECH_INTERNSHIP_2022.P1;

import java.util.*;

public class Solution {

	static int[] scores;
	public String solution(String[] survey, int[] choices) {
		StringBuilder answer = new StringBuilder();
		scores = new int[4]; // RT, CF, JM, AN

		for (int i = 0; i < survey.length; i++) {
			culS(survey[i], choices[i]);
		}

		for (int i = 0; i < 4; i++) {
			int temp = scores[i];
			if (temp >= 0) {
				switch (i) {
					case 0 -> answer.append("R");
					case 1 -> answer.append("C");
					case 2 -> answer.append("J");
					case 3 -> answer.append("A");
				}
			}else {
				switch (i) {
					case 0 -> answer.append("T");
					case 1 -> answer.append("F");
					case 2 -> answer.append("M");
					case 3 -> answer.append("N");
				}
			}
		}

		return answer.toString();
	}

	private static void culS(String s, int c) {
		int pm = wpm(s);
		int score = ws(c);
		int num = wn(s);

		scores[num] += pm * score;

		// pp(s + " " + c);
		// pp(pm * score);
		// pp(Arrays.toString(scores));
	}

	private static int wpm(String s) {

		return switch (s.substring(0, 1)) {
			case "T", "F", "M", "N" -> -1;
			default -> 1;
		};
	}

	private static int ws(int c) {

		return switch (c) {
			case 1 -> 3;
			case 2 -> 2;
			case 3 -> 1;
			case 4 -> 0;
			case 5 -> -1;
			case 6 -> -2;
			case 7 -> -3;
			default -> 0;
		};
	}


	private static int wn(String s) {

		return switch (s.substring(0, 1)) {
			case "R", "T" -> 0;
			case "C", "F" -> 1;
			case "J", "M" -> 2;
			case "A", "N" -> 3;
			default -> 0;
		};
	}


	private static void pp(Object o) {
		System.out.println(o);
	}

}

