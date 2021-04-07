
public class MainClass {

	public static void main(String[] args) {
		
		//String str = "Java";
		String str = new String("Java");
		System.out.println("str : " + str);
		str = str + "_8";
		System.out.println("str : " + str);
		
		//StringBuffer // 처리속도 증가
		StringBuffer sf = new StringBuffer("Java");
		System.out.println("sf : " + sf);
		sf.append("world");
		System.out.println("sf : " + sf);
		System.out.println("sf.length() : " + sf.length());
		sf.insert(sf.length(), "~~~~");
		System.out.println("sf : " + sf);
		
		sf.delete(4, 8);
		System.out.println("sf : " + sf);
		
		//StringBuilder // 처리속도 더증가
		StringBuilder sb = new StringBuilder("Java world!!");
		System.out.println("sb : " + sb);
	}
}
