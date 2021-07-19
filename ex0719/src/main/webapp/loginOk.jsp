<%@page import="com.site.ex0719.UDao"%>
<%@page import="com.site.ex0719.UDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		UDao uDao = new UDao();
		UDto uDto =	uDao.loginUser(id, pw);
	%>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 확인</title>
		<script type="text/javascript">
			if(<%=uDto.getId() == null%>){
				alert("아이디와 비밀번호가 일치하지 않습니다.");
				location.href = "./login.jsp";
			}else{
				alert("로그인 성공");
				<%
					session.setAttribute("session_id", uDto.getId());
					session.setAttribute("session_nickName", uDto.getNickName());
					session.setAttribute("session_flag", "success");
					session.setAttribute("session_uDto", uDto);
				%>
				location.href = "./index.jsp";
			}
		</script>
	</head>
	<body>
		
	</body>
</html>