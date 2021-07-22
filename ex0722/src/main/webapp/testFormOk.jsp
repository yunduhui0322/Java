<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.multipart.FileRenamePolicy"%>
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
		String savePath = "c:/upload";
		int size = 10 * 1024 * 1024;
		String name = "", title="";
		String[] uploads = null;
		
		MultipartRequest multi = new MultipartRequest(request,savePath,size,"utf-8",new DefaultFileRenamePolicy());
		name = multi.getParameter("name");
		title = multi.getParameter("title");
		int fileCount =Integer.parseInt(multi.getParameter("fileCount"));
		
		uploads = new String[fileCount];
		
		Enumeration e = multi.getFileNames();
		int i = 0;
		
		while(e.hasMoreElements()){//읽어올 데이터가 있는지 확인
			String fname = (String)e.nextElement();//1개 데이터를 읽어옴
			out.println(fname);
			uploads[i] = multi.getFilesystemName(fname);
			i++;
		}
			
		
	%>
	
	<table>
		<tr>
			<th>작성자</th>
			<th>제목</th>
			<th>파일첨부</th>
		</tr>
		<tr>
			<td><%=name %></td>
			<td><%=title %></td>
			<%for (int j=0; j<uploads.length;j++){ %>
			<td><%=uploads[j] %></td>
			<%} %>
		</tr>
	</table>
	</body>
</html>