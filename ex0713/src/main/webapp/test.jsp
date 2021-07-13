<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%	//db연결
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");//메모리에 jdbc탑재
			//driver properties 의 connection URL -->>접속 URL
			conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ora_user","1234");
			//커넥션 실행(접속url,id,pw);
			stmt = conn.createStatement();//sql구문을 입력하는 창 생성
			String sql = "select * from employees order by employee_id";
			rs = stmt.executeQuery(sql);//sql구문을 입력
			//107개의 데이터가 rs에 들어가있다.
			while(rs.next()){
				int employee_id = rs.getInt("employee_id");
				String emp_name = rs.getString("emp_name");
				String email = rs.getString("email");
				Timestamp date = rs.getTimestamp("hire_date");
				
				out.println("사원번호: " + employee_id + ", 이름: " + emp_name + ", 이메일: " + email + ", 입사일: " + date + "<br>");
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if( rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
			
		
		
	%>
	<head>
		<meta charset="UTF-8">
		<title>DB 연결</title>
	</head>
	<body>
	  
	</body>
</html>