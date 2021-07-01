<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>session result</title>
	</head>
	<body>
		<%
			if(session.getAttribute("login_id") == null){
				out.println("login_id 세션이 삭제되었습니다");
			}else{
				out.println("login_id세션이 있습니다");
			}
			//세션 전체 삭제
			session.invalidate();
		%>
	</body>
</html>