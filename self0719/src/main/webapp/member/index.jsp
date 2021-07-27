<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
	<h1>메인페이지</h1>
	<%
		if(session.getAttribute("session_flag") == null){
	%>
	<ul>
		<li><a href = "./login.jsp">로그인</a></li>
		<li><a href = "./board/b_list.jsp">게시판 리스트</a></li>
		<li><a href = "./m_insert.jsp">회원가입</a></li>
	</ul>
	<%}else if(session.getAttribute("session_id").equals("admin")){ %>
	<h3><%=session.getAttribute("session_nickName") %> 님 환영합니다.</h3>
	<ul>
		<li><a href = "./logout.jsp">로그아웃</a></li>
		
		<li><a href = "./m_list.jsp">회원정보 리스트</a></li>
		<li><a href = "../board/b_list.jsp">게시판 리스트</a></li>
	</ul>
	<%}else{ %>
	<h3><%=session.getAttribute("session_nickName") %> 님 환영합니다.</h3>
	<ul>
		<li><a href = "./logout.jsp">로그아웃</a></li>
		<li><a href = "./m_modify.jsp">회원정보 수정</a></li>
		<li><a href = "../board/b_list.jsp">게시판 리스트</a></li>
	</ul>
	<%} %>
	</body>
</html>