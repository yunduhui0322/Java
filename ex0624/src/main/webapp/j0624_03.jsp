<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		function formCheck(){
			if($("#memId").val().length <5){
				alert("아이디를 5자리 이상입력하세요");
				$("#memId").val(""); 
				$("#memId").focus();
				return false;
			}else if($("#memPw1").val() != $("#memPw2").val()){
				alert("비밀번호가 다릅니다 다시입력해주세요.")
				$("#memPw2").val("");
				$("#memPw2").focus();
				return false;
			}
			return memForm.submit();
		}
	</script>
	<style type="text/css">
		.pointer{
			cursor: pointer;
		}
	</style>
	</head>
	
	<body>
	<!-- 아이디,패스워드,패스워드확인,성별-radio,취미-checkbox,유입경로-s  -->
	<!-- 아이디 5자리이상, 패스워드와 패스워드 확인 비교  -->
	<!-- memFormOk.jsp ->출력해보시오 -->
	<h2>회원가입</h2>
	<form action = "./memFormOk.jsp" name = "memForm" method = "post">
		<label for = "memId">아이디</label>
		<input type = "text" name = "memId" id = "memId"><br>
		<label for = "memPw1">패스워드</label>
		<input type = "password" name = "memPw1" id = "memPw1"><br>
		<label for = "memPw2">패스워드 확인</label>
		<input type = "password" name = "memPw2" id = "memPw2"><br>
		<label>성별</label><br>
		<input type = "radio" name = "memGender" id = "male" value = "male"><label for = "male" class = "pointer">남자</label>
		<input type = "radio" name = "memGender" id = "female" value = "female"><label for = "female"class = "pointer">여자</label><br>
		<label>취미</label><br>
		<input type = "checkbox" name = "memHobbys" id = "cook" value = "cook"><label for = "cook" class = "pointer">요리</label>
		<input type = "checkbox" name = "memHobbys" id = "read" value = "read"><label for = "read" class = "pointer">독서</label>
		<input type = "checkbox" name = "memHobbys" id = "swim" value = "swim"><label for = "swim" class = "pointer">수영</label>
		<input type = "checkbox" name = "memHobbys" id = "game" value = "game"><label for = "game" class = "pointer">게임</label><br>
		<label>유입경료</label><br>
		<select name = "memChannel">
			<option value = "internet">인터넷</option>
			<option value = "SNS">SNS</option>
			<option value = "advertisement">광고</option>
			<option value = "news">신문</option>
		</select><br>
		<input type = "button" onclick = "formCheck()" value = "가입">
		<input type = "reset" value = "취소"><br>
		
	</form>
	</body>
</html>