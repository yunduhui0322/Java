<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>파일 확인</title>
	</head>
	<style type="text/css">
			table,td,tr,th{
			border: 1px solid black;
			border-collapse: collapse;
			}
		</style>
	<body>
	<h3>파일 업로드 정보</h3>
	<%	// tomcat의 upload의 위치를 말함
		String path = request.getRealPath("upload");
		int size = 10 * 1024 * 1024;
		                                                                      
		MultipartRequest multi = new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
		String bTitle = multi.getParameter("bTitle");
		String bName = multi.getParameter("bName");
		Enumeration files = multi.getFileNames();
		String file1 = (String)files.nextElement();
		String filename1 = multi.getFilesystemName(file1);
	%>
	<table>
		<tr>
			<th>글제목</th>
			<th>작성자</th>
			<th>파일명</th>
			<th>이미지</th>
		</tr>
		<tr>
			<td><%=bTitle %></td>
			<td><%=bName %></td>
			<td><%=filename1 %></td>
			<td><img src = "./upload/<%=filename1 %>"></img></td>
		</tr>
	</table>
	</body>
</html>