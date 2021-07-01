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
		<% 
		   String name = URLEncoder.encode(request.getParameter("name"),"utf-8");
		   String place = URLEncoder.encode(request.getParameter("place"),"utf-8");
		   int bornYear = 0;
		   int age = 2021;
		   bornYear = Integer.parseInt(request.getParameter("bornYear"));
		   age -= (bornYear);
		   age += 1;
		   if(age>=20){
			   response.sendRedirect("success.jsp?age="+age+"&name="+name+"&place="+place);
		   }else{
			   response.sendRedirect("fail.jsp?age="+age+"&name="+name+"&place="+place);
		   }
		%>
	</body>
</html>