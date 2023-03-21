package ames.p10;

// oo 객체는 언제 Garbage Collector에서 없어지냐
public class GC {

	private Object o;

	private void doSomethingElse(Object obj) {
		o = obj;
	}

	private void doSomething() {
		Object oo = new Object();
		doSomethingElse(oo);
		oo = new Object();
		doSomethingElse(null);
		oo = null;
	}

}
