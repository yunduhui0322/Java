package com.site.ex0721;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.bo")
public class BoardController extends HttpServlet {
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
		RequestDispatcher dispatcher = null;
		String uri = request.getRequestURI();
		String cpath = request.getContextPath();
		String fname = uri.substring(cpath.length());
		
		if(fname.equals("/login.do")) {
			System.out.println( "호출페이지" +fname );
			System.out.println("login.jsp페이지로 호출함");
		}else if(fname.equals("/member.do")) {
			System.out.println("호출페이지" + fname);
			System.out.println("member.jsp페이지로 호출함");
		}else if(fname.equals("/logout.do")) {
			System.out.println("호출페이지" + fname);
			System.out.println("logout.jsp페이지로 호출함");
		}else if(fname.equals("/list.do")) {
			System.out.println("호출페이지" + fname);
			System.out.println("db접근해서 boardList 전체 데이터가져오기");
			System.out.println("board.jsp페이지로 데이터 전달해서 호출함");
			BService service = new BServiceList();
			service.execute(request, response);//request정보가 여기에 남아있음.
			dispatcher = request.getRequestDispatcher("./board/boardList.jsp");
			//request.setAttribute(ArrayList)
			//board.jsp로 request를 전달해줄것임.
		}else if(fname.equals("/member_modify.do")) {
			System.out.println("호출페이지" + fname);
			System.out.println("db접근해서 1명의 회원정보 데이터가져오기");
			System.out.println("member_modify.jsp페이지로 데이터 전달해서 호출함");
		}else if(fname.equals("/content_view.do")) {
			BService service = new BServiceOneBoard();
			service.execute(request, response);
			dispatcher = request.getRequestDispatcher("./board/boardView.jsp");
		}
			
		dispatcher.forward(request, response);
		/*
		 * response.setContentType("text/html;charset=utf-8"); PrintWriter writer =
		 * response.getWriter(); writer.println("<html><head></head><body>");
		 * writer.println("<h3>"+uri+"<h3>"); writer.println("<h3>"+cpath+" <h3>");
		 * writer.println("<h3>"+fname+" <h3>"); writer.println("</body></html>");
		 * writer.close();
		 */	}

}
