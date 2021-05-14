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
maven project4:  
1.의존 객체 주입 방법에는 생성자이용,setter이용,List타입 이용,Map타입 이용이 있음.  
  
생성자이용 의존객체주입

```
public StudentRegisterService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
```
```
<bean id="registerService" class="ems.member.service.StudentRegisterService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
```
setter이용 의존객체주입

```
public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
```
```
<bean id="dataBaseConnectionInfoDev" class="ems.member.DataBaseConnectionInfo">
		<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:xe" />
		<property name="userId" value="scott" />
		<property name="userPw" value="tiger" />
	</bean>
```
List타입이용 의존객체주입

```
public void setDevelopers(List<String> developers) {
		this.developers = developers;
	}
```
```
<property name="developers">
			<list>
				<value>Cheney.</value>
				<value>Eloy.</value>
				<value>Jasper.</value>
				<value>Dillon.</value>
				<value>Kian.</value>
			</list>
		</property>
```
Map타입이용 의존객체주입

```
public void setAdministrators(Map<String, String> administrators) {
		this.administrators = administrators;
	}
```
```
<property name="administrators">
			<map>
				<entry>
					<key>
						<value>Cheney</value>
					</key>
					<value>cheney@springPjt.org</value>
				</entry>
				<entry>
					<key>
						<value>Jasper</value>
					</key>
					<value>jasper@springPjt.org</value>
				</entry>
			</map>
		</property>
```
maven project5:  
1.spring 설정 파일인 applicationContext.xml이 너무 길 경우
여러 xml 파일로 나누어 설정가능함.  

xml path들을 배열로 받아 사용하는 방법

```
 String[] appCtxs = {"classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml"};
			GenericXmlApplicationContext ctx = 
					new GenericXmlApplicationContext(appCtxs);
```
하나의 xml파일에 나머지 xml파일들을 import해서 사용하는 방법

```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 		http://www.springframework.org/schema/beans/spring-beans.xsd">

	<import resource="classpath:appCtx2.xml"/>
	<import resource="classpath:appCtx3.xml"/>

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
	
</beans>
```
2. spring container의 bean설정 범위에는 싱글톤과 프로토타입이 있는데 싱글톤은 container 생성시 객체하나만
생성하여 bean호출시, 그 객체만을 사용하는 방법이고, 프로토타입은 bean호출마다 객체를 생성하여 사용하는 방법으로
특정 타입의 여러 bean객체가 생성될수 있음.

프로토타입으로 설정 방법 : bean객체 정의시 scope속성 추가

```
<bean id="dependencyBean" class="scope.ex.DependencyBean"
		scope="prototype">
		<constructor-arg ref="injectionBean" />
		<property name="injectionBean" ref="injectionBean" />
	</bean>
```
maven project6:
의존 객체 자동 주입:  
스프링 설정 파일에서 의존 객체를 주입할 때 ``<constructor-org>`` 또는 ``<property>`` 태그로
의존 대상 객체를 명시하지 않아도 스프링 컨테이너가 자동으로 필요한 의존 대상 객체를 찾아서 의존 대상 객체가 필요한 객체에 주입해 주는 기능을 함.  
구현 방법은 @Autowired, @Resource 어노테이션을 이용해서 구현함.  
  
1.appCtx xml파일에 ``<context:annotation-config />``를 명시해주고
namespace에 ``xmlns:context="http://www.springframework.org/schema/context"``를 추가해주고, schema에

```
		http://www.springframework.org/schema/beans/spring-beans.xsd 
 		http://www.springframework.org/schema/context  
 		http://www.springframework.org/schema/context/spring-context.xsd">
 ```
 를 추가해준다.
 2.자동 주입을 원하는 객체의 생성자 혹은 property, method위에 @Autowired or @Resource를
 추가함.
 3.Resource와 Autowired의 차이점은 Autowired는 컨테이너내에서 해당 의존객체 검색시
 타입으로 검색하는 반면에, Resource는 이름으로 검색한다. 그리고 Resource는 생성자에는
 적용할 수 없으며, property나 method에 적용할때에는 디폴트 생성자를 작성해주어 객체가
 우선적으로 생성될 수 있도록 해주어야 함.  
 
maven project7:  
1.컨테이너 내부에 동일한 객체가 2개 이상있는 경우 컨테이너는
 자동 주입 대상 객체를 판단하지 못해서 Exception을 발생시킨다.
 이를 해결하기 위해서는 컨테이너 내부의 원하는 bean객체에
 ``<qualifier value="usedDao"/>``처럼 qualifier 태그를
 추가해주고 이 객체를 의존객체로 사용하는 객체에서 @qualifier("usedDao")
 를 추가해준다. @qualifier 어노테이션은 생성자에는 이용할수 없는듯하다.
