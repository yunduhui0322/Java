<%@page import="com.site.ex0715_01.MDto"%>
<%@page import="com.site.ex0715_01.MDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String nickName = request.getParameter("nickName");
	String gender = request.getParameter("gender");
	String address1 = request.getParameter("address1");
	String address2 = request.getParameter("address2");
	String tel = request.getParameter("tel");
	String[] hobbys = request.getParameterValues("hobby");
	String hobby = "";
	for(int i=0; i<hobbys.length;i++){
		if(i==0){
			hobby += hobbys[i];
		}else{
			hobby += "," + hobbys[i];
		}
	}
	MDao mDao = new MDao();
	MDto mDto = new MDto(id,pw,name,nickName,gender,tel,address1,address2,hobby);
	int resultNum =mDao.memberInsert(mDto);
	
	
%>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			if(<%=resultNum%> == 1){
				alert("회원가입 되셨습니다!");
				location.href = "./login.jsp";
			}else{
				alert("회원가입에 실패하셨습니다.")
				location.href = "./member.jsp";
			}
		</script>
	</head>
	<body>
	
	</body>
</html>