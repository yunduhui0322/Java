<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
	</head>
	<body>
		<form action = "./JO" method = "post" name = "form">
			<label>아이디</label>
			<input type = "text" name = "id" id = "id" required><br>
			<label>비밀번호</label>
			<input type = "password" name = "pw1" id = "pw1" required><br>
			<label>비밀번호 확인</label>
			<input type = "password" name = "pw2" id = "pw2" required><br>
			<label>이름</label>
			<input type = "text" name = "name" id = "name" required><br>
			<label>성별</label>
			<input type = "radio" name = "gender" id = "male" value = "male">
			<label for = "male">남자</label>
			<input type = "radio" name = "gender" id = "female" value = "female">
			<label for = "female">여자</label><br>
			<label>직업</label>
			<select name = "job">
				<option value = "student">학생</option>
				<option value = "free">무직</option>
				<option value = "professor">교수</option>
			</select><br>
			<label>취미</label><br>
			<input type = "checkbox" name = "hobby" id = "swim" value = "swim">
			<label for = "swim">수영</label>
			<input type = "checkbox" name = "hobby" id = "run" value = "run">
			<label for = "run">조깅</label>
			<input type = "checkbox" name = "hobby" id = "read" value = "read">
			<label for = "read">독서</label><br>
			<input type = "submit" value = "가입하기">
			<a href = "./index.jsp"><input type = "button" value = "취소"></a>
		</form>
	</body>
</html>