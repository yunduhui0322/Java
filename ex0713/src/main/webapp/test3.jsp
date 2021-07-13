<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<!-- employees emp_name,salary,rank
		8000이상 1등급, 7000이상 2등급, 6000이상 3등급, 4000이상 4등급, 그외 5등급 출력
		
	  -->
	  <%
	  	Connection conn = null;
	  	Statement stmt = null;
	  	ResultSet rs = null;
	  	try{
		  	Class.forName("oracle.jdbc.driver.OracleDriver");
		  	String url = "jdbc:oracle:thin:@localhost:1521:xe";
		  	String uid = "ora_user";
		  	String upw = "1234";
		  	conn = DriverManager.getConnection(url,uid,upw);
		  	stmt = conn.createStatement();
		  	String sql = "select emp_name,salary,case when salary>=8000 then '1등급' when salary>= 7000 then '2등급' when salary>= 6000 then '3등급' when salary>=4000 then'4등급' else '5등급' end as rank from employees";
		  	rs = stmt.executeQuery(sql);
		  	%>
		  	<table border="1">
	  			<tr>
	  				<th>이름</th><th>급여</th><th>등급</th>
	  			</tr>
		  	<%
		  	while(rs.next()){
	  			String emp_name = rs.getString("emp_name");
	  			int salary = rs.getInt("salary");
	  			String rank = rs.getString("rank");
	  		%>
	  		
	  			<tr>
	  				<td><%=emp_name %></td><td><%=salary %></td><td><%=rank %></td>
	  			</tr>
	  			
	  			
	  			
	  		<% }%>
	  		</table>
	  		<%
	  	}catch(Exception e){
	  		e.printStackTrace();	
	  	}finally{
	  		try{
	  			if (rs != null) rs.close();
	  			if (stmt != null) stmt.close();
	  			if (conn != null) conn.close();
	  		}catch(Exception e2){
	  			e2.printStackTrace();
	  		}
	  	}
	  %>
	</body>
</html>