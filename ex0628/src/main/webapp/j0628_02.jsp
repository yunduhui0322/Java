<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="./rCheck.jsp">
			<label>이름 입력해주세요.</label>
			<input type = "text" name = "name" id = "name"><br>
			<label>출생지 입력해주세요.</label>
			<input type = "text" name = "place" id = "place"><br>
			<label>출생년도를 입력해주세요.</label>
			<input type = "text" name = "bornYear" id = "bornYear">
			<input type = "submit" value = "전송">
		</form>
	</body>
</html>