package dynamic;

import java.util.Scanner;

public class P2748 {

	static long[] fiboArray;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		fiboArray = new long[n + 1];
		fiboArray[0] = 0;
		fiboArray[1] = 1;

		System.out.println(fibonacci(n));
	}

	private static long fibonacci(int n) {
		if (n > 1 && fiboArray[n] == 0) {
			return fiboArray[n] = fibonacci(n - 1) + fibonacci(n - 2);
		} else {
			return fiboArray[n];
		}
	}
}
