<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
		tr,th,td{
				border:1px solid black; 
				border-collapse: collapse;
				text-align: center;
		}
		
		</style>
	</head>
	<body>
	<h3>게시판 정보</h3>
	<%!
		String num = "",title = "", context = "", name = "", date = "", hit = ""; 
	%>
	<%request.setCharacterEncoding("utf-8");
		num = request.getParameter("num");
		title = request.getParameter("title");
		context = request.getParameter("context");
		name = request.getParameter("name");
		date = request.getParameter("date");
		hit = request.getParameter("hit");
	%>
	
	
		<table>
		<colgroup>
		<col width="10%">
		<col width="10%">
		<col width="10%">
		<col width="25%">
		<col width="35%">
		<col width="10%">
		</colgroup>
		
			<tr>
				<th>게시판 번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>

		</tr>
		<tr>
			<td><%=num %></td>
			<td><%=title %></td>
			<td><%=context %></td>
			<td><%=name %></td>
			<td><%=date %></td>
			<td><%=hit %></td>
		</tr>
		</table>
		<form action="./noticeModify.jsp" name = "form" id = "form">
			<input type = "hidden" name = "num" value = "<%=num %>">
			<input type = "hidden" name = "title" value = "<%=title %>">
			<input type = "hidden" name = "context" value = "<%=context %>">
			<input type = "hidden" name = "name" value = "<%=name %>">
			<input type = "hidden" name = "date" value = "<%=date %>">
			<input type = "hidden" name = "hit" value = "<%=hit %>">
			<input type = "submit" value = "수정">
		</form>
			<form action = "./noticeWrite.jps">
			<input type = "button" value = "취소" >
			</form>
	</body>
</html>