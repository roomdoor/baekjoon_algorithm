package springProblem.variable;
// 출력 결과 물어봄
public class Pass {

	public static void main(String[] args) {
		int x = 5;
		Pass p = new Pass();
		p.doStuff(x);
		System.out.println(" main x = " + x);
	}

	void doStuff(int x) {
		System.out.println(" do Stuff x = " + x++);
	}

}
// Which Man class properly represents the relationship "Man has a best friend who is a Dog"?
//
//A. class Man extends Dog { }
//
//B. class Man implements Dog { }
//
//C. class Man { private BestFriend dog; }
//
//D. class Man { private Dog bestFriend; }
//
//E. class Man { private Dog; }
//
//F. class Man { private BestFriend; }