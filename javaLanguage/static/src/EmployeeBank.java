
public class EmployeeBank {

	String name;
	static int amount = 0;
	//이 클래스의 모든 객체들이 amount를 공유
	public EmployeeBank(String name) {
		this.name = name;
	}
	
	public void saveMoney(int money) {
		
		amount += money;
		System.out.println("amout :" + amount);
	}
	public void spendMoney(int money) {
		
		amount -= money;
		System.out.println("amout :" + amount);
	}
	public void getBankInfo() {
		
		System.out.println("Employee name :" + this.name);
		System.out.println("amout :" + amount);
	}
}
