<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<% 	request.setCharacterEncoding("utf-8");
		String num = URLEncoder.encode(request.getParameter("num"),"utf-8"); 
		String name = URLEncoder.encode(request.getParameter("name"),"utf-8"); 
		int score = Integer.parseInt(request.getParameter("score"));
		
		//URLEncoder ==>>파라미터로 값을 넘길때 사용한다.
		/* if(score >=60){
			response.sendRedirect("test_success.jsp?num=" + num+"&name=" +name +"&score=" +score);
		}else if(score<60){
			response.sendRedirect("test_fail.jsp?num=" + num+"&name=" +name +"&score=" +score);
		} */ 
	%> 
	<h3>html코드</h3>
	<jsp:forward page="test_success.jsp">
		<jsp:param value='<%=request.getParameter("name") %>' name="name"/>
		<jsp:param value="<%=num %>" name="num"/>
		<jsp:param value="<%=score %>" name="score"/>
		<jsp:param value="성공" name="param_test"/>
	</jsp:forward>
	</body>
</html>