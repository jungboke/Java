
package 예외처리;

import java.util.Scanner;

public class Throw {
	public static void main(String[] args) {
		
		Throw Throw001 = new Throw();
		
		try {
			Throw001.firstmethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int i;
		Scanner scanner = new Scanner(System.in);
		i = scanner.nextInt();
		System.out.println("i : " + i);
	}
	public void firstmethod() throws Exception {
		secondmethod();
	}
	public void secondmethod() throws Exception {
		thirdmethod();
	}
	public void thirdmethod() throws Exception {
		System.out.println("10 / 0 = " + (10 / 0));
	}
	
}



