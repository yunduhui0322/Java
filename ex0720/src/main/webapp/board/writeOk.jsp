<%@page import="com.site.ex0720.BoardDao"%>
<%@page import="com.site.ex0720.BoardVo"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%	
		BoardDao boardDao = new BoardDao();
		BoardVo boardVo = null;
		String path = request.getRealPath("upload");
		int size = 10 * 1024 * 1024;
		int result = 0;
		try{
		MultipartRequest multi = new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
		String bname = multi.getParameter("bname");
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String fileName = multi.getFilesystemName("file");
		boardVo = new BoardVo(btitle,bcontent,bname,fileName);
		result = boardDao.boardInsert(boardVo);
		/* Enumeration files = multi.getFileNames()
		String file1 = (String)files.nextElement();
		String filename1 = multi.getFilesystemName(file1) */;			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	%>
	<c:set var = "result" value = "<%=result %>"/>
	<script type="text/javascript">
		if(${result == 1}){
			alert("저장 완료");
			location.href = "./list.jsp";
		}else{
			alert("저장실패");
			location.href = "./write_view.jsp";
		}
		
	</script>
	</body>
</html>