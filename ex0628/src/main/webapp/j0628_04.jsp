<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
			<%!
				String id = "aaa";
				String pw = "1234";
				String name = "홍길동";
				/* name = URLEncoder.encode(name,"utf-8"); */
				/* response.sendRedirect("result.jsp?id="+ id + "&pw=" + pw + "&name= " + name); */
			%>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			function sendLink(){
				alert("전송합니다");
				location.href="result.jsp?id=<%=id%>&pw=<%=pw%>&name=<%=name%>";
			}
		</script>
	</head>
		<body>
		<!--result.jsp 파라미터 방식으로 데이터 전달  -->
			<%-- <a href = "result.jsp?id=<%=id%>&pw=<%=pw%>&name=<%=name%>">전송</a> --%>			
			<button type = "button" onclick = "sendLink()">파라미터전송</button>
		</body>
</html>	