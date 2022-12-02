package bruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P1174 {

	static int n;
	static List<Long> list = new ArrayList<>();

	public static void main(String[] args) {
		input();
		culDn(0, 9);

		Collections.sort(list);
//		System.out.printf("%5s 번쨰", " ");
//		for (int i = 0; i < 10; i++) {
//			System.out.printf("%12d", i);
//		}
//		System.out.println();
//
//		for (int i = 0; i < list.size(); ) {
//			int count = 0;
//			System.out.printf("%5d 번째", i);
//			while (count < 10) {
//				if (i < list.size()) {
//					System.out.printf("%12d", list.get(i++));
//					count++;
//				} else {
//					break;
//				}
//			}
//			System.out.println();
//		}

		if (n > 1023) {
			System.out.println(-1);
		} else {
			System.out.println(list.get(n - 1));
		}
	}

	private static void culDn(long n, int num) {
		if (!list.contains(n)) {
			list.add(n);
		}

		if (num < 0) {
			return;
		}

		culDn(n * 10 + num, num - 1);
		culDn(n, num - 1);
	}


	private static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
	}
}