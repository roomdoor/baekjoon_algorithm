package KAKAO_BLIND_RECRUITMENT_2023.P4;

public class Solution {
	static int depth;
	static long[] numbers;
	static int nsLen;
	static String B;

	public int[] solution(long[] numbers1) {
		numbers = numbers1;
		nsLen = numbers.length;

		int[] answer = new int[nsLen];

		for (int i = 0; i < nsLen; i++) {
			B = DtoB(numbers[i]);

			if (dfs(B)) {
				answer[i] = 1;
			}
		}


		return answer;
	}

	private static boolean dfs(String b) {
		int l = b.length();
		int h = l / 2;

		if (l == 1) {
			return true;
		}

		int leftNode = h / 2;
		int rightNode = h + 1 + h / 2;
		String left = b.substring(0, h);
		String right = b.substring(h + 1, l);

		if (b.charAt(h) == '0'
			&& (b.charAt(leftNode) == '1' || b.charAt(rightNode) == '1')) {
			return false;
		}


		if (l > 3) {
			return dfs(left) && dfs(right);
		}

		return true;
	}

	private static String DtoB(long num) {
		StringBuilder sb = new StringBuilder();
		long temp = num;
		while (num > 0) {
			sb.append(num % 2);
			num /= 2;
		}

		depth = 0;
		while (sb.length() > Math.pow(2, depth) - 1) {
			depth++;
		}

		while (sb.length() < Math.pow(2, depth) - 1) {
			sb.append(0);
		}

		return sb.reverse().toString();
	}



	private static void sout(Object o) {
		System.out.println(o);
	}
}
// 0 -> 
// 012 -> 1(0,2)
// 0123456 -> 3(1,5)
// 012345678901234 -> 7(3, 11)