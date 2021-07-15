package com.site.ex0715;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


@WebServlet("/MDO")
public class ModifyOk extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		DataSource ds = null;
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nickName = request.getParameter("nickName");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String[] hobby = request.getParameterValues("hobby");
		String hobbys="";
		
		for(int i=0;i<hobby.length;i++) { //swim,golf,run
			if(i==0) hobbys=hobbys+hobby[i];
			else hobbys = hobbys+","+hobby[i];
		}
		
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
			String sql="update member2 set id=?,name=?,nickname=?,gender=?,tel=?,address1=?,address2=?,hobby=? where id = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, nickName);
			pstmt.setString(4, gender);
			pstmt.setString(5, tel);
			pstmt.setString(6, address1);
			pstmt.setString(7, address2);
			pstmt.setString(8, hobbys);
			pstmt.setString(9, (String)session.getAttribute("session_id"));
			
			// i : 성공하면 1, 실패하면 0
			int i = pstmt.executeUpdate();
			if(i==1) {
				System.out.println("데이터 저장 성공");
				session.setAttribute("session_nickName", nickName);
				session.setAttribute("session_id", id);
				
				response.sendRedirect("./index.jsp");
			}else {
				System.out.println("데이터 저장 실패");
				response.sendRedirect("./index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request,response);
	}

}