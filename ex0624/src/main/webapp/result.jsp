<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table,td,th{
				border:1px solid black; 
				border-collapse: collapse;
				text-align: center;
			}
		</style>
	</head>
	<body>
	<h3>학생성적 확인</h3>
		<%!
			String stuNo,stuName,kor,eng,math,avg = "";
			int total = 0;
		
		%>
		<%
			request.setCharacterEncoding("utf-8");
			stuNo = request.getParameter("stuNo");
			stuName = request.getParameter("stuName");
			kor = request.getParameter("kor");
			eng = request.getParameter("eng");
			math = request.getParameter("math");
			total = Integer.parseInt(kor) + Integer.parseInt(eng) + Integer.parseInt(math);
			avg = String.format("%.2f",(double)total/3);
		%>
		<table>
		<colgroup>
			<col width = "25%">
			<col width = "25%">
			<col width = "10%">
			<col width = "10%">
			<col width = "10%">
			<col width = "10%">
			<col width = "10%">
		</colgroup>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>합계</th>
				<th>평균</th>
			</tr>
			<tr>
				<td><%= stuNo %></td>
				<td><%= stuName %></td>
				<td><%= kor %></td>
				<td><%= eng %></td>
				<td><%= math %></td>
				<td><%= total %></td>
				<td><%= avg %></td>
			</tr>
		</table>
		<form action="./modify.jsp" name = "reusltForm" method = "post">
		<input type = "hidden" name = "no" value = "<%=stuNo %>">
		<input type = "hidden" name = "name" value = "<%=stuName %>">
		<input type = "hidden" name = "kor" value = "<%=kor %>">
		<input type = "hidden" name = "eng" value = "<%=eng %>">
		<input type = "hidden" name = "math" value = "<%=math %>">
		<input type = "submit" value = "수정">
		<input type = "reset" value = "취소">
		</form>
		
	</body>
</html>