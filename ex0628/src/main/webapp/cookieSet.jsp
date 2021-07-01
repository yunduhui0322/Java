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
		Cookie cookie = new Cookie("login_id","aaa");
		Cookie nickName = new Cookie("nickName","korea");
		cookie.setMaxAge(60*30);
		nickName.setMaxAge(60*30);
		response.addCookie(cookie);
		response.addCookie(nickName);
		
		
	%>
	<a href = "cookieGet.jsp">쿠키</a>
	</body>
</html>