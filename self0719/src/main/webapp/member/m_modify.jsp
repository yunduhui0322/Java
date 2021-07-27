<%@page import="com.site.self0719.MDto"%>
<%@page import="com.site.self0719.MDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<script type="text/javascript">
		if(<%=session.getAttribute("session_flag") == null%>){
			alert("로그인시 회원정보 수정이 가능합니다.");
			location href = "./login.jsp";
		}
	</script>
		<%
			String id = (String)session.getAttribute("session_id");
			MDao mDao = new MDao();
			MDto mDto = mDao.m_select(id);
		%>
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
				if($("#pw2").val() != <%=mDto.getPw()%>){
					alert("패스워드가 일치해야 수정이가능합니다.");
					return false;
				}
				return $("#joinForm").submit();
			}
		</script>

	</head>
	
	<body>
	<h1>회원가입</h1>
	<form action="./m_modifyOk.jsp" name = "joinForm" id = "joinForm" method = "post">
		<label>아이디</label>
		<input type = "text" name = "id" id = "id" value = "<%=mDto.getId()%>" readonly ><br>
		<label>비밀번호</label>
		<input type = "password" name = "pw2" id = "pw2" ><br>
		<label>이름</label>
		<input type = "text" name = "name" id = "name" value = "<%=mDto.getName()%>"><br>
		<label>닉네임</label>
		<input type = "text" name = "nickName" id = "nickName" value = "<%=mDto.getNickName()%>"><br>
		<label>성별</label>
		<input type = "radio" name = "gender" id = "male" value = "male" <%=mDto.getGender().contains("male")?"checked":"" %>>
		<label for = "male">남자</label>
		<input type = "radio" name = "gender" id = "female" value = "female" <%=mDto.getGender().contains("female")?"checked":"" %>>
		<label for = "female">여자</label><br>
		<label>전화번호</label>
		<input type = "text" name = "tel1" id = "tel1" value = "<%=mDto.getTel().split("-")[0]%>">-
		<input type = "text" name = "tel2" id = "tel2" value = "<%=mDto.getTel().split("-")[1]%>">-
		<input type = "text" name = "tel3" id = "tel3" value = "<%=mDto.getTel().split("-")[2]%>"><br>
		<label>주소</label>
		<input type = "text" name = "address1" id = "address1" value = "<%=mDto.getAddress1()%>">-
		<input type = "text" name = "address2" id = "address2" value = "<%=mDto.getAddress2()%>"><br>
		<label>취미</label><br>
		<input type = "checkbox" name = "hobby" id = "swim" value = "swim" <%=mDto.getHobby().contains("swim")?"checked":"" %>>
		<label for = "swim">수영</label>
		<input type = "checkbox" name = "hobby" id = "game" value = "game" <%=mDto.getHobby().contains("game")?"checked":"" %>>
		<label for = "game">게임</label>
		<input type = "checkbox" name = "hobby" id = "read" value = "read" <%=mDto.getHobby().contains("read")?"checked":"" %>>
		<label for = "read">독서</label>
		<input type = "checkbox" name = "hobby" id = "run" value = "run" <%=mDto.getHobby().contains("run")?"checked":"" %>>
		<label for = "run">조깅</label><br>
		<input type = "button" value = "수정하기" onclick = "formCheck()">
		<a href = "index.jsp"><input type = "button" value = "취소"></a>
	</form>
	</body>
</html>