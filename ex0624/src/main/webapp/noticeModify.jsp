<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<h3>게시판 수정하기</h3>
	<!--noticeWrite.jsp 게시판번호,제목,내용,작성자  -->
	<!--noticeView.jsp 게시판번호,제목,내용,작성자,작성일,조회수  -->
	<!--noticeModify.jsp.jsp 게시판번호,제목,내용,작성자,작성일,조회수  -->
	<%!
		String num = "",title = "", context = "", name = "", date = "", hit = ""; 
	%>
	<%
		request.setCharacterEncoding("utf-8");
		num = request.getParameter("num");
		title = request.getParameter("title");
		context = request.getParameter("context");
		name = request.getParameter("name");
		date = request.getParameter("date");
		hit = request.getParameter("hit");
	%>
	<form action="./noticeView.jsp" method = "post">
		<label>게시판번호</label>
		<input type = "text" name = "num" id = "num" readonly value = <%=num %>><br>
		<label>제목</label>
		<input type = "text" name = "title" id = "title" value = "<%=title%>"><br>
		<label>내용</label>
		<input type = "text" name = "context" id = "context" value = "<%=context%>"><br>
		<label>작성자</label>
		<input type = "text" name = "name" id = "name" value = "<%=name%>"><br>
		<label>작성일</label>
		<input type = "text" name = "date" id = "date" readonly value = "<%=date%>"><br>
		<label>조회수</label>
		<input type = "text" name = "hit" id = "hit" readonly value = "<%=hit%>"><br>
		<input type = "submit" value = "수정하기">
		<input type = "reset" value = "취소">
	</form>
	</body>
</html>