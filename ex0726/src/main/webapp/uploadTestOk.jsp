<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>업로드</title>
		<style type="text/css">
			table,tr,td{
				border: 1px solid black;
				border-collapse: collapse;
				text-align: center;
			}
		</style>
	</head>
	<body>
	<%	
		String path = "c:/upload";
		int size = 10 * 1024 * 1024;
		String name = "", title = "",fileName = "";
		String files[] = null;
		try{
		MultipartRequest multi = new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy()); 
		files = new String [Integer.parseInt(multi.getParameter("fileCount"))];
		name = multi.getParameter("name");
		title = multi.getParameter("title");
		Enumeration e = multi.getFileNames();
		int i = 0;
		while(e.hasMoreElements()){
			fileName = (String)e.nextElement();
			files[i] = multi.getFilesystemName(fileName);
				
		i++;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
	<table>
		<tr>
			<td>작성자</td><td><%=name %></td>
		</tr>
		<tr>
			<td>제목</td><td><%=title %></td>
		</tr>
		<%for (int j=0; j<files.length; j++){ %>
		<%if(files[j] != null){ %>
		<tr>
			<td>업로드된 파일명</td><td><%=files[j] %></td>
		</tr>
		<%} %>
	<%} %>
	</table>
	</body>
</html>