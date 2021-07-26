<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%
	session.setAttribute("session_id", "admin");
	session.setAttribute("session_flag", "success");
%>
	<c:redirect url="./test01.jsp">
		<c:param name="nickName1" value = "admin111"/>
		<c:param name="checkNum" value = "2000"/>
	</c:redirect>
	<head>
		<meta charset="UTF-8">
		<title>form</title>
	</head>
	<body>
		<h3>form 테스트</h3>
		<form action="./test01.jsp" name = "form" method = "post">
			<label>id</label>
			<input type = "text" name = "id" id = "id"><br>
			<label>이름</label>
			<input type = "text" name = "name" id = "name"><br>
			<input type = "submit" value = "전송">
		</form>
	</body>
</html>