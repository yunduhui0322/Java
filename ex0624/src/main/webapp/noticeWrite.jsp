<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
		section {
				  margin: auto;
				  width: 90%;
				}
		
			hr {
			  border: 3px solid black;
			  margin-bottom: 30px;
			}
			input[type=text]{
				height: 60px;
				width: 100px;
			}
			h1 {
			  font-size: 32px;
			  margin: 50px 0 40px 0;
			  text-align: center;
			}table {
			  width: 100%;
			}
			
			tr {
			  height: 50px;
			}
			
			th {
			  font-weight: normal;
			  font-size: 20px;
			}
	</style>
	</head>
	<body>
	<h1>글쓰기</h1>
	<br>
	<br>
	<hr>
	<!--noticeWrite.jsp 게시판번호,제목,내용,작성자  -->
	<!--noticeView.jsp 게시판번호,제목,내용,작성자,작성일,조회수  -->
	<!--noticeModify.jsp.jsp 게시판번호,제목,내용,작성자,작성일,조회수  -->
	<%
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-HH-dd hh:mm:ss");
		sdf.format(today);
		int count = 0;
		int hit = 0;
	%>
	<form action="./noticeView.jsp" method = "post">
		<input type = "hidden" name = "num" id = "num" readonly value = <%=++count %>>
		<input type = "hidden" name = "date" id = "date"  value = "<%=sdf.format(today)%>"><br>
		<input type = "hidden" name = "hit" id = "hit" value = "<%=++hit%>"><br>
	<table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
           <td>
		<input type = "text" name = "name" id = "name"><br>
		   </td>
		   </tr>
		<tr>
          <th>제목</th>
          <td>
		<input type = "text" name = "title" id = "title"><br>
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="context" id = "context" cols="50" rows="10"></textarea>
          </td>
        </tr>
		</table>
		<input type = "submit" value = "제출">
		<input type = "reset" value = "취소">
	</form>
	</body>
</html>