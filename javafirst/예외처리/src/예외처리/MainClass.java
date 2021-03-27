package 예외처리;

public class MainClass {

	public static void main(String[] args) {
		
		int i = 10;
		int j = 0;
		int r = 0;
		
		System.out.println("Exception Before");
		
		
		try {
			r = i / j;
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			System.out.println("msg : " + msg);
		} finally {
			System.out.println("예외 발생 여부에 상관없이 언제나 실행됩니다.");
		}

		
		System.out.println("Exception After");
		
	
	
	
	}
}
