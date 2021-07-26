<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	request.setCharacterEncoding("utf-8");
%>
	<head>
		<meta charset="UTF-8">
		<title>el태그</title>
		<style type="text/css">
			table,th,td{
				border: 1px solid black;
				border-collapse: collapse;
			}
		</style>
	</head>
	<body>
		<h3>el태그</h3>
		<h4>${sessionScope.session_id}님 환영합니다.</h4>
		<h4>${sessionScope.session_flag} 입니다.</h4>
		<table>
			<tr>
				<th>아이디</th>
				<th>이름</th>
			</tr>
			<tr>
				<td>${param.id}</td>
				<td>${param.name}</td>
			</tr>
			
		</table>
	</body>
</html>