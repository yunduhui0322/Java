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
		<style type="text/css">
			table,tr,td,th{
				border: 1px solid black;
				border-collapse: collapse;
				text-align: center;
			}
		</style>
	</head>
	<body>
	<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String uId = "ora_user";
			String uPw = "1234";
			conn = DriverManager.getConnection(url,uId,uPw);
			stmt = conn.createStatement();
			String sql = "select employee_id,emp_name,department_id,department_name from employees inner join departments using(department_id) order by employee_id";
			rs = stmt.executeQuery(sql);
			%>
			<table>
				<tr>
					<th>사원번호</th><th>사원이름</th><th>부서번호</th><th>부서이름</th>
				</tr>
			
			<%
			while(rs.next()){
				int employee_id = rs.getInt("employee_id");
				String emp_name = rs.getString("emp_name");
				int department_id = rs.getInt("department_id");
				String department_name = rs.getString("department_name");
				%>
				<tr>
					<td><%=employee_id %></td><td><%=emp_name %></td><td><%=department_id %></td><td><%=department_name %></td>
				</tr>
			<%}%>
			</table>
			<%
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
	%>
	</body>
</html>