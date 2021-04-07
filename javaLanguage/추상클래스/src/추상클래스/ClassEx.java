package 추상클래스;

public class ClassEx extends AbstractClassEx {

	public ClassEx() {
		System.out.println("--ClassEx constructor--");
	}
	
	public ClassEx(int i, String s) {
		super(i,s); // 부모클래스의 생성자를 표현
	}
	
	@Override
	public void fun2() { // 추상 method를 구현
		System.out.println("--func2() Start--");
	}
}
