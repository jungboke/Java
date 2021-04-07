package 상속;

public class ParentClass {
	
	public int price = 4000;
	
	public ParentClass() {
		System.out.println("ParentClass constructor");
	}
	
	public void ParentFunc() {
		System.out.println("--ParentFunc Start--");
	}
	
	private void privateFun() {
		System.out.println("privateFun()");
	}

	public void makejjajang() {
		System.out.println("--makejjajang()--");
	}
}
