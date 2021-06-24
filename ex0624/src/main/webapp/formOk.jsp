<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<style type="text/css">
	table,td,th{
				border:1px solid black; 
				border-collapse: collapse;
				text-align: center;
			}
	</style>
	<body>
	<%	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw1");
		String memGender = request.getParameter("memGender");
		if(memGender.equals("male")){
			memGender = "남자";
		}else if (memGender.equals("female")){
			memGender = "여자";
		}
		String memChannel = request.getParameter("channel");
		if(memChannel.equals("internet")){
			memChannel = "인터넷";
		}else if(memChannel.equals("news")){
			memChannel = "신문";
		}else if(memChannel.equals("advertisement")){
			memChannel = "광고";
		}else if(memChannel.equals("pamphlet")){
			memChannel = "팜플렛";
		}
		String memHobby = "";
		String[] memHobbys;
		memHobbys = request.getParameterValues("memHobbys");
		for(int i=0; i<memHobbys.length;i++){
			if(i == 0){
				memHobby += memHobbys[i];
			}else{
				memHobby += "," + memHobbys[i];
			}
		}
	%>
		<table>
		<colgroup>
        <col width="10">
        <col width="20">
        <col width="10%">
        <col width="50">
        <col width="10%">
      </colgroup>
			<tr>
				<th> 아이디</th>
				<th> 패스워드</th>
				<th> 성별</th>
				<th> 취미</th>
				<th> 유입경료</th>
			</tr>
			<tr>
				<td><%=memId  %></td>
				<td><%=memPw  %></td>
				<td><%=memGender  %></td>
				<td><%=memHobby  %></td>
				<td><%=memChannel  %></td>
			</tr>
		</table>
		
		
	</body>
</html>