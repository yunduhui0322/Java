<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
		<style type="text/css">
			div{
				border: 1px solid black;
				width: 400px;
				height: 60px;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<div><h3>메인페이지</h3></div>
		<%
			String session_flag = (String)session.getAttribute("session_flag");
		if(session_flag == null){%>
				<ul>
					<li><a href = "./login.jsp">로그인</a></li>
					<li><a href = "./member.jsp">회원가입</a></li>
				</ul>
			<%}else if(session_flag.equals("success")){%>
				<h3><%=session.getAttribute("session_nickName") %>님 환영합니다.</h3>
				<ul>
					<li><a href = "./logout.jsp">로그아웃</a></li>
					<li><a href = "./list.jsp">게시판</a></li>
					<li><a href = "./m_update.jsp">회원정보수정</a></li>
				</ul>
				
			<%}%>
	</body>
</html>