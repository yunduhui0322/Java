<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>form</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			function formCheck(){
				alert("test");
				var kor = Number($("#kor").val());
				var eng = Number($("#eng").val());
				var math = Number($("#math").val());
				var result = kor + eng + math
				$("#total").val(result);
				$("#avg").val($("#total").val()/3);  
				return $("#form").submit();
			}
			
		</script>
	</head>
	<body>
		<form action="./j0630_03.jsp" method = "post" name = "form" id = "form">
			<label>학번</label>
			<input type = "text" name = "stuNo" id = "stuNo"><br>
			<label>이름</label>
			<input type = "text" name = "name" id = "name"><br>
			<label>국어점수</label>
			<input type = "text" name = "kor" id = "kor"><br>
			<label>영어점수</label>
			<input type = "text" name = "eng" id = "eng"><br>
			<label>수학점수</label>
			<input type = "text" name = "math" id = "math"><br>
			<input type = "hidden" id = "total" name = "total">
			<input type = "hidden" id = "avg" name = "avg">
			<input type = "button" onclick = "formCheck()" value = "전송">
		</form>
	</body>
</html>