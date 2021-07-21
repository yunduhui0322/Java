<%@page import="com.site.ex0719.BDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.site.ex0719.BDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판 리스트</title>
		<style type="text/css">
			table,tr,td,th{
				border: 1px solid black;
				border-collapse: collapse;
				text-align: center;
			}
		</style>
	</head>
	<%
		BDao bDao = new BDao();
		ArrayList<BDto> list = bDao.boardList();
	%>
	<body>
	<h3>게시판 리스트</h3> <span><a href = "../member/index.jsp">메인페이지 이동</a></span>
		<table>
			<tr>
				<th>번호</th>			
				<th>제목</th>			
				<th>파일명</th>			
				<th>작성자</th>			
				<th>작성일</th>			
				<th>조회수</th>			
			</tr>
			<%for(int i=0; i<list.size(); i++){%>
			<tr>
				<td><%=list.get(i).getbId() %></td>
				<td><%=list.get(i).getbTitle() %></td>
				<td><%=list.get(i).getbUpload() %></td>
				<td><%=list.get(i).getbName() %></td>
				<td><%=list.get(i).getbDate() %></td>
				<td><%=list.get(i).getbHit() %></td>
			</tr>
			<% }%>
		</table>
	</body>
</html>