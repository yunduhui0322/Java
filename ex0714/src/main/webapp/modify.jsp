<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
	</head>
	<body>
	<%
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
		String gender = (String)session.getAttribute("gender");
		String job = (String)session.getAttribute("job");
		String hobby = (String)session.getAttribute("hobby");
		
		
	%>
		<form action = "./JO" method = "post" name = "form">
			<label>이름</label>
			<input type = "text" name = "name" id = "name" value = "<%=name%>"><br>
			<label>성별</label>
			<input type = "radio" name = "gender" id = "male" value = "male" <%=gender.contains("male")?"checked":"" %>>
			<label for = "male">남자</label>
			<input type = "radio" name = "gender" id = "female" value = "female"<%=gender.contains("female")?"checked":"" %>>
			<label for = "female">여자</label><br>
			<label>직업</label>
			<select name = "job">
				<option value = "student"<%=job.contains("student")?"selected":"" %>>학생</option>
				<option value = "free" <%=job.contains("free")?"selected":"" %>>무직</option>
				<option value = "professor" <%=job.contains("professor")?"selected":"" %>>교수</option>
			</select><br>
			<label>취미</label><br>
			<input type = "checkbox" name = "hobby" id = "swim" value = "swim" <%=hobby.contains("swim")?"checked":"" %>>
			<label for = "swim">수영</label>
			<input type = "checkbox" name = "hobby" id = "run" value = "run"<%=hobby.contains("run")?"checked":"" %>>
			<label for = "run">조깅</label>
			<input type = "checkbox" name = "hobby" id = "read" value = "read" <%=hobby.contains("read")?"checked":"" %>>
			<label for = "read">독서</label><br>
			<input type = "submit" value = "수정">
			<a href = "./index.jsp"><input type = "button" value = "취소"></a>
		</form>
	</body>
</html>