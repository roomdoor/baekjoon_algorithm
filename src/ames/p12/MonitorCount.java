package ames.p12;

public class MonitorCount {

	public static synchronized void foo1() {
		System.out.println("foo1 ");
	}

	public synchronized void foo2() {
		System.out.print("foo2 ");
		System.out.println(this);
	}

	public void foo3() {
		synchronized (this) {
			System.out.print("foo3 ");
			System.out.println(this);
		}
	}

	public void foo4() {
		Class<? extends MonitorCount> aClass = this.getClass();
		synchronized (aClass) {
			System.out.print("foo4 ");
			System.out.print(this + " ");
			System.out.println(aClass);
		}
	}

	public void foo5() {
		Object o = new Object();
		synchronized (o) {
			System.out.print("foo5 ");
			System.out.println(o);
		}
	}

	public void foo6() {
		Object o = new Object();
		synchronized (o) {
			System.out.print("foo6 ");
			System.out.println(o);
		}
	}

	public static void main(String[] args) {
		foo1();
		MonitorCount monitorCount = new MonitorCount();
		monitorCount.foo2();
		monitorCount.foo3();
		monitorCount.foo4();
		monitorCount.foo5();
		monitorCount.foo6();
	}

}
