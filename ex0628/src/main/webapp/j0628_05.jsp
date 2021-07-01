<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jsp:forward-param</title>
	</head>
		<body>
			<jsp:forward page="result.jsp">
				<jsp:param value="admin" name="id"/>
				<jsp:param value="1234" name="pw"/>
				<jsp:param value='<%=URLEncoder.encode("관리자","utf-8") %>' name="name"/>
			</jsp:forward>
		</body>
</html>