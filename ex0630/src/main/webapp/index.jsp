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
		
			/* session.setAttribute("s_flag", "success"); */
			String s_flag = (String)session.getAttribute("s_flag");
			if(s_flag.equals("success")){
				out.println("<h3>로그인이 되었슴둥</h3>");
			}
			
			session.invalidate();
		%>
	</body>
</html>