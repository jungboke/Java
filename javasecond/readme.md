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

jsp1.project(2):  
1.jsp에서도 response,request객체는 servlet과
동일한 역할 수행함.  
2.response.sendredirection: 다른 서버file로 redirection함.  
  
jsp2.project:  
1.jsp파일은 컴파일중에 servlet파일로 변환되기 때문에
xml파일에  

```
<servlet>
  	<servlet-name>servletEx</servlet-name>
  	<jsp-file>/jspEx.jsp</jsp-file>
  	<init-param>
  		<param-name>adminId</param-name>
  		<param-value>admin</param-value>
  	</init-param>
  	<init-param>
  		<param-name>adminPw</param-name>
  		<param-value>1234</param-value>
  	</init-param>
  </servlet>
  <servlet-mapping>
  	<servlet-name>servletEx</servlet-name>
  	<url-pattern>/jspEx.jsp</url-pattern>
  </servlet-mapping>
```
처럼 servlet 파일로 init parameter를 지정할수 있다.  
이것은 config객체로 값을 얻을수 있다.  
2.또한 xml파일에 context paramter로 지정하여

```
<context-param>
  	<param-name>imgDir</param-name>
  	<param-value>/upload/img</param-value>
  </context-param>
  <context-param>
  	<param-name>testServerIP</param-name>
  	<param-value>127.0.0.1</param-value>
  </context-param>
  <context-param>
  	<param-name>realServerIP</param-name>
  	<param-value>68.0.30.1</param-value>
  </context-param>
```
특정 jsp파일이 변환된 servlet이 아닌 모든 servlet에서
application객체를 사용하여 값을 얻어낼수 있다.  
또한 applcation객체의 setAttribute,getAttribute함수를 사용하여  
특정 servlet또는 jsp파일에서 application객체에 원하는
parameter를 삽입하여 모든 servlet에서 활용가능하다.  
3.jsp파일 내에서도 out객체를 사용한 print와 exception
객체를 사용한 예외처리가 가능하다.  
  
jsp3.project:  
1.jsp2에서 배운 servlet parameter(init-param)과 context parameter(context-param)  
을 활용하여 servlet간의 데이터공유할수 있음.  

jsp4.project:  
1.http protocol은 client와 server사이에 request,response가 1번씩 진행되고 connection이 종료됨.  
그래서 로그인정보,장바구니정보 같은 내용은 cookie라는 흔적을 client browser에 남겨줘야함.

Cookie[] cookies = request.getCookies();
		Cookie cookie = null;

```		
		for(Cookie c : cookies) {
			System.out.println("c.getName() : " + c.getName() + "c.getValue() : " + c.getValue());
			
			if(c.getName().equals("memberID")) {
				cookie = c;
			}
		}
		if(cookie == null) {
			System.out.println("cookie is null");
			cookie = new Cookie("memberID", mID);
		}
		
		response.addCookie(cookie);
		cookie.setMaxAge(60*60);
		
		response.sendRedirect("loginOK.jsp");
```
jsp5 project:  
1.session은 cookie와 비슷한데 정보를 server에 저장한다는 차이가 있음.  
2.server에 저장하지만 호출법은 request.getSession()으로 request에서 뽑아냄.

```
HttpSession session = request.getSession();
		session.setAttribute("memberID", mID);
		
		response.sendRedirect("loginOK.jsp");
	}
```
3.logout할때, 서버에 저장되어있는 session을 삭제해줘야함.

```
ttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("login.jsp");
```
jsp6 project:  
1.jsp,servlet에서 한글이 처리될수 있게 하기위해서는 post방식은 servlet,jsp파일에  
request.setCharacterEncoding("UTF-8"); 추가해줘야함.  

servlet file:

```
request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
```
jsp file:

```
<% request.setCharacterEncoding("UTF-8"); %>
```
2.get방식은 server.xml에 <Connector URIEncoding="UTF-8" /> 추가해줘야함.

```
<Connector URIEncoding="UTF-8" connectionTimeout="20000" port="8090" protocol="HTTP/1.1" redirectPort="8443"/>
```
3.filter servlet file로 여러 servlet이나 jsp에 해당문구를 따로 입력하지 않고 처리가능함.  
servlet을 만들고나서 web.xml에 filter tag를 등록해줘야함.  

```
public class TempFilter implements Filter {
@Override
public void init(FilterConfig arg0) throws ServletException {
	System.out.println("--filter init()--");
}
@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
throws IOException, ServletException {
	System.out.println("--filter doFilter()--");
	
	//request filter
	req.setCharacterEncoding("UTF-8");
	chain.doFilter(req, res);
	
	//response filter
	
}
@Override
public void destroy() {
	System.out.println("--filter destroy()--");
}
}
```
web.xml:

```
  <!-- filter -->
  <filter>
  	<filter-name>tempFilter</filter-name>
  	<filter-class>com.servlet.filter.TempFilter</filter-class>
  </filter>
  <filter-mapping>
  	<filter-name>tempFilter</filter-name>
  	<url-pattern>/*</url-pattern>
  </filter-mapping>
```
jsp7 project:  
1.