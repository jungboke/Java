# Java
maven project1:  
1.maven project의 구성은 크게 src dir안에 main dir, 그안에 일반java file이 들어가있는 java dir,  
java file이 구동하기 위해 필요한 설정 file들이 들어가있는 resources file로 구성됨.  
2.가장 큰 범주인 group(spring framework)안에 여러 spring project들이 들어가있는 구조이며,  
그러한 project들은 library를 필요로 함. 그러한 library들을 import할수 있도록 해당 project의  
pom.xml file안에 아래코드를 추가하여 여러 library(spring-context,spring-aop...)등을 가져올수 있음.

```
<dependencies>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>4.1.0.RELEASE</version>
		</dependency>

	</dependencies>


	<build>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
					<encoding>utf-8</encoding>
				</configuration>
			</plugin>
		</plugins>
	</build>
```
maven project2:  
1.spring project진행순서 :  
maven project생성-> pom.xml파일에 라이브러리 import할수있는 dependency code삽입-> maven project update  

2.resources 폴더의 applicationContext.xml은 메모리에
로딩되는 spring container안에 bean(객체)들을 생성해주는
파일임. 따라서 programming 할때 new로 객체따로 생성할 필요
없음.  
3.springframework활용순서:  
원하는 객체클래스파일을 java폴더에 생성-> resources폴더에
applicationContext.xml파일 생성하고 약간의 코드 복붙후
java폴더에 생성했던 객체클래스를 bean으로 삽입->container에
해당 클래스 객체가 생성됐을테니 MainClass에서 container를
사용하기 위해 GenericXmlApplicationContext 객체를 생성해서 사용
->마지막에 사용된 컨테이너 객체 close()

MainClass

```
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
```

applicationContext.xml

```
<?xml version="1.0" encoding="UTF-8"?>


<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 		http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="tWalk" class="testpjt2.transportationWalk" />
	
</beans>
```
transportationWalk

```
package testpjt2;

public class transportationWalk {

	public void move() {
		System.out.println("도보로 이동합니다.");
	}
}

```
maven project3:  
1.DI란 Dependency injection으로 어느 객체가 다른 객체를
매개변수처럼 사용할수 있는 방법을 말함. spring에서는  
컨테이너 내부의 bean 객체가 다른 객체를 DI로 받아 사용하는
방법을 씀.

```
<bean id="studentDao" class="ems.member.dao.StudentDao" ></bean>
	
	
	<bean id="registerService" class="ems.member.service.StudentRegisterService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
	
	<bean id="modifyService" class="ems.member.service.StudentModifyService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
	
	<bean id="deleteService" class="ems.member.service.StudentDeleteService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
	
	<bean id="selectService" class="ems.member.service.StudentSelectService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
	
	<bean id="allSelectService" class="ems.member.service.StudentAllSelectService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
```