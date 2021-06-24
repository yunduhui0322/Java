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
				alert("fomrCheck시작");
				if($("#stuName").val() == ""){
					alert("이름은 필수입니다.");
					$("#stuName").focus();
					return false;
				}
				return $("#formScore").submit();
			}
		</script>
	</head>
	<body>
	<h3>학생성적 입력</h3>
	<!--j0624_04.jsp 학번,이름,국어,영어,수학  -->
	<!--result.jsp 학번,이름,국어,영어,수학,합계,평균  -->
	<!--modify.jsp.jsp 학번,이름,국어,영어,수학,합계,평균  -->
	<form action="./result.jsp" name = "formScore" id = "formScore" method = "post">
		<label for = "stuNo">학번</label>
		<input type = "text" name = "stuNo" id = "stuNo"> <br>
		<label for = "stuName">이름</label>
		<input type = "text" name = "stuName" id = "stuName"> <br>
		<label for = "kor">국어</label>
		<input type = "text" name = "kor" id = "kor"> <br>
		<label for = "eng">영어</label>
		<input type = "text" name = "eng" id = "eng"> <br>
		<label for = "math">수학</label>
		<input type = "text" name = "math" id = "math"> <br>
		<input type = "button" onclick = "formCheck()" value = "제출">
		<input type = "reset" value = "취소">
	</form>
	</body>
</html>