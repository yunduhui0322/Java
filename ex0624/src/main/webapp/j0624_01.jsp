<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%="Context Path : " +request.getContextPath() %><br>
	<%="URL(전체 http주소) : " + request.getRequestURL() %><br>
	<%="URI(context path부터의 주소) : " + request.getRequestURI() %><br>
	<%= "Remote Address : " + request.getRemoteAddr() %><br>
	<%
		String file = request.getRequestURI().substring(request.getContextPath().length());
		out.println(file);
	%>
	
	</body>
</html>