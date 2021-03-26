package 상속;

public class SecondChildClass extends ParentClass {
	
	public SecondChildClass() {
		System.out.println("ChildClass constructor");
	}
	
	public void ChildFun() {
		System.out.println("--childFun() Start--");
	}

	@Override
	public void makejjajang() {
		System.out.println("--second more makejjajang()--");
	}
}
