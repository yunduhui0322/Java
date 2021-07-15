<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
		<h3>메인페이지</h3>
	<%
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
	%>
	<%if(name != null){ %>
		<h4><%=name %>님 환영합니다.</h4>
		<ul>
			<li><a href = "./logout.jsp">로그아웃</a></li>
			<li><a href ="./modify.jsp">회원정보수정</a></li>
		</ul>
	<%}else{ %>
		<ul>
			<li><a href = "./login.jsp">로그인</a></li>
			<li><a href = "./join.jsp">회원가입</a></li>
		</ul>
	<%} %>
	</body>
</html>