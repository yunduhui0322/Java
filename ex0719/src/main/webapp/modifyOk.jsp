<%@page import="com.site.ex0719.UDao"%>
<%@page import="com.site.ex0719.UDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw2");
		String name = request.getParameter("name");
		String nickName = request.getParameter("nickName");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel1")+"-"+request.getParameter("tel2")+"-"+request.getParameter("tel3");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby = "";
		for(int i=0; i<hobbys.length; i++){
			if(i == 0){
				hobby += hobbys[i];
			}else{
				hobby += "," + hobbys[i];
			}
		}
		UDao uDao = new UDao();
		UDto uDto = new UDto(id,pw,name,nickName,gender,tel,address1,address2,hobby);
		int resultNum = uDao.m_User(uDto,(String)session.getAttribute("session_id"));
	
		
	%>  
	<head>
		<meta charset="UTF-8">
		<title>회원가입 완료</title>
		 <script type="text/javascript">
			if(<%=resultNum%> != 0){
				alert("수정이 완료되었습니다.!");
				<%
				session.setAttribute("session_id", uDto.getId());
				session.setAttribute("session_nickName", uDto.getNickName());
				session.setAttribute("session_uDto", uDto);
				%>
			}else{
				alert("회원정보수정 실패. 다시입력해 주세요");
				history.back(-1);
			}
				
		</script> 
	</head>
	
	<body>
		<div>
			<h2><a href = "./index.jsp">메인 페이지로 이동하기</a></h2>
		</div>
	</body>
</html>