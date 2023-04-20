package KAKAO_BLIND_RECRUITMENT_2023.P5;

import java.util.*;

public class Solution {
	static String[] commands;
	static String[][] map;
	static int[][] mm;
	static List<String> answer;
	public String[] solution(String[] commands1) {
		commands = commands1;
		answer = new ArrayList<>();
		map = new String[51][51];

		mm = new int[51][51];
		for (int i = 0; i < 51; i++) {
			for (int j = 0; j < 51; j++) {
				mm[i][j] = getC(i, j);
			}
		}


		rc();

		String[] a = new String[answer.size()];
		for (int i = 0; i < answer.size(); i++) {
			a[i] = answer.get(i);
		}

		return a;
	}

	public static void rc() {
		for (String cc : commands) {
			String[] c = cc.split(" ");

			switch (c[0]) {
				case "UPDATE" :
					update(c);
					break;

				case "MERGE" :
					merge(c[1], c[2], c[3], c[4]);
					break;

				case "UNMERGE" :
					unmerge(c[1], c[2]);
					break;

				case "PRINT" :
					int row = Integer.parseInt(c[1]);
					int cul = Integer.parseInt(c[2]);
					String value = map[row][cul];
					if (value == null) {
						answer.add("EMPTY");
					}else {
						answer.add(value);
					}

					break;
			}

			// if(!c[0].equals("PRINT")) {
			//     soutAll(c[0]);
			// }
		}
	}


	// merge
	public static void merge(String row1, String cul1,
		String row2, String cul2) {
		int r1 = Integer.parseInt(row1);
		int c1 = Integer.parseInt(cul1);
		int r2 = Integer.parseInt(row2);
		int c2 = Integer.parseInt(cul2);

		if (r1 == r2 && c1 == c2) {
			return;
		}

		if (mm[r1][c1] == mm[r2][c2]) {
			return;
		}

		int temp = mm[r2][c2];
		String tempS = map[r1][c1];
		if (map[r1][c1] == null) {
			tempS = map[r2][c2];
		}

		for (int i = 1; i < 51; i++) {
			for (int j = 1; j < 51; j++) {
				if (mm[i][j] == temp) {
					mm[i][j] = mm[r1][c1];
					map[i][j] = tempS;
				}
			}
		}

		temp = mm[r1][c1];

		for (int i = 1; i < 51; i++) {
			for (int j = 1; j < 51; j++) {
				if (mm[i][j] == temp) {
					map[i][j] = tempS;
				}
			}
		}
	}

	//unmerge
	public static void unmerge(String row, String cul) {
		int r = Integer.parseInt(row);
		int c = Integer.parseInt(cul);

		String v = map[r][c];
		int count = mm[r][c];

		for (int i = 1; i < 51; i++) {
			for (int j = 1; j < 51; j++) {
				if (count == mm[i][j]) {
					mm[i][j] = getC(i , j);
					map[i][j] = null;
				}
			}
		}

		map[r][c] = v;
	}



	public static void update(String[] comend) {
		if (comend.length == 3) {    // 치환 v1 - > v2
			String v1 = comend[1];
			String v2 = comend[2];

			for (int i = 1; i < 51; i++) {
				for (int j = 1; j < 51; j++) {
					if (map[i][j] != null && map[i][j].equals(v1)) {
						map[i][j] = v2;
					}
				}
			}

			// sout("============");
			// sout(v1);
			// sout(v2);
			// sout(vm.get(v2));
			// sout(vm.get(v1));

		} else {                // 대입
			int row = Integer.parseInt(comend[1]);
			int cul = Integer.parseInt(comend[2]);
			String v = comend[3];
			int count = mm[row][cul];

			for (int i = 1; i < 51; i++) {
				for (int j = 1; j < 51; j++) {
					if (mm[i][j] == count) {
						map[i][j] = v;
					}
				}
			}


			map[row][cul] = v;

		}

		// sout("update");
		// soutmap();
		// sout(" ");
	}


	public static int getC(int r, int c) {
		return r * 50 + c;
	}

	private static void sout(Object o) {
		System.out.println(o);
	}

	private static void soutAll(Object o) {
		sout("o");
		soutmap();
		sout(" ");
		soutmm();
		sout(" ");
	}

	private static void soutmap() {
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (map[i][j] == null) {
					System.out.print("[]");
				}else {
					System.out.print("[" + map[i][j] + "]");
				}
			}
			sout(" ");
		}
	}

	private static void soutmm() {
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				System.out.print("[" + mm[i][j] + "]");
			}
			sout(" ");
		}
	}
}


// for (int i = 0; i < 50; i++) {
//     for (int j = 0; j < 50; j++) {

//     }
// }

// 1. UPDATE r c value : map[r - 1][c - 1] = value
// 2. UPDATE value1 value2 : value1 -> value2
// 3. MERGE r1 c1 r2 c2 : 병합 -> r1 c1 의 값을 가짐      
// 4. UNMERGE r c : map[r][c] 가 병합된 셀 모두 해제
// 5. PRINT r c : 셀 값 출력 없으면 empty
// 