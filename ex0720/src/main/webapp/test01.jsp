<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%request.setCharacterEncoding("utf-8"); %>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<h3></h3>
	<h3>${param.nickName1 }</h3>
	<h3>${param.checkNum }</h3>
	<% int number2 = 1000; %>
	<c:set var = "number" value = "<%=number2 %>"/>
	<h3>number 변수의 값: ${number }</h3>
	<h3>number2 변수의 값 :<%=number2 %></h3>
	<hr>
	<c:set var="choice" value="2"/>
	<c:choose>
		<c:when test="${choice==1}">
			<h3>기모찌</h3>
		</c:when>
		<c:otherwise>
			<h3>잘못된 입력을 하셨습니다.</h3>
		</c:otherwise>
	</c:choose>
	<hr>
	<c:if test="${(!empty param.id) && (!empty param.name)}" >
		<table>
			<tr>
				<th>이름</th>
				<th>아이디</th>
			</tr>
			<tr>
				<td>${param.name}</td>
				<td>${param.id}</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${(empty param.id) || (empty param.name)}">
		<h3>아이디 또는 이름이 입력되지 않았습니다.</h3>
	</c:if>
	<P><a href = "./formTest.jsp">메인페이지</a></p>
	</body>
</html>