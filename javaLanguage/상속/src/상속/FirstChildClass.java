package 상속;

public class FirstChildClass extends ParentClass { // 다중상속 지원안함
	
	public int price = 3000;
	
	public FirstChildClass() {
		System.out.println("ChildClass constructor");
	}
	
	public void ChildFun() {
		System.out.println("--childFun() Start--");
	}

	@Override
	public void makejjajang() {
		System.out.println("--first more makejjajang()--");
	}
	
	public void Printprice() {
		System.out.println("my price : " + this.price);
		System.out.println("parent price : " + super.price); // super는 부모클래스 지칭
	}
}
