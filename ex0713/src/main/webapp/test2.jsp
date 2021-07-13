<%@page import="java.sql.DriverManager"%>
<%@page import="oracle.jdbc.OracleDriver"%>
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
				String order = "order by mid";
				String sql = "select * from member";
				rs = stmt.executeQuery(sql);//select
				
				
				while(rs.next()){
					String mId = rs.getString("mid");
					String mPw = rs.getString("mpw");
					String mName = rs.getString("mname");
					String mPhone = rs.getString("mphone");
					String mGender = rs.getString("mgender");
					String mAddress = rs.getString("maddress1") + rs.getString("maddress2");
					//out.println("id : " + mId + " mPw : " + mPw + "mAddress : " + mAddress + "<br>");
					%>
					<table>
						<tr>
							<td>이름 : <%=mName %></td>
						</tr>
						
					</table>
				<%}%>
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