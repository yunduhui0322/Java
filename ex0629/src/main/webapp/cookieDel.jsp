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
		Cookie[] cookiesAll = request.getCookies();
		
		    for(int i=0; i<cookiesAll.length;i++){
				String cookiesName = cookiesAll[i].getName();
				String cookiesValue = cookiesAll[i].getValue();
			
				out.println("쿠키이름 : " + cookiesName + "," );
				out.println("쿠키 값: " + cookiesValue + "<br>");
			
				if(cookiesAll[i].getName().equals("cookie_flag")){
					out.println("로그인이 되었습니다.");
				}
				cookiesAll[i].setMaxAge(0);//쿠키 모두 삭제
				response.addCookie(cookiesAll[i]);//삭제하고 response로 삭제된 쿠기들 태워서 보내기
			//유저에 저장시키는 행위가 response.addCookie();
			
		}
		    
	%>
	<a href = "cookieResult.jsp">쿠키삭제 최종확인</a>
	</body>
</html>