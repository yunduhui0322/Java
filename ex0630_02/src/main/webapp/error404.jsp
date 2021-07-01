<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ERROR 404</title>
		<style type="text/css">
			div{
				text-align: center;
			}
		</style>
	</head>
	<body>
		<div>
			<a href = "./main.jsp"><img alt="" src="./images/error404.jpg"></a>
		</div>
	</body>
</html>