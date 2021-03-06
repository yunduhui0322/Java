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
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script type="text/javascript">
  	function modifyCheck(){
  		if(confirm("수정하시겠습니까?")==true){
  			$("#modifyForm").submit();
  		}else{
  			location.href = "./bView.do?bid=${bVo.bid }"
  		}
  	}
  </script>
</head>
<body>
<section>
    <h1>게시글수정</h1>
    <hr>

    <form action="./bModifyOk.do" name="modifyForm" id = "modifyForm" method="post" enctype="multipart/form-data">
      <table>
      <input type="hidden" name="bid" value="${bVo.bid }">
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="bname" value="${bVo.bname }" readonly>
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="btitle" value="${bVo.btitle }">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="bcontent" cols="50" rows="10">${bVo.bcontent }</textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="file" id="file" >
            <input type="hidden" name="oldUpload" id="oldUpload" value = "${bVo.bupload }" >
            <span>${bVo.bupload }</span>
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="button" class="write" onclick = "modifyCheck()">수정완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='bList.do'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>