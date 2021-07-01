<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			function login(){
				if($("#name").val() == "" || $("#name").val() == null){
					alert("이름을 입력하세요");
					$("#name").focus();
					return false;
				}
				return $("#loginForm").submit();
			}
			
		</script>
	</head>
	<body>
	<h1>회원가입</h1>
	<form action="./info.jsp" name = "loginForm" id = "loginForm" method = "post">
		<label>아이디</label>
		<input type = "text" name = "id" id = "id"><br>
		<label>비밀번호</label>
		<input type = "password" name = "pw1" id = "pw1"><br>
		<label>비밀번호 확인</label>
		<input type = "password" name = "pw2" id = "pw2"><br>
		<label>이름</label>
		<input type ="text" name = "name" id = "name"><br>
		<input type = "button" value = "회원가입" onclick="login()">
	
	</form>
	</body>
</html>