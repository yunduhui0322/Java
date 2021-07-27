<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		String path = request.getRealPath("upload");
		int size = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request,"c:/fileUploadTest",size,"utf-8",new DefaultFileRenamePolicy());
		
		Enumeration files = multi.getFileNames();
		String file1 = (String)files.nextElement();
		String filename1 = multi.getFilesystemName("file1");
		String file2 = (String)files.nextElement();
		String filename2 = multi.getFilesystemName("file2");
	%>
	<table>
		<tr>
			<th>작성자</th>
			<th>제목</th>
			<th>이미지</th>
		</tr>
		<tr>
			<td><%=multi.getParameter("bname") %></td>
			<td><%=multi.getParameter("btitle") %></td>
			<td><img src = "../upload/<%=filename1%>"/></td>
			<td><img src = "../upload/<%=filename2%>"/></td>
		</tr>
	</table>
	</body>
</html>