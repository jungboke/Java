
public class MainClass {

	public static void main(String[] args) {
		
		new AnonymousClass() { // 한번 사용하고 버릴 객체 생성 (일회용 재정의등에 사용)
		
			@Override
			public void Method() {
				System.out.println("--OVerride Method Start--");
			};
		}.Method();
	}
}
