<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table,th,td{
			border:1px solid black; 
			border-collapse: collapse;
			}
		</style>
	</head>
	<body>
		
		<%
			request.setCharacterEncoding("utf-8");
			
			String name = "", id = "", pw = "", gender = "", major = "", userHobbys = "";
			String[] hobbys = null;
			name = request.getParameter("name");
			pw = request.getParameter("pw2");
			gender = request.getParameter("gender");
			major = request.getParameter("major");
			hobbys = request.getParameterValues("hobbys");
			for(int i=0; i<hobbys.length;i++){
				if(i == 0){
					userHobbys = hobbys[i];
				}else{
					userHobbys += "," + hobbys[i];
				}
			} 
			Enumeration<String> enum1 = request.getParameterNames();
				int i=0;
				String names = "";
				while(enum1.hasMoreElements()){//읽어올 데이터가 있는지 확인.if문과 동일
				String name1 = enum1.nextElement();//1개의 데이터를 가져옴.
				if(i == 0){
					names += name1;//
					i++;
				}else{
					names += "," + name1;
				}
			}
		%>	
		<table>
			<tr>
				<th>이름</th>
				<td><%=name %></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><%=pw %></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><%=gender %></td>
			</tr>
			<tr>
				<th>취미</th>
				<td><%=userHobbys %></td>
			</tr>
			<tr>
				<th>전공</th>
				<td><%=major %></td>
			</tr>
			<tr>
				<th>모든 변수명</th>
				<td><%=names %></td>
			</tr>
		</table>
	</body>
</html>