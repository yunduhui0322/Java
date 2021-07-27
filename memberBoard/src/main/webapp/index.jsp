<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
		<h2>메인페이지</h2>
		<ul>
			<li><a href = "../login.do">로그인</a></li>
			<li><a href = "../member.do">회원가입</a></li>
			<li><a href = "../logout.do">로그아웃</a></li>
			<li><a href = "./board/bList.do">게시판</a></li>
			<li><a href = "./member_modify.do">회원정보수정</a></li>
		</ul>
	</body>
</html>