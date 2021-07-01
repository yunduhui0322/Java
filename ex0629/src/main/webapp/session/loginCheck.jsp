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
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			//id,pw 비교
			if(id.equals("aaa") && pw.equals("1234")){
			//세션넣기
			session.setAttribute("session_id","aaa");
			session.setAttribute("session_nName","세션");
			session.setAttribute("session_flag","success");
			
			response.sendRedirect("./index.jsp");	
			}else{
				//id,pw불일치 - > alert호출
				response.sendRedirect("./login.jsp?flag=fail");
			}
		%>
	</body>
</html>