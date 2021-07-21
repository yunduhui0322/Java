package com.site.ex0721.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0721.service.BoardService;
import com.site.ex0721.service.BoardServiceDelete;
import com.site.ex0721.service.BoardServiceList;
import com.site.ex0721.service.BoardServiceModify;
import com.site.ex0721.service.BoardServiceReply;
import com.site.ex0721.service.BoardServiceView;
import com.site.ex0721.service.BoardServiceWrite;

/**
 * Servlet implementation class BController
 */
@WebServlet("*.do")
public class BController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = null;
		String uri = request.getRequestURI();
		String filePath = uri.substring(request.getContextPath().length());
		
		if(filePath.equals("/board/boardList.do")) {
			BoardService boardService = new BoardServiceList();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./boardList.jsp");
			
		}else if(filePath.equals("/board/boardView.do")) {
			BoardService boardService = new BoardServiceView();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./boardView.jsp");
		}else if(filePath.equals("/board/boardWrite.do")) {
			dispatcher = request.getRequestDispatcher("./boardWrite.jsp");
		}else if(filePath.equals("/board/boardWriteOk.do")) {
			BoardService boardService = new BoardServiceWrite();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./index.jsp");
		}else if(filePath.equals("/board/boardModify.do")) {
			BoardService boardService = new BoardServiceView();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./boardModify.jsp");
		}else if(filePath.equals("/board/boardModifyOk.do")) {
			BoardService boardService = new BoardServiceModify();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./index.jsp");
		}else if(filePath.equals("/board/boardDelete.do")) {
			BoardService boardService = new BoardServiceDelete();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./index.jsp");
		}else if(filePath.equals("/board/boardReply.do")) {
			BoardService boardService = new BoardServiceView();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./boardReply.jsp");
		}else if(filePath.equals("/board/boardReplyOk.do")) {
			BoardService boardService = new BoardServiceReply();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./index.jsp");
		}
		dispatcher.forward(request, response);
	}

}
