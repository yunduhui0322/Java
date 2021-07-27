<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			function loginCheck(){
				if($("#id").val().length<3){
					alert("아이디는 3자리 이상 입력하세요");
					$("#id").val("");
					$("#id").focus();
					return false;
				}
				if($("#pw").val().length<4){
					alert("비밀번호는 4자리이상 입력해주세요");
					$("#pw").val();
					$("#pw").focus();
					return false;
				}
				return $("#login_form").submit();
			}
		</script>
	</head>
	<body>
		<form action="./loginOk.jsp" name = "login_form" id = "login_form">
		<label>아이디</label>
		<input type = "text" name = "id" id = "id"><br>
		<label>패스워드</label>
		<input type = "password" name = "pw" id = "pw"><br>
		<input type = "button" value ="로그인" onclick = "loginCheck()">
		<a href = "./index.jsp"><input type = "button" value ="취소"></a>
		</form>
	</body>
</html>