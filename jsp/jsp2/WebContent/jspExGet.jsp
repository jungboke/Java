<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
		String connectedIP;
		String connectedUser;
	%>

	<%
		connectedIP = (String)application.getAttribute("connectedIP");
		connectedUser = (String)application.getAttribute("connectedUser");
	
	%>
	
	<p>conectedIP : <%=connectedIP %> </p>
	<p>conectedUser : <%=connectedUser %> </p>
		
</body>
</html>