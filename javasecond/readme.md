# Java
testPjt project:  
1.dynamic webproject로 server내 project생성-> jsp file 생성하면 webcontent폴더내에 jsp파일 생성됨.  
	servlet file 생성하면 src에 servlet pakage 생성된뒤 그안에 해당 servlet file 생성됨.  
2.jsp파일은 html파일에 jsp명령어를 붙인후 jsp로 확장자명을 바꿔주기만 하면됨. 서버내에서 jsp파일이 class파일로 컴파일됨.  
3.jsp파일이나 servlet파일은 server내부에 존재하여 브라우저를 통해 해당파일에 접근하면 server가 class파일로 컴파일하고, 결과값으로
	html파일을 client에게 전송함.    

servlet1 project:  
1.http://localhost:8090/servlet1/SE에서 /servlet1은 context path로 원하는 파일의 path를 뜻함. 보통 프로젝트명임.  
	/SE는 /com.servlet.HelloServlet의 mapping url을 뜻함.  
2.response객체의 getwriter함수를 사용하여 받은 printwriter객체의 print()함수를 사용하여 webpage에 원하는 내용 출력가능함.  
3.``print("<p></p>")``처럼 html문자를 print로 출력해서 사용함.  

servlet2 project:  
1.web.xml file에

```
<servlet>
  	<servlet-name>servletEx</servlet-name>
  	<servlet-class>com.servlet.mapping</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>servletEx</servlet-name>
  	<url-pattern>/SE</url-pattern>
  </servlet-mapping>
```
   
를 통한 servlet mapping 가능함.  
2.``@WebServlet("/SE")``처럼 java annotation을 이용한 mapping도 가능함.  
  
servlet4 project:  
1.web server와 client의 request, response 과정은 httpservlet객체를 상속받은 server의 servlet으로 진행됨.  
따라서 servlet객체를 생성하면 기본적으로 httpservlet을 상속받고 request, response객체를 만들어서 통신에 사용함.  
2.servlet 생명주기는 @PostConstruct -> init() -> service(doGet) -> destroy() -> @PreDestroy 순으로
진행됨. servlet class를 생성하고 그안에 @PostConstruct init() service(doGet) destroy() @PreDestroy
를 개발자가 원하는대로 코딩함. 진행순서는 생명주기대로 진행됨.  
  
servlet5 project:  
1.client가 html의 form태그를 사용하여 유저정보를 request객체로 action에 지정된 servlet으로 전송해야함.  전송방식은 doGet,
doPost이 있고 Get은 유저정보가 url에 붙여서 전송되며, Post는 암호화되서 request객체로 전송됨.  
servlet에서 request.getParameter 혹은 select 일때 getParameterValues 함수를 통해 전송받은 form태그 정보를
활용할수 있음.  
  
jsp1 project:  
선언태그: JSP페이지에서 Java의 멤버변수 또는 메서드를 선언

		<%!
		int num = 10;
		String str = "jsp";
		ArrayList<String> list = new ArrayList<String>();
		
		public void jspMethod(){
			System.out.println("-- jspMethod --");
		}
	%>
주석태그: JSP 주석은 JSP 파일이 서블릿파일로 변환될때 제외된다

	<%-- Hello Jsp World! --%>
스크립트릿 태그: JSP페이지에 Java코드를 넣기 위한 태그

	<%
		if(num > 0) {
	%>
		<p>num > 0 </p>
	<%
		}else{
	%>
		<p> num <=0 </p>
	<%
		}
	%>
표현식 태그: Java의 변수 및 메서드의 반환값을 출력하는 태그

	num is <%= num %>
지시어: 서버에서 jsp페이지를 처리하는 방법에 대한 정의
page: 페이지 기본설정
	
	<%@ page language="java" contentType="text/html; charset=EUC-KR“ pageEncoding="EUC-KR"%>
지시어
include: include file 설정

	<%@ include file=“header.jsp"%>
지시어
taglib: 외부라이브러리 태그 설정

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix=“c"%>