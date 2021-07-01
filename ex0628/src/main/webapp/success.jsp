<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>담배를 판매해도 됩니다</h3>
		<h2>나이:<%=request.getParameter("age") %></h2>
		<h2>이름:<%=request.getParameter("name") %></h2>
		<h2>출생지:<%=request.getParameter("place") %></h2>
	</body>
</html>