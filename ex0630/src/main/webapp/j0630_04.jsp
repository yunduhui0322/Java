<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>결과값</title>
		<style type="text/css">
			table,tr,th,td{
				border: 1px solid black;
				border-collapse: collapse;
				text-align: center;
			}
		</style>
	</head>
	<body>
	
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<!-- 1. memberForm.jsp 번호,이름,아이디,전화번호,성별,월급,공제액 10% -->
	<!-- 2. salary.java  번호,이름,아이디,전화번호,성별,월급,공재액(10%)-->
	<!-- 2. 0630_04.jsp - 폼에서 넘겨온 데이터를 useBean에 값을 삽입 -->
	<!-- 3. useBean 데이터를 테이블에 출력을하시오 -->
	<jsp:useBean id="sal" class ="ex0630.Salary" scope = "page"/>
	<jsp:setProperty property="*" name="sal"/>
	
	<table>
	<colgroup>
	<col width="5%">
	<col width="5%">
	<col width="15%">
	<col width="20%">
	<col width="20%">
	<col width="20%">
	<col width="20%">
	</colgroup>
		<tr>
			<th>번호</th><th>이름</th><th>아이디</th><th>전화번호</th><th>성별</th><th>월급</th><th>공재액</th>
		</tr>
		<tr>
			<td><%=sal.getC_num() %></td><td><%=sal.getC_name() %></td><td><%=sal.getC_id() %></td>
			<td><%=sal.getC_tel() %></td><td><%=sal.getC_gender() %></td>
			<td><%=String.format("%,d",sal.getC_salary()) %>원</td><td><%=String.format("%,d",sal.getC_dedu()) %>원</td>
		</tr>
	</table>
	</body>
</html>