<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>bean</title>
	</head>
	<body>
		<jsp:useBean id="student" class="ex0630.Student" scope="page"/>
		<jsp:setProperty name="student" property="name" value = "홍길동" />
		<jsp:setProperty name="student" property="kor" value = "100" />
		<jsp:setProperty name="student" property="eng" value = "100" />
		<jsp:setProperty name="student" property="math" value = "90" />
		<%
			student.setStuNo(1);
			student.setTotal(student.getKor()+student.getEng()+student.getMath());
			student.setAvg((double)student.getTotal()/3);
		%>
		<table>
			<tr>
				<th>학번</th><td><%=student.getStuNo() %></td>
			</tr>
			<tr>
				<th>이름</th><td><%=student.getName() %></td>
			</tr>
			<tr>
				<th>국어점수</th><td><%=student.getKor() %></td>
			</tr>
			<tr>
				<th>영어점수</th><td><%=student.getEng() %></td>
			</tr>
			<tr>
				<th>수학점수</th><td><%=student.getMath() %></td>
			</tr>
			
			<tr>
				<th>합계</th><td><%=student.getTotal() %></td>
			</tr>
			<tr>
				<th>평균</th><td><%=student.getAvg() %></td>
			</tr>
			
		</table>
	</body>
</html>