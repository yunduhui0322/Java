<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%	
		String session_flag = (String)session.getAttribute("session_flag");
		if(session_flag != null){
	%>
		<%if(session_flag.equals("success")){ %>
		<a href = "./logout.jsp"><img alt="" src="../images/login.PNG"></a>
		<%} %>
	<%}else{ %>
		<a href = "./login.jsp"><img alt="" src="../images/logout.PNG"></a>
	<%} %>
			<!-- index 로그인전, 로그인후 ==>>login.jsp==>>index.jsp==>>logout.jsp -->
	</body>
</html> 