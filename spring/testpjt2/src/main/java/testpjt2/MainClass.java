package testpjt2;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
//		transportationWalk transportationwalk = new transportationWalk();
//		transportationwalk.move();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		transportationWalk transportationwalk = ctx.getBean("tWalk", transportationWalk.class);
		transportationwalk.move();
		
		ctx.close();
	}
}
