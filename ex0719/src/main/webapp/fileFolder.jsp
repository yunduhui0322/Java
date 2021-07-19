<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
	<form action="./fileFolderOk.jsp" method = "post" enctype="multipart/form-data">
		<label>번호</label>
		<input type = "text" name = "bId" id = "bId" value = "1" readonly><br>
		<label>제목</label>
		<input type = "text" name = "bTitle" id = "bTitle" ><br>
		<label>작성자</label>
		<input type = "text" name = "bName" id = "bName" ><br>
		<label>글내용</label><br>
		<textarea name="bContent" rows="40" cols="60"></textarea><br>
		<input type = "file" name = "file1" id = "file1"><br>
		<input type = "file" name = "file2" id = "file2"><br>
		<input type = "submit" value = "파일 업로드">
	</form>
	</body>
</html>