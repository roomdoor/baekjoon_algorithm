package springProblem.constructor;

// 상속된 생성자 실행시 상위 생성자 실행 이유
// https://velog.io/@lily_1115/java-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%83%9D%EC%84%B1%EC%9E%90-%ED%98%B8%EC%B6%9C-%EC%88%9C%EC%84%9C
class Atom {

	Atom() {
		System.out.print("atom ");
	}
}

class Rock extends Atom {

	Rock(String type) {
		System.out.print(type);
	}
}

public class Mountain extends Rock {


	Mountain() {
		super("granite ");
		new Rock("granite ");
	}

	public static void main(String[] args) {
//		new ames.p2.Mountain();
		new Rock("dd");
	}
}




