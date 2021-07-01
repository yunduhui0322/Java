<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
	<%
		String session_flag = (String)session.getAttribute("session_flag");
		String session_id = (String)session.getAttribute("session_id");
		String session_nName = (String)session.getAttribute("session_nName");
		if(session_flag != null){
	%>
		<%if(session_flag.equals("success")){%>
		<%out.println( "<h3>"+session_nName + "님 환영합니다.</h3>"); 
		  out.println( "<h3>아이디:"+session_id + "</h3>"); 
		%>
		<a href = "./logout.jsp"><img src = "../images/login.PNG"></a>
		<%} %>
	<%}else{ %>
		<a href = "./login.jsp"><img src = "../images/logout.PNG"></a>
	
	<%} %>
	</body>
</html>