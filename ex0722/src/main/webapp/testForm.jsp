<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>testForm</title>
		<style type="text/css">
			table,th,td{
			border: 1px solid black;
			border-collapse : collapse;
			}
		</style>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script type="text/javascript">
  		var count = 1;
  	function addInput(){
  		
  		
  		alert(count);
  		var addHtml = "";
  		
		
		

  		addHtml += '<tr id = "'+count+'">';
  		addHtml += '<th><input type = "checkbox" name = "filecheck" id = "ch'+count+'" value = "'+count+'"></th>';
  		addHtml += '<th><input type = "file" id = "file'+count+'" name = "file'+count+'"></th>';
  		addHtml += '</tr>';
/*   		addHtml += '<tr id = "'+count+'">';
  		addHtml += '<th>'+$("#name").val()+'</th>';
  		addHtml += '<th>'+$("#title").val()+'</th>';
  		addHtml += '</tr>'; */
  		count++;
  		/* $("#name").val("");
  		$("#title").val("");
  		$("#name").focus();
		$("#title").focus() */;
  		$("#tbodyTr").append(addHtml);//기존 소스코드 하단부분
  		//$("#tbodyTr").prepend(addHtml);//기존 소스코드 상단부분
  		//$("#tbodyTr").html(addHtml);//기존 소스코드 지우고 새로운 html코드W
  	}
 	function subInput(){
 		if($("input:checkbox[name=filecheck]").length<=0){
 			alert("파일첨부가  1개이상 있어야 삭제가 가능합니다.");
 			return false;
 		}
 		$("input:checkbox[name=filecheck]").length;//이름이 filecheck인 인풋박스를 뒤져서 개수를 가져오라
 		//alert("checkbox 개수 :" + $("input:checkbox[name=filecheck]").length)
 		if($("input:checkbox[name=filecheck]:checked").length<=0){
 			alert("체크가 1개이상 되어야 삭제가 가능합니다");
 			return false;
 		}
 		$("input:checkbox[name=filecheck]:checked").length;//name이 filecheck의 체크박스에 체크된 개수
 		//alert("체크되어있는 개수: "+$("input:checkbox[name=filecheck]:checked").length);
 		
 		//체크박스 모두 검색 후 체크되어 있는 것 삭제
 		$("input:checkbox[name=filecheck]").each(function(){//배열만큼 돌려준다.
 			if(this.checked){
 				alert("체크되어있습니다.");
 				$("#"+this.value).remove();
 			}
 		})
 	} 	
 	
 	function submitForm(){
 		$("#fileCount").val($("input:checkbox[name=filecheck]").length)
 		$("#testForm").submit();
 	}
  </script>
	</head>
	<body>
		<h3>다중파일 업로드</h3>
		<form action="./testFormOk.jsp" id = "testForm" name = "testForm" enctype="multipart/form-data" method = "post">
			<input type = "hidden" id = "fileCount" name = "fileCount" >
			<label>작성자</label>
			<input type = "text" name = "name" id = "name"><br>
			<label>제목</label>
			<input type = "text" name = "title" id = "title"><br>
			<input type = "button" value = "파일업로드" onclick = "submitForm()"><br>
			<br><br>
			<button type = "button" onclick = "addInput()">파일업로드 행추가</button>
			<button type = "button" onclick = "subInput()">파일업로드 행삭제</button><br>
		<table>
			<tr>
				<th>체크</th>
				<th>파일명</th>
			</tr>
			<tbody id = "tbodyTr">
			</tbody>
		</table>
		<table>
			<tr>
			</tr>
		</table>
		</form>
	</body>
</html>