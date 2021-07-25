<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
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
 
 	function submitForm(){
 		$("#replyForm").submit();
 	}
  </script>
	</head>
	<body>
	<form action="./reply.do" name = "replyForm" id = "replyForm" method = "post">
	<label>댓글</label>
	<input type = "hidden" name = "bid" id = "bid" value = "4">
	<input type = "text" name = "reply" id = "reply"><br>
	<button type = "button" onclick = "submitForm()">작성</button>
	</form>
	<div id = "addT">
	<table>
		<c:forEach items="${list }" var="comment">
		<tr>
			<td>${comment.comment }</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	</body>
</html>