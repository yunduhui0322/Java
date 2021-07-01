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
	%>
		<jsp:useBean id="stu" class ="ex0630.Student" scope = "page"/>
		<jsp:setProperty property="*"  name="stu"/>
		
		<table>
			<tr>
				<th>학번</th><td><%=stu.getStuNo() %></td>
			</tr>
			<tr>
				<th>이름</th><td><%=stu.getName() %></td>
			</tr>
			<tr>
				<th>국어</th><td><%=stu.getKor() %></td>
			</tr>
			<tr>
				<th>영어</th><td><%=stu.getEng() %></td>
			</tr>
			<tr>
				<th>수학</th><td><%=stu.getMath() %></td>
			</tr>
			<tr>
				<th>합계</th><td><%=stu.getTotal() %></td>
			</tr>
			<tr>
				<th>평균</th><td><%=String.format("%.2f",stu.getAvg()) %></td>
				
			</tr>
		</table>
		
		
	</body>
</html>