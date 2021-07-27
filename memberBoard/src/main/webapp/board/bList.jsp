<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시판</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/notice_list.css">
</head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	if(${deleteNum != null}){
		if(${deleteNum == 1}){
			alert("삭제되었습니다");
		}
	}
	if(${modifyResult != null}){
		if(${modifyResult == 1}){
			alert("수정되었습니다");
		}
	}
	if(${ReplyResult != null}){
		if(${ReplyResult == 1}){
			alert("답변되었습니다");
		}
	}
</script>
<body>
<section>
    <h1>NOTICE</h1>
    <div class="wrapper">
      <form action="./bList.do" name="search" method="post">
        <select name="category" id="category">
          <option value="all" <c:if test="${category=='all'}">selected</c:if> >전체</option>
          <option value="title" <c:if test="${category=='title'}">selected</c:if> >제목</option>
          <option value="content" <c:if test="${category=='content'}">selected</c:if> >내용</option>
        </select>
		<c:if test="${searchWord != null}">
        <div class="title">
          <input type="text" size="16" name = "searchWord" id = "bsearch" value = "${searchWord}">
        </div>
		</c:if>
  
		<c:if test="${searchWord == null}">
        <div class="title">
          <input type="text" size="16" name = "searchWord" id = "bsearch" >
        </div>
		</c:if>
  
        <button type="submit"><i class="fas fa-search"></i></button>
      </form>
    </div>
    <table>
      <colgroup>
        <col width="15%">
        <col width="45%">
        <col width="15%">
        <col width="15%">
        <col width="10%">
      </colgroup>
      <!-- 제목부분 -->
      <tr>
        <th>No.</th>
        <th>제목</th>
        <th>작성일</th>
        <th>작성자</th>
        <th>조회수</th>
      </tr>
      <!-- 내용부분 -->
      <c:forEach items="${list}" var="bVo">
      <tr>
        <td><span class="table-notice">${bVo.bid }</span></td>
        <td class="table-title">
        <c:forEach begin="1" end="${bVo.bindent }">&nbsp;&nbsp;&nbsp;</c:forEach>
        <c:if test="${bVo.bindent != 0 }">└</c:if>
        <a href="./bView.do?category=${category}&searchWord=${searchWord}&bid=${bVo.bid }&page=${page}">${bVo.btitle }</a>
        
        </td>
        <td>${bVo.bdate }</td>
        <td>${bVo.bname }</td>
        <td>${bVo.bhit }</td>
      </tr>
      </c:forEach>
      
    </table>

    <ul class="page-num">
      <c:if test="${(page != 1) && (startPage-1 != 0)}">
      <a href = "./bList.do?category=${category}&searchWord=${searchWord}&page=${startPage-1 }"><li class="first"></li></a>
      </c:if>
      <c:if test="${page != 1 }">
      <a href = "./bList.do?category=${category}&searchWord=${searchWord}&page=${page-1 }"><li class="prev"></li></a>
      </c:if>
      
      <c:forEach  var="pageNum" begin="${startPage }" end="${endPage }">
      <c:if test="${pageNum != page }">
      <li class="num"><div><a href = "./bList.do?category=${category}&searchWord=${searchWord}&page=${pageNum}">${pageNum}</a></div></li>
      </c:if>
      <c:if test="${pageNum == page }">
      <li class="num"><div>${pageNum }</div></li>
      </c:if>
      </c:forEach>
      
      <c:if test="${page != maxPage}">
      <a href = "./bList.do?category=${category}&searchWord=${searchWord}&page=${page+1 }"><li class="next"></li></a>
      </c:if>
      <c:if test="${(page != maxPage) && (endPage+1 < maxPage) }">
      <a href = "./bList.do?category=${category}&searchWord=${searchWord}&page=${endPage+1 }"><li class="last"></li></a>
      </c:if>
    </ul>

    <a href="./bWrite.do"><div class="write">쓰기</div></a>
  </section>

</body>
</html>