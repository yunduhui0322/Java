<%@page import="com.site.ex0720.MemberVo"%>
<%@page import="com.site.ex0720.MemberDao"%>
<%@page import="com.site.ex0720.BoardVo"%>
<%@page import="com.site.ex0720.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html>
<%
	MemberDao memberDao = new MemberDao();
	MemberVo memberVo = memberDao.selectOneUser("aaa");
%>
<c:set var="memberVo" value="<%=memberVo %>" />
<html>
	<head>
		<meta charset="UTF-8">
		<title>fn</title>
	</head>
	<body>
	<h1>회원정보 수정</h1>
	<form action="./modifyOk.jsp" name = "joinForm" id = "joinForm" method = "post">
		<label>아이디</label>
		<input type = "text" name = "id" id = "id" value = "${memberVo.id }"><br>
		<label>비밀번호</label>
		<input type = "password" name = "pw1" id = "pw1" value = "${memberVo.pw }"><br>
		<label>비밀번호 확인</label>
		<input type = "password" name = "pw2" id = "pw2"value = "${memberVo.pw }"><br>
		<label>이름</label>
		<input type = "text" name = "name" id = "name" value = "${memberVo.name }"><br>
		<label>닉네임</label>
		<input type = "text" name = "nickName" id = "nickName" value = "${memberVo.nickName }"><br>
		<label>성별</label>
		<input type = "radio" name = "gender" id = "male" value = "male" ${memberVo.gender =="male"?"checked":""}>
		<label for = "male">남자</label>
		<input type = "radio" name = "gender" id = "female" value = "female"${memberVo.gender =="female"?"checked":""}>
		<label for = "female">여자</label><br>
		<label>전화번호</label>
		<label>주소</label>
		<input type = "text" name = "address1" id = "address1" value = "${memberVo.address1 }">-
		<input type = "text" name = "address2" id = "address2" value = "${memberVo.address2 }"><br>
		<label>취미</label><br>
		<input type = "checkbox" name = "hobby" id = "swim" value = "swim" ${fn:contains(memberVo.hobby,"swim")?"checked":"" }>
		<label for = "swim">수영</label>
		<input type = "checkbox" name = "hobby" id = "game" value = "game" ${fn:contains(memberVo.hobby,"game")?"checked":"" }>
		<label for = "game">게임</label>
		<input type = "checkbox" name = "hobby" id = "read" value = "read" ${fn:contains(memberVo.hobby,"read")?"checked":"" }>
		<label for = "read">독서</label>
		<input type = "checkbox" name = "hobby" id = "run" value = "run" ${fn:contains(memberVo.hobby,"run")?"checked":"" }>
		<label for = "run">조깅</label><br>
		<input type = "button" value = "수정하기" onclick = "formCheck()">
		<a href = "index.jsp"><input type = "button" value = "취소"></a>
	</form>
	</body>
</html>