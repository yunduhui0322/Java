<%@page import="com.site.ex0719.UDao"%>
<%@page import="com.site.ex0719.UDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<script type="text/javascript">
		alert("test");
		if(<%=!session.getAttribute("session_id").equals("admin")%>){
			alert("관리자만 접속이 가능합니다");
			location.href = "./index.jsp"
		}
		
	</script>
	<%
		UDao uDao = new UDao();
		ArrayList<UDto> list = uDao.memberList(); 
	%>
	<head>
		<meta charset="UTF-8">
		<title>회원정보 리스트</title>
		<style type="text/css">
			table,tr,td,th{
				border: 1px solid black;
				border-collapse: collapse;
			}
		</style>
	</head>
	<body>
	<h3>회원정보 리스트</h3> <span><a href = "./index.jsp">메인페이지 이동</a></span>
		<table>
			<tr>
				<th>아이디</th>			
				<th>패스워드</th>			
				<th>이름</th>			
				<th>닉네임</th>			
				<th>성별</th>			
				<th>전화번호</th>			
				<th>주소1</th>			
				<th>주소2</th>			
				<th>취미</th>			
			</tr>
			<%for(int i=0; i<list.size(); i++){%>
			<tr>
				<td><%=list.get(i).getId() %></td>
				<td><%=list.get(i).getPw() %></td>
				<td><%=list.get(i).getName() %></td>
				<td><%=list.get(i).getNickName() %></td>
				<td><%=list.get(i).getGender() %></td>
				<td><%=list.get(i).getTel() %></td>
				<td><%=list.get(i).getAddress1() %></td>
				<td><%=list.get(i).getAddress2() %></td>
				<td><%=list.get(i).getHobby() %></td>
			</tr>
			<% }%>
		</table>
	</body>
</html>