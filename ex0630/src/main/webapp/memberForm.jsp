<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<meta charset="UTF-8">
		<title>memberForm</title>
		<script type="text/javascript">
			function formCheck(){
				alert("test")
				if($("#c_name").val() == "" || $("#c_name").val() == null){
					alert("이름을 입력하세요");
					$("#c_name").focus();
					return false;
				}
				if($("#c_id").val().length<3){
					alert("아이디를 3자리이상 입력하세요");
					$("#c_id").val("");
					$("#c_id").focus();
					return false;
				}
				var salary = Number($("#c_salary").val());
				var dedu = 0.1
				$("#c_dedu").val(salary*dedu);
				return $("#form").submit();
			}
			
		</script>
		<style type="text/css">
			.pointer{
				cursor: pointer;
			}
		</style>
	</head>
	<body>
		<form action="./j0630_04.jsp" method = "post" name = "form" id = "form">
			<label>번호</label>
			<input type = "text" name = "c_num" id = "c_num"><br>
			<label>이름</label>
			<input type = "text" name = "c_name" id = "c_name"><br>
			<label>아이디</label>
			<input type = "text" name = "c_id" id = "c_id"><br>
			<label>전화번호</label>
			<input type = "text" name = "c_tel" id = "c_tel"><br>
			<label>성별</label><br>
			<input type = "radio" name = "c_gender" id = "male" value = "male"><label for = "male" class = "pointer">남자</label>
			<input type = "radio" name = "c_gender" id = "female" value = "female"><label for = "female" class = "pointer">여자</label><br>
			<label>월급</label>
			<input type = "text" name = "c_salary" id = "c_salary"><br>
			<input type = "hidden" name = "c_dedu" id = "c_dedu"><br>
			<input type = "button" onclick = "formCheck()" value = "제출">
		</form>
	</body>
</html>