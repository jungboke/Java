package 추상클래스;

public abstract class AbstractClassEx { // 추상클래스로 객체생성불가
	
	int num;
	String str;
	
	public AbstractClassEx() {
		System.out.println("--AbstractClassEx constructor");
	}
	public AbstractClassEx(int i, String s) {
		System.out.println("--AbstractClassEx constructor");
		this.num = i;
		this.str = s;
	}
	
	public void fun1() {
		System.out.println("--fun1() Start--");
	}
	public abstract void fun2(); // 추상 method, 상속받는 class에서 구현해야함

}
