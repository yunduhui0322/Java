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
	<%
		String gender =	request.getParameter("gender");
		String channel = request.getParameter("mChannel");
		String hobby = request.getParameter("hobby");
	%>
	<body>
	<!-- 아이디,패스워드,패스워드확인,성별-radio,취미-checkbox,유입경로-s  -->
	<!-- 아이디 5자리이상, 패스워드와 패스워드 확인 비교  -->
	<!-- memFormOk.jsp ->출력해보시오 -->
	<h2>회원가입</h2>
	<form action = "./memFormOk.jsp" name = "memForm" method = "post">
		<label for = "memId">아이디</label>
		<input type = "text" name = "memId" id = "memId" required value = '<%=request.getParameter("id")%>'><br>
		<label for = "memPw1">패스워드</label>
		<input type = "password" name = "memPw1" id = "memPw1" value = '<%=request.getParameter("pw")%>'><br>
		<label for = "memPw2">패스워드 확인</label>
		<input type = "password" name = "memPw2" id = "memPw2"><br>
		<label>성별</label><br>
		<input type = "radio" name = "memGender" id = "male" value = "male" <%=(gender.contains("male"))?"checked":"" %>><label for = "male" class = "pointer" >남자</label>
		<input type = "radio" name = "memGender" id = "female" value = "female" <%=(gender.contains("female"))?"checked":"" %>><label for = "female"class = "pointer" >여자</label><br>
		<label>취미</label><br>
		<input type = "checkbox" name = "memHobbys" id = "cook" value = "cook"<%=(hobby.contains("cook"))?"checked":"" %>><label for = "cook" class = "pointer">요리</label>
		<input type = "checkbox" name = "memHobbys" id = "read" value = "read"<%=(hobby.contains("read"))?"checked":"" %>><label for = "read" class = "pointer">독서</label>
		<input type = "checkbox" name = "memHobbys" id = "swim" value = "swim"<%=(hobby.contains("swim"))?"checked":"" %>><label for = "swim" class = "pointer">수영</label>
		<input type = "checkbox" name = "memHobbys" id = "game" value = "game"<%=(hobby.contains("game"))?"checked":"" %>><label for = "game" class = "pointer">게임</label><br>
		<label>유입경료</label><br>
		<select name = "memChannel">
			<option value = "internet"  <%=(channel.contains("internet"))?"selected":"" %>>인터넷</option>
			<option value = "SNS" <%=(channel.contains("SNS"))?"selected":"" %>>SNS</option>
			<option value = "advertisement" <%=(channel.contains("advertisement"))?"selected":"" %>>광고</option>
			<option value = "news" <%=(channel.contains("news"))?"selected":"" %>>신문</option>
		</select><br>
		<input type = "button" onclick = "formCheck()" value = "수정">
		<input type = "reset" value = "취소"><br>
		
	</form>
	</body>
</html>