<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	아이디 : <%=request.getParameter("id") %>
	비번 : <%=request.getParameter("pw") %>
	이름 : <%=request.getParameter("name") %>
	</body>
</html>