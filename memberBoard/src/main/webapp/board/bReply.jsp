<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글수정</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/write.css">
</head>
<script type="text/javascript">
function check(){
	if(confirm("답변다시겠습니까??") == true){
		return document.reply.submit();
	}
	
}
</script>
<body>
<section>
    <h1>게시글수정</h1>
    <hr>

    <form action="bReplyOk.do" name="reply" method="post" enctype="multipart/form-data">
      <table>
      <input type="hidden" name="bid" value="${bVo.bid }">
      <input type="hidden" name="bgroup" value="${bVo.bgroup }">
      <input type="hidden" name="bstep" value="${bVo.bstep }">
      <input type="hidden" name="bindent" value="${bVo.bindent }">
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="bname">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="btitle" value="<답변> ${bVo.btitle}">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
<textarea name="bContent" cols="50" rows="10">
${bVo.bcontent }<br>
---------------------------<br>
[답글]<br>


</textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="file" id="file">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="button" onclick = "check()" class="write">답변완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='bView.do?category=${category}&searchWord=${searchWord}&bid=${bVo.bid }&page=${page}'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>