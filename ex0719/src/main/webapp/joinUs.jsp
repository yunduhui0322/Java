<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<style type="text/css">
			#tel1,#tel2,#tel3{
				width: 50px;
				height: 10px;
			}
		</style>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			function formCheck(){
				if($("#id").val().length<3){
					alert("아이디는 3자리 이상 입력하세요");
					$("#id").val("");
					$("#id").focus();
					return false;
				}
				if($("#pw1").val().length<4){
					alert("비밀번호는 4자리이상 입력해주세요");
					$("#pw1").val();
					$("#pw1").focus();
					return false;
					
				}
				if($("#pw1").val() != $("#pw2").val()){
					alert("비밀번호가 다릅니다 다시입력해주세요.");
					$("#pw1").val("");
					$("#pw2").val("");
					$("#pw1").focus();
					return false;
				}
				return $("#joinForm").submit();
			}
		</script>

	</head>
	<body>
	<h1>회원가입</h1>
	<form action="./joinOk.jsp" name = "joinForm" id = "joinForm" method = "post">
		<label>아이디</label>
		<input type = "text" name = "id" id = "id"><br>
		<label>비밀번호</label>
		<input type = "password" name = "pw1" id = "pw1"><br>
		<label>비밀번호 확인</label>
		<input type = "password" name = "pw2" id = "pw2"><br>
		<label>이름</label>
		<input type = "text" name = "name" id = "name"><br>
		<label>닉네임</label>
		<input type = "text" name = "nickName" id = "nickName"><br>
		<label>성별</label>
		<input type = "radio" name = "gender" id = "male" value = "male">
		<label for = "male">남자</label>
		<input type = "radio" name = "gender" id = "female" value = "female">
		<label for = "female">여자</label><br>
		<label>전화번호</label>
		<input type = "text" name = "tel1" id = "tel1">-
		<input type = "text" name = "tel2" id = "tel2">-
		<input type = "text" name = "tel3" id = "tel3"><br>
		<label>주소</label>
		<input type = "text" name = "address1" id = "address1">-
		<input type = "text" name = "address2" id = "address2"><br>
		<label>취미</label><br>
		<input type = "checkbox" name = "hobby" id = "swim" value = "swim">
		<label for = "swim">수영</label>
		<input type = "checkbox" name = "hobby" id = "game" value = "game">
		<label for = "game">게임</label>
		<input type = "checkbox" name = "hobby" id = "read" value = "read">
		<label for = "read">독서</label>
		<input type = "checkbox" name = "hobby" id = "run" value = "run">
		<label for = "run">조깅</label><br>
		<input type = "button" value = "가입하기" onclick = "formCheck()">
		<a href = "index.jsp"><input type = "button" value = "취소"></a>
	</form>
	</body>
</html>