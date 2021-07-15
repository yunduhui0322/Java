package com.site.ex0715;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;



@WebServlet(asyncSupported = true, urlPatterns = { "/LO" })
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		HttpSession session = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DataSource ds = null;
		
		try{
			Context context = new InitialContext();
				ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
				conn = ds.getConnection();
			
			
			 String sql = "select * from member2 where id = ? and pw = ?";
			 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("아이디와 패스워드가 일치합니다.");
				session = request.getSession();
				session.setAttribute("session_id", id);
				session.setAttribute("session_nickName", rs.getString("nickname"));
				session.setAttribute("session_flag", "success");
				response.sendRedirect("./index.jsp");
			}else {
				response.sendRedirect("./login.jsp?msgNum=0");
				System.out.println("아이디와 패스워드가 일치하지 않습니다.");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
