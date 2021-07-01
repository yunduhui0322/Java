<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
		<body>
			<% Cookie[] cookies = request.getCookies(); 
			   
				for(int i=0; i<cookies.length;i++){
					String value = cookies[i].getValue(); 
					String str =cookies[i].getName();//Cookie에 저장되어있는 모든이름을 가져옴
					if(str.equals("login_id")){
						out.println("login_id=aaa쿠키가 존재합니다."+"<br>");
					}
					
					out.println("쿠키이름: " + str + "," + "쿠키value : "+ value +"<br>");
				}
			%>
		</body>
</html>