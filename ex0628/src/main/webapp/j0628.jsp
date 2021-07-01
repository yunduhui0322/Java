<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		 function join(){
			 alert("회원가입 테스트");
			 if ($("#pw1").val() == "" || $("#pw1").val() == null){
				 alert("비밀번호가 입력되지 않았습니다. 비밀번호를 입력하세요.")
				$("#pw1").val("");
				$("#pw1").focus();
				
				return false;
			 }
			 if ($("#pw1").val() != $("#pw2").val()){
				alert("비밀번호가 다릅니다. 다시 입력해주세요");
				$("#pw1").val("");
				$("#pw2").val("");
				$("#pw2").focus();
				
				return false;
			 }
			 /* return document.joinForm.submit(); */
			  return $("#joinForm").submit();  
			 /* return true; */
		 }
		 
		</script>
		 
		<style type="text/css">
		 .pointer{
		 	cursor: pointer;
		 }

		</style>
		
	</head>
	<body>
		<h3>회원가입</h3>
		<form action="formOk.jsp" method = "post" name = "joinForm" id = "joinForm">
		 <label>이름</label>
		 <input type = "text" name = "name" id = "name"><br>
		 <label>아이디</label>
		 <input type = "text" name = "id" id = "id"><br>
		 <label>비밀번호</label>
		 <input type = "password" name = "pw1" id = "pw1"><br>
		 <label>비밀번호 확인</label>
		 <input type = "password" name = "pw2" id = "pw2"><br>
		 <label>성별</label><br>
		 <input type = "radio" name = "gender" id = "male" value = "male"><label for = "male" class = "pointer" >남자</label>
		 <input type = "radio" name = "gender" id = "female" value = "female"><label for = "female" class = "pointer" >여자</label><br>
		 <label>취미</label><br>
		 <input type = "checkbox" name = "hobbys" id = "run" value = "run"><label for = "run" class = "pointer">조깅</label>
		 <input type = "checkbox" name = "hobbys" id = "game" value = "game"><label for = "game" class = "pointer">게임</label>
		 <input type = "checkbox" name = "hobbys" id = "read" value = "read"><label for = "read" class = "pointer">독서</label>
		 <input type = "checkbox" name = "hobbys" id = "golf" value = "golf"><label for = "golf" class = "pointer">골프</label><br>
		 <label>전공</label>
		 <select name = "major">
		  <option value = "computer">컴퓨터 공학</option>
		  <option value = "korea">국문학</option>
		  <option value = "math">수학</option>
		 </select><br>
		 <input type = "button" value = "가입하기" onclick="join()"><br>
		 
		
		</form>
	</body>
</html>