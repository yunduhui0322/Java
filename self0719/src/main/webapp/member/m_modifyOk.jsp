<%@page import="com.site.self0719.MDto"%>
<%@page import="com.site.self0719.MDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입 완료페이지</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw2");
			String name = request.getParameter("name");
			String nickName = request.getParameter("nickName");
			String gender = request.getParameter("gender");
			String tel = request.getParameter("tel1") +"-" + request.getParameter("tel2") + "-" + request.getParameter("tel3");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String[] hobbys = request.getParameterValues("hobby");
			String hobby = "";
			
			for(int i=0; i<hobbys.length; i++){
				if ( i == 0 ){
					hobby += hobbys[i];
				}else{
					hobby += "," + hobbys[i];
				}
			}
			
			MDao mDao = new MDao();
			MDto mDto = new MDto(id,pw,name,nickName,gender,tel,address1,address2,hobby);
			int resultNum = mDao.m_modify(mDto);
		
		%>
		<script type="text/javascript">
			if(<%=resultNum == 1%>){
				alert("수정 완료!");
				location.href = "./index.jsp";
				<%session.setAttribute("session_id", mDto.getId());
				session.setAttribute("session_nickName", mDto.getNickName());
				session.setAttribute("session_flag","success");
				%>
			}else{
				alert("수정실패");
				location.href = "./index.jsp";
			}
		</script>
	</body>
</html>