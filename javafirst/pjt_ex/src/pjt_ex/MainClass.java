package pjt_ex;

public class MainClass {

	public static void main(String[] args) {
		
		Bicycle myBicycle = new Bicycle(); // new 옆에 생성자모양
		myBicycle.color = "red";
		myBicycle.price = 100;
		
		myBicycle.info();
	}
}
