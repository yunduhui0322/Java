<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table,tr,th,td{
				border-collapse: collapse;
				border: 1px solid black;
			}
		</style>
	</head>
	<body>
		<jsp:useBean id="stu" class ="ex0630.Member" scope = "page"/>
		<%
			stu.setNo(1);
			stu.setName("홍길동");
			stu.setId("aaa");
			stu.setPw("1111");
			stu.setTel("010-1111-1111");
			stu.setGender("남자");
		%>
		<table>
			<tr>
				<th>번호</th><td><%=stu.getNo() %></td>
			</tr>
			<tr>
				<th>이름</th><td><%=stu.getName() %></td>
			</tr>
			<tr>
				<th>비밀번호</th><td><%=stu.getPw() %></td>
			</tr>
			<tr>
				<th>전화번호</th><td><%=stu.getTel() %></td>
			</tr>
			<tr>
				<th>성별</th><td><%=stu.getGender() %></td>
			</tr>
			
		</table>
		<br>
		<table>
			<tr>
				<th>번호</th><td><jsp:getProperty property="no" name="stu"/></td>
			</tr>
			<tr>
				<th>이름</th><td><jsp:getProperty property="name" name="stu"/></td>
			</tr>
			<tr>
				<th>비밀번호</th><td><jsp:getProperty property="pw" name="stu"/></td>
			</tr>
			<tr>
				<th>전화번호</th><td><jsp:getProperty property="tel" name="stu"/></td>
			</tr>
			<tr>
				<th>성별</th><td><jsp:getProperty property="gender" name="stu"/></td>
			</tr>
			
		</table>
	</body>
</html>