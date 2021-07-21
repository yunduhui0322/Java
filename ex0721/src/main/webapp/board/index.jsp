<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
		<script type="text/javascript">
			if(${insertResult != null}){
				if(${insertResult == 1}){
					alert("입력 성공!");
					location.href = "./boardList.do";
				}else{
					alert("입력 실패!");
					location.href = "./boardWrite.do";
				}
		}
			if(${modifyResult != null}){
				if(${modifyResult == 1}){
					alert("수정 성공!");
					location.href = "./boardList.do";
				}else{
					alert("수정 실패!");
					location.href = "./boardModify.do";
				}
			}	
			if(${deleteResult != null}){
				if(${deleteResult == 1}){
					alert("삭제 성공!");
					location.href = "./boardList.do";
				}else{
					alert("삭제 실패!");
					location.href = "./boardList.do";
				}
			}
			if(${replyResult != null}){
				if(${replyResult == 1}){
					alert("답글 성공!");
					location.href = "./boardList.do";
				}else{
					alert("답글 실패!");
					location.href = "./boardList.do";
				}
			}
		</script>
	</head>
	<body>
		<h2>메인페이지</h2>
		<ul>
			<li><a href = "../login.do">로그인</a></li>
			<li><a href = "../member.do">회원가입</a></li>
			<li><a href = "../logout.do">로그아웃</a></li>
			<li><a href = "./boardList.do">게시판</a></li>
			<li><a href = "./member_modify.do">회원정보수정</a></li>
		</ul>
	</body>
</html>