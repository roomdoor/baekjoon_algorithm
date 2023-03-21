package springProblem.copyAndHashCodeAndEquals;

public class KungFu {

	public static void main(String[] args) {
		Integer x = 400;
		Integer y = x;
		x.equals(y);
		System.out.println(x.hashCode());
		System.out.println(y.hashCode());
		Integer z = y;
		x++;
		System.out.println(x.hashCode());
		System.out.println(y.hashCode());
		System.out.println(z.hashCode());

		StringBuilder sb1 = new StringBuilder("123");
		StringBuilder sb2 = sb1;
		System.out.println(sb1.hashCode());
		System.out.println(sb2.hashCode());
		sb1.append("5");

		System.out.println((x == y) + " " + (sb1 == sb2));
	}
}
