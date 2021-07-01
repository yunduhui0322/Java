<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>session get</title>
	</head>
	<body>
	<%
		//세션 가져오기
		String login_id = (String)session.getAttribute("login_id");
		String login_nName = (String)session.getAttribute("login_nName");
		String login_flag = (String)session.getAttribute("login_flag");
		out.println(login_id +"," + login_nName + "," + login_flag);
		
/* 		//세션전체 삭제
		session.invalidate(); */
		//세션 1개 삭제
		session.removeAttribute("login_id");
	%>
	
	<a href = "sessionResult.jsp">세션 결과</a>
	</body>
</html>