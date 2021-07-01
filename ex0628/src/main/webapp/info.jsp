<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%  request.setCharacterEncoding("utf-8");
		String name = URLEncoder.encode(request.getParameter("name"),"utf-8");
		String id = URLEncoder.encode(request.getParameter("id"),"utf-8");
		String pw = URLEncoder.encode(request.getParameter("pw2"),"utf-8");
	%>
	<jsp:forward page="sub.jsp">
		<jsp:param value='<%=request.getParameter("name") %>' name="name"/>
		<jsp:param value="<%=id %>" name="id"/>
		<jsp:param value="<%=pw %>" name="pw"/>
	</jsp:forward>
	</body>
</html>