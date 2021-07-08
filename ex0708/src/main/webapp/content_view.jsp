<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>뷰페이지</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/read.css">
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script type="text/javascript">
  	function fix(){
  		alert("test");
  		return document.form1.submit();
  	}
  	function check(){
  		alert("test");
  		return document.form2.submit();
  	}
  	
  </script>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String bName = request.getParameter("bName");
	String bTitle = request.getParameter("bTitle");
	String bContent = request.getParameter("bContent");
	String bIp = request.getRemoteAddr();
	String bHit = "1";
	Date bDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
%>
<form action="./modify_view.jsp" method = "post" name = form1>
	<input type = "hidden" name = "bName" value = "<%=bName%>">
	<input type = "hidden" name = "bTitle" value = "<%=bTitle%>">
	<input type = "hidden" name = "bContent" value = "<%=bContent%>">
	<input type = "hidden" name = "bHit" value = "<%=bHit%>">
	<input type = "hidden" name = "bDate" value = "<%=sdf.format(bDate)%>">
</form>
<form action="./list.jsp" method = "post" name = form2>
	<input type = "hidden" name = "bName" value = "<%=bName%>">
	<input type = "hidden" name = "bTitle" value = "<%=bTitle%>">
	<input type = "hidden" name = "bContent" value = "<%=bContent%>">
	<input type = "hidden" name = "bHit" value = "<%=bHit%>">
	<input type = "hidden" name = "bDate" value = "<%=sdf.format(bDate)%>">
</form>
<section>
    <h1>NOTICE</h1>

    <table>
      <colgroup>
        <col width="80%">
        <col width="10%">
        <col width="10%">
        
      </colgroup>
      <tr>
        <th colspan="3">제목</th>
      </tr>
      <tr>
        <td colspan="1"><strong><%=bTitle %></strong></td>
        <td>날짜</td>
        <td><%=sdf.format(bDate) %></td>
      </tr>
      <tr>
        <td><%=bName %></td>
        <td>조회수</td>
        <td>1</td>
      </tr>
      <tr>
        <td colspan="3" class="article"><%=bContent %></td>
      </tr>
      <tr>
        <td colspan="3"><strong>다음글</strong> <span class="separator">|</span> [키즈잼] 2월 프로그램 안내</td>
      </tr>
      <tr>
        <td colspan="3"><strong>이전글</strong> <span class="separator">|</span> [키즈잼] 2020년 1분기 정기 휴관일 안내</td>
      </tr>
    </table>

    <a href="#"><div class="list" onclick = "check()">목록</div></a>
    <a href=""><div class="list">삭제</div></a>
    <a href="#"><div class="list" onclick = "fix()">수정</div></a>
    <a href=""><div class="list">답변달기</div></a>
  </section>
</body>
</html>