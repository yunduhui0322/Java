<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>cookieGet</title>
	</head>
	<body>
		<%
			Cookie[] cookiesAll = request.getCookies(); 
			
			for(int i=0; i<cookiesAll.length;i++){
				String cookiesName = cookiesAll[i].getName(); //key값을 가져옴
				String cookiesValue = cookiesAll[i].getValue();//value값을 가져움
				
				
				out.println("쿠키이름 : " + cookiesName + ",");
				out.println("쿠키 값 : " + cookiesValue + "<br>");
				
				if(cookiesAll[i].getValue().equals("success")){
					out.println("로그인이 되었습니다");
				}
			}
			//삭제
			for(int i=0; i<cookiesAll.length;i++){
				
					if(cookiesAll[i].getName().equals("cookie_flag")){
					cookiesAll[i].setMaxAge(0);//쿠키 1개 삭제
					response.addCookie(cookiesAll[i]);//삭제하고 response로 삭제된 쿠기들 태워서 보내기
				} 
			}
			
		%>
		
		<a href = "cookieDel.jsp">쿠키삭제 확인</a>
		
	</body>
</html>