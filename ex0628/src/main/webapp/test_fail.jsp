<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<h3>시험번호 :<%=request.getParameter("num") %></h3>
		<h3>이름 :<%=request.getParameter("name") %></h3>
		<h3>점수 :<%=request.getParameter("score") %></h3>
	<h1>불합격입니다!!</h1>
	</body>
</html>