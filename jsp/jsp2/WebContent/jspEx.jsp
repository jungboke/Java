<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String adminId;
		String adminPw;
		
		String imgDir;
		String testServerIP;
		String realServerIP;
	%>
	
	<%
		adminId = config.getInitParameter("adminId");
		adminPw = config.getInitParameter("adminPw");
	%>
	
	<p>adminId : <%= adminId %></p>
	<p>adminPw : <%= adminPw %></p>
	
	<%
		imgDir = application.getInitParameter("imgDir");
		testServerIP = application.getInitParameter("testServerIP");
		realServerIP = application.getInitParameter("realServerIP");
		
	%>
	
	<p>imgDir : <%=imgDir%> </p>
	<p>testServerIP : <%=testServerIP %></p>
	<p>realServerIP : <%=realServerIP %></p>
	
	<%
		application.setAttribute("connectedIP", "165.62.58.23");
		application.setAttribute("connectedUser", "hong");
	
	%>
	
	<%
		out.print("<h1>Hello Java World!!</h1>");
		out.print("<h2>Hello Java World!!</h2>");
		out.print("<h3>Hello Java World!!</h3>");
	%>
	
</body>
</html>