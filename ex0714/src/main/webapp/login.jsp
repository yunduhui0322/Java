<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function(){
				var msg1 = "<%=request.getParameter("msg")%>";
				if(msg1 != "null"){
					alert(msg1);
				}
			});
		</script>
	</head>
	<body>
	<form action="./LO" method = "post" name = "form">
	<h1>로그인 페이지</h1>
	<label>아이디</label>
	<input type = "text" name = "id" id = "id"><br>
	<label>비밀번호</label>
	<input type = "password" name = "pw" id = "pw"><br>
	<input type = "submit" value = "로그인">
	<a href = "./index.jsp"><input type = "button" value = "취소"></a>
	</form>
	</body>
</html>