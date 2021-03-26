package 상속;

public class MainClass {
	
	public static void main(String[] args) {
		
		FirstChildClass child = new FirstChildClass(); // childclass객체보다 parentclass객체가 더먼저 생성됨
		
		child.ParentFunc();
		child.ChildFun();
		child.makejjajang(); // override된 함수실행됨
		//child.privateFun(); // 부모클래스의 private는 상속에서 제외됨
		
		ParentClass[] pArr = new ParentClass[2];
				
		ParentClass fch = new FirstChildClass(); // 객체타입이 부모클래스여도 됨
		ParentClass sch = new SecondChildClass();
		
		pArr[0] = fch; // 부모클래스의 자료형 배열에 자식클래스 객체를 담을수 있음
		pArr[1] = sch;
		
		child.Printprice();
		// ArrayList<E> 처럼 모든 클래스의 최상위에는 Object클래스 존재
	}

}
