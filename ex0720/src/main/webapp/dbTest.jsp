<%@page import="java.util.ArrayList"%>
<%@page import="com.site.ex0720.BoardVo"%>
<%@page import="com.site.ex0720.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%
	BoardDao boardDao = new BoardDao();
	ArrayList<BoardVo> list = boardDao.selectAllUser();
%>
	<c:set var = "list" value = "<%=list %>"/>
	<head>
		<meta charset="UTF-8">
		<title>길동이 게시판</title>
	</head>
	<body>
		<h3>el태그 1번 정보</h3>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${list}" var="boardVo">
			<tr>
				<td>${boardVo.bId}</td>
				<td>${boardVo.bTitle}</td>
				<td>${boardVo.bName}</td>
				<td>${boardVo.bDate}</td>
				<td>${boardVo.bHit}</td>
			</tr>
			</c:forEach>
			
		</table>
	</body>
</html>