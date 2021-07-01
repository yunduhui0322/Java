<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>result</title>
	</head>
	<body>
	<%
	Cookie[] cookiesAll = request.getCookies();
	if(cookiesAll == null){
		out.println("쿠키가 모두 삭제되었습니다.");
	}
	%>
	
	</body>
</html>