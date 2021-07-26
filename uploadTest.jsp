<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>동적 다중 파일업로드 하기</title>
	<style type="text/css">
		table,tr,td{
			border: 1px solid black;
			border-collapse: collapse;
		}
		#h3{
			color: red;
		}
	</style>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
			var count = 1;
		function addFile(){
			var addHtml = "";
			
			addHtml += '<tr id = "'+count+'">';
			addHtml += '<td><input type = "checkbox" name = "fileCheck" id = "'+count+'" value = "'+count+'"></td>'
			addHtml += '<td><input type = "file" name = "file'+ count +'" id = "file'+ count +'"></td>'
			addHtml += '</tr>';
			
			$("#t_body").append(addHtml);
			count++;
		}
		
		function removeFile(){
			if($("input:checkbox[name=fileCheck]").length <=0){
				alert("파일업로드할 행이 1개 이상 있어야 행삭제가 가능합니다.");
				return false;
			}
			if($("input:checkbox[name=fileCheck]:checked").length<=0){
				alert("파일업로드 행에 체크를하셔야 행삭제가 가능합니다.");
				return false;
			}
			$("input:checkbox[name=fileCheck]").each(function(){
				if(this.checked){
					alert("행을 삭제합니다");
					$("#"+this.value).remove();
				}
			})
		}
		
		function fileSubmit(){
			if($("input:checkbox[name=fileCheck]").length<=0){
				alert("파일 업로드할 행이 1개이상 있어야 파일 올리기가 가능합니다.");
				return false;
			}
			
			$("#fileCount").val($("input:checkbox[name=fileCheck]").length);
			$("#form").submit();
		}
	</script>
	</head>
	<body>
		<h3>동적 다중파일 업로드 하기</h3>
		
		<form action = "uploadTestOk.jsp" name = "form" id = "form" enctype="multipart/form-data" method = "post">
			<input type = "hidden" name = "fileCount" id = "fileCount">
			<table>
				<tr>
					<td><label>작성자</label></td>
					<td><input type = "text" name = "name" id = "name"></td>
				</tr>
				<tr>
					<td><label>제목</label></td>
					<td><input type = "text" name = "title" id = "title"></td>
				</tr>
			</table><br>
				<button type = "button" onclick = "addFile()">행추가</button>
				<button type = "button" onclick = "removeFile()">행삭제</button><br>
				
				<h4>check 업로드 파일이름</h4>
				<table>
					<tbody id = "t_body">
					</tbody>
				</table><br>
				<h3 id = "h3">업로드할 파일은 최대 10M까지 가능함</h3>
				<input type = "button" value = "파일 올리기" onclick = "fileSubmit()">
		</form>

	</body>
</html>