<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<script type="text/javascript">
		if(${writeResult != null}){
			if(${writeResult == 1}){
				alert("글작성 성공!");
				location.href = "./bList.do";
			}else{
				alert("글작성 실패");
				loaction.href = "./bWrite.do";
			}
		}
		if(${modifyResult != null}){
			if(${modifyResult == 1}){
				alert("글수정 성공!");
				location.href = "./bList.do";
			}else{
				alert("글수정 실패");
				location.href = "./bList.do";
			}
		}
		if(${deleteResult != null}){
			if(${deleteResult == 1}){
				alert("글삭제 성공!");
				location.href = "./bList.do";
			}else{
				alert("글삭제 실패");
				location.href = "./bView.do?bid={bid}";
			}
		}
		if(${replyResult != null}){
			if(${replyResult == 1}){
				alert("답글달기 성공!");
				location.href = "./bList.do";
			}else{
				alert("답글달기 실패");
				location.href = "./bList.do";
			}
		}
	</script>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
		<h2>메인페이지</h2>
		<ul>
			<li><a href = "../login.do">로그인</a></li>
			<li><a href = "../member.do">회원가입</a></li>
			<li><a href = "../logout.do">로그아웃</a></li>
			<li><a href = "./board/bList.do">게시판</a></li>
			<li><a href = "./member_modify.do">회원정보수정</a></li>
		</ul>
	</body>
</html>