2.@Inject도 있는데 @Autowired와 동일한 기능을 하고, 실무에서는
 @Autowired를 주로 사용한다. Inject는 qualifier의 기능을 하는 @Named
 어노테이션을 가지고있고, qualifier와는 다르게 bean태그에 추가할 필요
 없으며, 의존객체를 사용하는 객체에 @Named("wordDao1")처럼 bean의 id
 를 사용한다.  
 
maven project8:  
1. bean 객체의 생명주기는 스프링 컨테이너의 생명주기와 같이 한다.
 스프링 컨테이너 초기화시 빈 객체가 생성 및 주입되고 스프링 컨테이너 종료시 빈객체는 소멸된다.
2. bean 객체의 생성자, 소멸자를 생성하는 방법은 interface와 method기법이 있다.
3. interface(InitializingBean, DisposableBean)
 
 ```
 public class BookSearchService implements InitializingBean, DisposableBean {

	@Autowired
	private BookDao bookDao;
	
	public BookSearchService() { }
	
	public Book searchBook(String bNum) {
		Book book = bookDao.select(bNum);
		return book;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("object dispose");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("object create");
		
	}
	
}
 ```
4.method(spring 설정파일의 bean에 init-method, destroy-method속성 추가)
 
 ```
 <bean id="bookRegisterService" class="com.brms.book.service.BookRegisterService" 
	init-method="initMethod" destroy-method="destroyMethod"/>
```
```
public class BookRegisterService {

	@Autowired
	private BookDao bookDao;
	
	public BookRegisterService() { }
	
	public void register(Book book) {
		bookDao.insert(book);
	}
	
	public void initMethod() {
		System.out.println("BookRegisterService 빈(Bean)객체 생성 단계");
	}
	
	public void destroyMethod() {
		System.out.println("BookRegisterService 빈(Bean)객체 소멸 단계");
	}
}
```
maven project9:  
1.xml 파일인 spring 설정파일을 @Configuration을 사용한 java파일로 변경할 수있다.

```
@Configuration //spring container를 생성할수 있는 설정 파일임을 명시
public class MemberConfig {

	//<bean id="studentDao" class="ems.member.dao.StudentDao" ></bean>
	@Bean // Bean 객체임을 명시
	public StudentDao studentDao() {
		return new StudentDao();
	}
	
	/*
	 <bean id="registerService" class="ems.member.service.StudentRegisterService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
	 */
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDao());
	}
	
	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService(studentDao());
	}
	
	@Bean
	public StudentSelectService selectService() {
		return new StudentSelectService(studentDao());
	}
	
	@Bean
	public StudentDeleteService deleteService() {
		return new StudentDeleteService(studentDao());
	}
	
	@Bean
	public StudentAllSelectService allSelectService() {
		return new StudentAllSelectService(studentDao());
	}
	
	/*
	 <bean id="dataBaseConnectionInfoDev" class="ems.member.DataBaseConnectionInfo">
		<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:xe" />
		<property name="userId" value="scott" />
		<property name="userPw" value="tiger" />
	</bean>
	 */
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoDev() {
		DataBaseConnectionInfo infoDev = new DataBaseConnectionInfo();
		infoDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		infoDev.setUserId("scott");
		infoDev.setUserPw("tiger");
		
		return infoDev;
	}
	
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoReal() {
		DataBaseConnectionInfo infoReal = new DataBaseConnectionInfo();
		infoReal.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:xe");
		infoReal.setUserId("masterid");
		infoReal.setUserPw("masterpw");
		
		return infoReal;
	}
	
	@Bean
	public EMSInformationService informationService() {
		EMSInformationService info = new EMSInformationService();
		info.setInfo("Education Management System program was developed in 2015.");
		info.setCopyRight("COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		info.setVer("The version is 1.0");
		info.setsYear(2015);
		info.setsMonth(1);
		info.setsDay(1);
		info.seteYear(2015);
		info.seteMonth(2);
		info.seteDay(28);
		
		ArrayList<String> developers = new ArrayList<String>();
		developers.add("Cheney.");
		developers.add("Eloy.");
		developers.add("Jasper.");
		developers.add("Dillon.");
		developers.add("Kian.");
		info.setDevelopers(developers);
		
		Map<String, String> administrators = new HashMap<String, String>();
		administrators.put("Cheney", "cheney@springPjt.org");
		administrators.put("Jasper", "jasper@springPjt.org");
		info.setAdministrators(administrators);
		
		Map<String, DataBaseConnectionInfo> dbInfos = new HashMap<String, DataBaseConnectionInfo>();
		dbInfos.put("dev", dataBaseConnectionInfoDev());
		dbInfos.put("real", dataBaseConnectionInfoReal());
		info.setDbInfos(dbInfos);
		
		return info;
	}
	
}
```
maven project10:  
	ctr + shift + o : 쓸모없는  package import들 삭제  
	drag + tap : 드래그한 부분 전체 탭  
