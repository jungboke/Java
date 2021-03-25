package pjtTest;

public class Bicycle {

	public String color;
	public int price;
	
	public Bicycle() {
		System.out.println("Bicycle constructor1");
	}
	public Bicycle(String c, int p) {
		System.out.println("Bicycle constructor2");
		this.color = "c";
		this.price = 200;
	}
	
	public void info() {
		System.out.println("--info()--");
		System.out.println("color : " + color);
		System.out.println("price : " + price);
	}
}
