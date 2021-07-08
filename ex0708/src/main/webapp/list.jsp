<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시판</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/notice_list.css">
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
	String bName = request.getParameter("bName");
	String bTitle = request.getParameter("bTitle");
	String bContent = request.getParameter("bContent");
	String bIp = request.getRemoteAddr();
	String bHit = request.getParameter("bHit");
	String bDate = request.getParameter("bDate"); 
%>
<section>
    <h1>NOTICE</h1>
    <div class="wrapper">
      <form action="/search" name="search" method="post">
        <select name="category" id="category">
          <option value="0">전체</option>
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>

        <div class="title">
          <input type="text" size="16">
        </div>
  
        <button type="submit"><i class="fas fa-search"></i></button>
      </form>
    </div>

    <table>
      <colgroup>
        <col width="15%">
        <col width="40%">
        <col width="15%">
        <col width="15%">
        <col width="15%">
      </colgroup>
      <!-- 제목부분 -->
      <tr>
        <th>No.</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
      <!-- 내용부분 -->
      <%
      if(bName !=null){
      for(int i=1;i<=1;i++){ %>
      <tr>
        <td><span class="table-notice"><%=i %></span></td>
        <td class="table-title" style="text-align: center;">
        <a href="./content_view.jsp?bName=<%=bName%>&bTitle=<%=bTitle%>&bDate=<%=bDate%>&bHit=<%=bHit%>&bContent=<%=bContent%>"><%=bTitle %></a>
        </td>
        <td><%=bName %></td>
        <td><%=bDate %></td>
        <td><%=bHit %></td>
        
      </tr>
      <%} 
      }%>
      
    </table>

    <ul class="page-num">
      <li class="first"></li>
      <li class="prev"></li>
      <li class="num"><div>1</div></li>
      <li class="next"></li>
      <li class="last"></li>
    </ul>

    <a href="./write_view.jsp"><div class="write">쓰기</div></a>
  </section>

</body>
</html>