1. annotation을 이용한 java 스프링 설정 파일은 xml 파일과 마찬가지로 용도별로 분할해서 사용할 수 있음. 주로 DAO, service부분, database 부분, 나머지 부분으로 분할해서 사용함. 한 분할 파일이 다른 분할 파일 부분을
참조하는 경우 참조되는 bean 객체를 @autowired(주입)해서 사용함.

```
public class MemberConfig3 {

	/*
	 * @Bean
		public DataBaseConnectionInfo dataBaseConnectionInfoDev() {
			DataBaseConnectionInfo infoDev = new DataBaseConnectionInfo();
			infoDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
			infoDev.setUserId("scott");
			infoDev.setUserPw("tiger");
			
			return infoDev;
		}
		
		@Bean
		public DataBaseConnectionInfo dataBaseConnectionInfoReal() {
			DataBaseConnectionInfo infoReal = new DataBaseConnectionInfo();
			infoReal.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:xe");
			infoReal.setUserId("masterid");
			infoReal.setUserPw("masterpw");
			
			return infoReal;
		}
	 */
	
	@Autowired
	DataBaseConnectionInfo dataBaseConnectionInfoDev;
	
	@Autowired
	DataBaseConnectionInfo dataBaseConnectionInfoReal;
```
2. 분할된 java spring 설정파일들은 하나의 java 파일에서 @import 해서 사용할수 있음.

