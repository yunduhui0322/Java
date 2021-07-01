<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
	<%
		Cookie[] cookieAll = request.getCookies();
		int count = 0;
		if(cookieAll != null){
			for(int i=0; i< cookieAll.length; i++){
				if(cookieAll[i].getName().equals("cookie_flag")){
					count = 1;
				%>
				<a href = "./logout.jsp"><img src = "../images/login.PNG"></a>
				<%}
				if(cookieAll[i].getName().equals("cookie_nName")){
					out.println("<h3>" + cookieAll[i].getValue() + "님환영합니다.</h3>");
				}
				if(cookieAll[i].getName().equals("cookie_id")){
					out.println("<h3>아이디 :" + cookieAll[i].getValue() + "</h3>");
				}
			}
		}
	%>
	<%if(count == 0){ %>
		<a href = "./login.jsp"><img src = "../images/logout.PNG"></a>
	
	<%} %>
	</body>
</html>