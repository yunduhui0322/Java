<%@page import="java.util.ArrayList"%>
<%@page import="com.site.ex0719_01.MDto"%>
<%@page import="com.site.ex0719_01.MDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<script type="text/javascript">
		if(!<%=session.getAttribute("session_id").equals("admin")%>){
			alert("관리자만 이용가능한 페이지 입니다.");
			location.href = "./index.jsp";
		}
		
	</script>
	<head>
		<meta charset="UTF-8">
		<title>멤버 리스트</title>
		<style type="text/css">
			table,tr,th,td{
				border: 1px solid black;
				border-collapse: collapse;
			}
		</style>
	</head>
	<body>
	<%
		MDao mDao = new MDao();
		ArrayList<MDto> list = mDao.memberList();
	%>
		<h1>멤버리스트</h1><span><a href = "./index.jsp">메인페이지이동</a></span>
		<table>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>닉네임</th>
				<th>성별</th>
				<th>전화번호</th>
				<th>주소1</th>
				<th>주소2</th>
				<th>취미</th>
			</tr>
			<%for(int i=0; i<list.size(); i++){ %>
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
			<%} %>
		</table>
	</body>
</html>