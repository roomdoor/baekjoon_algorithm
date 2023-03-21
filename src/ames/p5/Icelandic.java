package ames.p5;

// Garbage Collector 묻는 질문
// how many object are eligible for the GC?
// 2만 남고 1, 3 필요없어서 두개 삭제될듯
public class Icelandic {

	public void makeNoise() {
		System.out.println("winny");
	}

	interface Animal {
		void makeNoise();
	}

	class Horse implements Animal {

		Long weight = 1200L;

		@Override
		public void makeNoise() {
			System.out.println("whinny");
		}
	}

	public static void main(String[] args) {
		Icelandic i1 = new Icelandic();
		System.out.println("i1 생성");
		System.out.println(i1);
		System.out.println();
		Icelandic i2 = new Icelandic();
		System.out.println("i2 생성");
		System.out.println(i2);
		System.out.println();
		Icelandic i3 = new Icelandic();
		System.out.println("i3 생성");
		System.out.println(i3);
		System.out.println();

		i3 = i1;
		System.out.println("i3 = i1;");
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println();
		i1 = i2;
		System.out.println("i1 = i2;");
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println();
		i2 = null;
		System.out.println("i2 = null;");
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println();
		i3 = i1;
		System.out.println("i3 = i1;");
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println();
	}
}
