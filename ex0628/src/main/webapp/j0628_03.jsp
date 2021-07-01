<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			function checkForm(){
				if($("#name").val() == "" || $("#name").val() == null){
					alert("테스트");
					alert("이름을 입력해주세요");
					$("#name").focus();
					
					return false;
				}
			return $("#formCheck").submit();
			}
		</script>
	</head>
	<body>
	<form action="./test.jsp" method = "post" name = "formCheck" id = "formCheck">
	<!--시험번호:1 이름 홍길동 점수 70  -->
	<!--test.jsp->60점이상 합격,60미만 불합격 파라미터->시험번호,이름,점수 
		합격 test_succes.jsp,test_fali.jsp -->
	<label>시험번호</label>
	<input type = "text" name = "num" id = "num" value = "1" readonly><br>
	<label>이름</label>
	<input type = "text" name = "name" id = "name"><br>
	<label>점수</label>
	<input type = "text" name = "score" id = "score"><br>
	<input type = "button" value = "제출" onclick = "checkForm()">
	</form>	
	</body>
</html>