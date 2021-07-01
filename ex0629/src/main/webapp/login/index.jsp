<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
	<ul>
		<%
		Cookie[] cookieAll = request.getCookies();
		int count = 0;
		if (cookieAll != null) {//쿠키가 있는지 확인
			for (int i = 0; i < cookieAll.length; i++) {
				if (cookieAll[i].getName().equals("cookie_flag")) {//로그인시
					%>
					<img src = "../images/login.PNG">
					<li><a href = "./logout.jsp">로그아웃</a></li>
					<li>게시판</li>	
					
				<% count = 1;}
					
				if(cookieAll[i].getName().equals("cookie_nName")){
				out.println("<h3>닉네임"+ cookieAll[i].getValue()+"</h3>");
				}
				if(cookieAll[i].getName().equals("cookie_id")){
				out.println("<h3>아이디"+ cookieAll[i].getValue()+"</h3>");
				}
					//닉네임 검색후 닉네임 출력
				
			
		} //for
	 } 	//if
 
		%>
		<!-- 로그인 성공 -->
		<%if(count == 0){//로그인이 안된 상태%>
			<a href = "./login.jsp"><img src = "../images/logout.PNG"></a>
			<h3>[ 로그인 가능 ]</h3>
			
		<% }%>	
		<li>index</li>
		<li>이벤트</li>
		<li>공지사항</li>
	</ul>
	</body>
</html>