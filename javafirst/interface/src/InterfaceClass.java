
public class InterfaceClass implements InterfaceA, InterfaceB { // 다중 interface가능

	public InterfaceClass() {
		System.out.println("InterfaceClass constructor");
	}
	
	
	
	@Override
	public void funA() {
		System.out.println("--funA()--");
		
	}

	@Override
	public void funB() {
		System.out.println("--funB()--");
		
	}

}
