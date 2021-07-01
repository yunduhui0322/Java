<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table,th,td{
			border:1px solid black; 
			border-collapse: collapse;
			}
		</style>
	</head>
		<body>
			<table>
			
				<tr>
					<th>아이디</th><td><%=request.getParameter("id") %></td>
				</tr>
				<tr>
					<th>비밀번호</th><td><%=request.getParameter("pw") %></td>
				</tr>
				<tr>
					<th>이름</th><td><%=URLDecoder.decode(request.getParameter("name"),"utf-8") %></td>
				</tr>
			</table>
		</body>
</html>