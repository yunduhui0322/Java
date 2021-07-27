<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="./fileUploadOk.jsp" method = "post" enctype="multipart/form-data">
			<label>작성자</label>
			<input type = "text" name = "bname" id = "bname"><br>
			<label>제목</label>
			<input type = "text" name = "btitle" id = "btitle"><br>
			<input type = "file" name = "file1" id = "file1"><br>
			<input type = "file" name = "file2" id = "file2"><br>
			<input type = "submit" value = "파일업로드">
			
		</form>
	</body>
</html>