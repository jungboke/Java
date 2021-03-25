
public class MainClass {

	public static void main(String[] args) {
		
		Student student1 = new Student("홍길동", 90);
		student1.getInfo();
		
		student1.setScore(100);
		//private접근하기위한 setter
		student1.getInfo();
		
	}
}
