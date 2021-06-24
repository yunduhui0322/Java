<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글수정</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/write.css">
</head>
<body>
<%	
	request.setCharacterEncoding("utf-8");
	String bTitle = request.getParameter("bTitle");
	String bName = request.getParameter("bName");
	String bContent = request.getParameter("bContent");
	String date = request.getParameter("date");
%>
<section>
    <h1>게시글수정</h1>
    <hr>

    <form action="modify.do" name="modify" method="post">
      <table>
      <input type="hidden" name="bId" value="">
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="bName" value="<%=bName %>" readonly>
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="bTitle" value="<%=bTitle%>">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="bContent" cols="50" rows="10">
           <%=bContent %>
            </textarea>
          </td>
        </tr>
        <tr>
          <th>날짜</th>
          <td>
            <input type="text" name="date" readonly value="<%=date%>">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write">수정완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='list.do'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>