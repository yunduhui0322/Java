<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ERROR500</title>
		<style type="text/css">
			div{
				text-align: center;
			}
		</style>
	</head>
	<body>
		<div>
			<a href = "./main.jsp"><img alt="" src="./images/error500.gif"></a>
		</div>
	</body>
</html>