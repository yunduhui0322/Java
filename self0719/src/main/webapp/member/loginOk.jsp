<%@page import="com.site.self0719.MDto"%>
<%@page import="com.site.self0719.MDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MDao mDao = new MDao();
		MDto mDto = mDao.m_login(id, pw);
	%>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
	</head>
	<body>
		<script type="text/javascript">
			if(<%=mDto.getId() != null%>){
				alert("로그인 성공!");
				location.href = "./index.jsp";
				<%session.setAttribute("session_id", mDto.getId());
				session.setAttribute("session_nickName", mDto.getNickName());
				session.setAttribute("session_flag","success");
				%>
			}else{
				alert("아이디와 비밀번호가 일치하지 않습니다.");
				location.href = "./login.jsp";
			}
		</script>
	</body>
</html>