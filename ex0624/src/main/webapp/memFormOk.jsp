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
		request.setCharacterEncoding("utf-8");
		String memHobby = "";
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw2");
		String memGender = request.getParameter("memGender");
		if(memGender.equals("male")){
			memGender = "남자";
		}else if(memGender.equals("female")){
			memGender = "여자";
		}
		String memChannel = request.getParameter("memChannel");
		if(memChannel.equals("internet")){
			memChannel = "인터넷";
		}else if(memChannel.equals("advertisement")){
			memChannel = "광고";	
		}else if(memChannel.equals("news")){
			memChannel = "신문";	
		}
		if(request.getParameterValues("memHobbys") != null){
		String hobbys[] = request.getParameterValues("memHobbys");
		
		for(int j=0; j<hobbys.length;j++){
			if(j == 0){
				memHobby += hobbys[j];
			}else{
				memHobby += "," + hobbys[j];
			}
		}
	}
	%>
		<h2>회원정보</h2>
		<h3>아이디 :  <%=memId %></h3><br>
		<h3>패스워드 :  <%=memPw %></h3><br>
		<h3>성별 :  <%=memGender %></h3><br>
		
		<h3>취미 :  <%=memHobby %></h3><br>
		<h3>유입경로 :  <%=memChannel %></h3><br>
		<form action = "./memForm2.jsp" method = "post" name = "memForm">
			<input type = "hidden" name = "id" value = '<%=request.getParameter("memId") %>'>
			<input type = "hidden" name = "pw" value = '<%=request.getParameter("memPw2") %>'>
			<input type = "hidden" name = "gender" value = '<%=request.getParameter("memGender")%>'>
			<input type = "hidden" name = "mChannel" value = '<%=request.getParameter("memChannel") %>'>
			<input type = "hidden" name = "hobby" value = "<%=memHobby %>">
			<input type = "submit" value = "수정">
		</form>
	</body>
</html>