```
@Import({MemberConfig2.class, MemberConfig3.class})
```
maven project11:  
![mvc_framework](https://github.com/jungboke/Java/blob/main/img/mvc_framework.PNG?raw=true)
![DispatcherServlet](https://github.com/jungboke/Java/blob/main/img/DispatcherServlet.PNG?raw=true)
![web_structure](https://github.com/jungboke/Java/blob/main/img/web_structure.PNG?raw=true)

1. web.xml파일에 spring framework가 제공하는 DispatcherServlet을 mapping하고 init-parameter로 servlet-context.xml(스프링 설정파일)을 설정하여 container가 바로 생성될 수있게 설정해줌. 만약 init-parameter를 설정안했을 때에는 자동적으로 appServlet-context.xml의 이름을 가진 설정파일로 container를 생성함.  
2. servlet-context.xml 파일에 ``<annotation-driven/>``를 입력하여 @Controller annotation을 controller 객체로 사용할 클래스에 정의 할수 있도록함.  
3. @RequestMapping annotation을 controller내의 원하는 method에 정의하여 handlerAdapter가 해당 method를 사용할수 있게 함.  
4. 해당 method가 실행되어 생성된 model 타입의 parameter를 다시 DispatcherServlet에 전달함.  
5. DispatcherServlet은 전달받은 model을 viewResolver에게 다시 전달하여 해당model에 맞는 view를 생성해 다시 클라이언트에게 전달함.  
6. HandlerMapping, HandlerAdapter, ViewResolver는 DispatcherServlet이 생성한 container에 들어있는 bean객체로 사용되며, 개발자가 직접 개발해야 하는 부분은 Controller와 View임. 

maven project12:  
1. project11의 내용의 상세설명으로 스프링 MVC 웹서비스-2 수강.  

![project_structure](https://github.com/jungboke/Java/blob/main/img/project_structure.PNG?raw=true)
![controller](https://github.com/jungboke/Java/blob/main/img/controller.PNG?raw=true)

maven project13:  
1. STS 없이 MVC project를 생성하는 방법  
(1)project 폴더 생성
![mvc_folder](https://github.com/jungboke/Java/blob/main/img/mvc_folder.PNG?raw=true)
(2)xml 설정파일들 생성  
	src-level의 pom.xml, views-level의 web.xml, appServlet내의 servlet-context.xml, 	appServlet level의 root-context.xml  
(3)pom.xml내의 groupId에 맞게 java package 생성  
(4)package내에 Controller 생성  
(5)views내에 jsp 파일 생성  

maven project14(lec17):  
1.한글처리를 위해 web.xml에 삽입할 filter 구문

```
	<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>
			org.springframework.web.filter.CharacterEncodingFilter
		</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
		<init-param>
			<param-name>forceEncoding</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>
		
	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>

```
2.member service 구현을 위해 프로젝트 생성시 만든 lec17 package에 member package 따로 생성함. 그 안에 service, controller, dao package 생성후, memberservice, membercontroller, memberdao 객체를 만듦. 이렇게 생성된 객체들을 container에 bean으로서 담기 위해 3가지 방법중 하나로 구현함. 보통 service는 @service annotation을 사용하여 스프링 설정파일에 bean 명시없이 container에 담고 @autowired로 객체 주입함. Dao는 @service와 같은 기능의 annotation인 @component,@repository중 @component를 주로 사용하여 @autowired해서 객체 주입해 사용함.

![memService](https://github.com/jungboke/Java/blob/main/img/memService.PNG?raw=true)
![memDao](https://github.com/jungboke/Java/blob/main/img/memDao.PNG?raw=true)
  
maven project15(lec17):  
1.웹 어플리케이션 : (controller,DAO,service객체) + 웹컴포넌트(html) + 뷰컴포넌트(jsp)  
2.@RequestMapping은 value와 method parameter로 이루어져 있는데, default method parameter는 method=RequestMethod.Get으로 입력하지 않을시 활용되고, value 값만 입력되어 있으면 value=는 생략가능함. Post랑 Get 일치하지 않을시, 일치하지 않는대로 활용됨. 다른 pakage에도 /memJoin이 존재시 /lec17/member/memJoin으로 구체화 가능하고 html form에 맞게 @RequestMapping도 변경해줘야함. 이때 /member를 모든 @RequestMappig에 붙이는것 대신 MemberController자체에 @RequestMapping("/member")를 써서 전체에 적용가능함.

MemberController

```
@RequestMapping(value="/memJoin", method=RequestMethod.POST)
	public String memJoin(Model model, HttpServletRequest request) {
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memMail = request.getParameter("memMail");
		String memPhone1 = request.getParameter("memPhone1");
		String memPhone2 = request.getParameter("memPhone2");
		String memPhone3 = request.getParameter("memPhone3");
		
		service.memberRegister(memId, memPw, memMail, memPhone1, memPhone2, memPhone3);
		
		model.addAttribute("memId", memId);
		model.addAttribute("memPw", memPw);
		model.addAttribute("memMail", memMail);
		model.addAttribute("memPhone", memPhone1 + " - " + memPhone2 + " - " + memPhone3);
		
		return "memJoinOk";
	}
```
memJoin.html

```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Join</h1>
	<form action="/lec17/memJoin" method="post">
		ID : <input type="text" name="memId" ><br />
		PW : <input type="password" name="memPw" ><br />
		MAIL : <input type="text" name="memMail" ><br />
		PHONE : <input type="text" name="memPhone1" size="5"> -
				<input type="text" name="memPhone2" size="5"> -
				<input type="text" name="memPhone3" size="5"><br />
		<input type="submit" value="Join" >
		<input type="reset" value="Cancel" >
	</form>
	<a href="/lec17/resources/html/login.html">LOGIN</a> &nbsp;&nbsp; <a href="/lec17/resources/html/index.html">MAIN</a>
</body>
</html>
```
3.requestParameter: RequestMapping된 함수에서 html에서 받아온 request를 사용하기 위한 3가지 방법이 있음.  
HttpServletRequest 객체를 사용해서 getParameter로 request받기

```
@RequestMapping(value="/memJoin", method=RequestMethod.POST)
	public String memJoin(Model model, HttpServletRequest request) {
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memMail = request.getParameter("memMail");
		String memPhone1 = request.getParameter("memPhone1");
		String memPhone2 = request.getParameter("memPhone2");
		String memPhone3 = request.getParameter("memPhone3");
		
		service.memberRegister(memId, memPw, memMail, memPhone1, memPhone2, memPhone3);
		
		model.addAttribute("memId", memId);
		model.addAttribute("memPw", memPw);
		model.addAttribute("memMail", memMail);
		model.addAttribute("memPhone", memPhone1 + " - " + memPhone2 + " - " + memPhone3);
		
		return "memJoinOk";
	}
```
@RequestParam을 사용하여 받기(String에 저장하는 과정 축소, parameter로 value ,required, defaultValue존재, 근데 거의 생략하고 value값만 사용)

```
public String memLogin(Model model, @RequestParam("memId") String memId, @RequestParam(value="memPw", required=false, defaultValue="1234") String memPw)
```
커맨드라인(Member객체)를 사용하여 받기(실무에서 주로 사용), request.getParameter로 받을 필요없이 member.getMemId()처럼 getter로 직접사용가능, view(jsp)에서도 moder.addAttribute로 받아서 사용할 필요없이 member.memId처럼 직접사용가능함.


```
public String memJoin(Member member)
```

maven project16(lec17):  
1.  