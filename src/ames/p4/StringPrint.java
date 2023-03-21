package ames.p4;

public class StringPrint {

	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("123");
		String s1 = "123";
		// 출력 123abc 123abc 되게 할려면 여기 어떤 코드 들어가야하냐
		sb1.append("abc");
		s1 = s1.concat("abc");
		System.out.println(sb1 + " " + s1);
	}

}
