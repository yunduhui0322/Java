<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %><!-- 에러코드 볼려면 page isErrorPage = "true" -->
<% response.setStatus(200); %><!-- 정상적인 페이지로 보이기위한 코드 -->
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
			<img alt="" src="./images/error500.png">
		</div>
	</body>
</html>