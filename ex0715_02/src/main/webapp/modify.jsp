<%@page import="com.site.ex.UDto"%>
<%@page import="com.site.ex.UDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%	
		UDao uDao = new UDao();
		String id = (String)session.getAttribute("session_id");
		UDto uDto = uDao.memberOneSelect(id);
	%>
	<head>
		<meta charset="UTF-8">
		<title>회원정보 수정</title>
		<style type="text/css">
			#tel1,#tel2,#tel3{
				width: 50px;
				height: 10px;
			}
		</style>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			if(<%=session.getAttribute("session_flag") == null%>){
				alert("로그인을 하셔야 접근이 가능합니다.");
				location.href = "./login.jsp";
			}
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
				if($("#pw1").val() == <%=uDto.getPw()%>){
					alert("비밀번호가 일치하지 않으면 수정할수 없습니다.");
					return false;
				}
				return $("#joinForm").submit();
			}
		</script>

	</head>
	<body>

	<h1>회원정보 수정</h1>
	<form action="./modifyOk.jsp" name = "joinForm" id = "joinForm" method = "post">
		<label>아이디</label>
		<input type = "text" name = "id" id = "id" value = "<%=uDto.getId()%>" readonly><br>
		<label>비밀번호</label>
		<input type = "password" name = "pw1" id = "pw1" value = "<%=uDto.getPw()%>"><br>
		<label>비밀번호 확인</label>
		<input type = "password" name = "pw2" id = "pw2"value = "<%=uDto.getPw()%>"><br>
		<label>이름</label>
		<input type = "text" name = "name" id = "name" value = "<%=uDto.getName()%>"><br>
		<label>닉네임</label>
		<input type = "text" name = "nickName" id = "nickName" value = "<%=uDto.getNickName()%>"><br>
		<label>성별</label>
		<input type = "radio" name = "gender" id = "male" value = "male" <%=(uDto.getGender().contains("male"))?"checked":"" %>>
		<label for = "male">남자</label>
		<input type = "radio" name = "gender" id = "female" value = "female"<%=(uDto.getGender().contains("female"))?"checked":"" %>>
		<label for = "female">여자</label><br>
		<label>전화번호</label>
		<input type = "text" name = "tel1" id = "tel1" value = "<%=uDto.getTel().split("-")[0]%>">-
		<input type = "text" name = "tel2" id = "tel2"value = "<%=uDto.getTel().split("-")[1]%>">-
		<input type = "text" name = "tel3" id = "tel3" value = "<%=uDto.getTel().split("-")[2]%>"><br>
		<label>주소</label>
		<input type = "text" name = "address1" id = "address1" value = "<%=uDto.getAddress1()%>">-
		<input type = "text" name = "address2" id = "address2" value = "<%=uDto.getAddress2()%>"><br>
		<label>취미</label><br>
		<input type = "checkbox" name = "hobby" id = "swim" value = "swim" <%=(uDto.getHobby().contains("swim"))?"checked":"" %>>
		<label for = "swim">수영</label>
		<input type = "checkbox" name = "hobby" id = "game" value = "game" <%=(uDto.getHobby().contains("game"))?"checked":"" %>>
		<label for = "game">게임</label>
		<input type = "checkbox" name = "hobby" id = "read" value = "read" <%=(uDto.getHobby().contains("read"))?"checked":"" %>>
		<label for = "read">독서</label>
		<input type = "checkbox" name = "hobby" id = "run" value = "run" <%=(uDto.getHobby().contains("run"))?"checked":"" %>>
		<label for = "run">조깅</label><br>
		<input type = "button" value = "수정하기" onclick = "formCheck()">
		<a href = "index.jsp"><input type = "button" value = "취소"></a>
	</form>
	</body>
</html>