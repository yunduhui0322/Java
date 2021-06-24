<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type ="text/css">
		.pointer{
			cursor: pointer;
		}
		</style>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			function formCheck() {
				alert("폼체크 시작!");
				if($("#memId").val() == "" ){//jquery
					alert("아이디를 입력하세요.")
					$("#memId").focus();
					return false;
				}else if(memberForm.memId.value.length <3 ){
					alert("아이디를 3자리이상 입력하세요.")
					memberForm.memId.focus();
					return false;
				}else if($("#memPw1").val() != $("#memPw2").val()){
					alert("패스워드가 다릅니다. 다시입력해주세요");
					$("#memPw2").val(""); 
					$("#memPw2").focus();
					return false;
				}
				return memberForm.submit();
				//return true;
			}
		</script> 
	</head>
	<body>
	<h3>회원가입</h3>
		<form action="./formOk.jsp" name = "memberForm" method = "post">
			<label for = "memId">아이디</label>
			<input type = "text" name = "memId" id = "memId" required placeholder = "아이디는 3자리 이상 넣으시오." ><br>
			<label for = "memPw1">패스워드</label>
			<input type = "password" name = "memPw1" id = "memPw1"><br>
			<label for = "memPw2">패스워드 확인</label>
			<input type = "password" name = "memPw2" id = "memPw2"><br>
			<label for = "memName">이름</label>
			<input type = "text" name = "memName" id = "memName" ><br>
			<label>성별</label><br>
			<input type = "radio" name = "memGender" id = "male" value = "male"><label for= "male" class = "pointer" >남자</label>
			<input type = "radio" name = "memGender" id = "female" value = "female"><label for = "female" class = "pointer">여자</label><br>
			<label>취미</label><br>
			<input type = "checkbox" name = "memHobbys" id = "cook" value = "cook"><label for = "cook" class = "pointer">요리</label>
			<input type = "checkbox" name = "memHobbys" id = "jogging" value = "jogging"><label for = "jogging" class = "pointer">조깅</label>
			<input type = "checkbox" name = "memHobbys" id = "game" value = "game"><label for = "game" class = "pointer">게임</label>
			<input type = "checkbox" name = "memHobbys" id = "read" value = "read"><label for = "read" class = "pointer">독서</label>
			<input type = "checkbox" name = "memHobbys" id = "swim" value = "swim"><label for = "swim" class = "pointer">수영</label><br>
			<label>유입경로</label><br>
			<select name = "channel">
				<option value = "internet"> 인터넷 </option>
				<option value = "news"> 신문 </option>
				<option value = "advertisement"> 광고 </option>
				<option value = "pamphlet"> 팜플렛 </option>
			</select><br>
			<input type = "button" onclick="formCheck()" value = "가입">
			<input type = "reset" value = "취소" ><br>
		</form>
	</body>
</html>