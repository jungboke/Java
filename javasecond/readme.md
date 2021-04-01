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
  
servlet3 project:  

