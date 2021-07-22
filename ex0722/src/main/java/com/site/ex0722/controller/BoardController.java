package com.site.ex0722.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0722.service.BoardService;
import com.site.ex0722.service.BoardServiceDelete;
import com.site.ex0722.service.BoardServiceList;
import com.site.ex0722.service.BoardServiceModify;
import com.site.ex0722.service.BoardServiceReply;
import com.site.ex0722.service.BoardServiceView;
import com.site.ex0722.service.BoardServiceWrite;

@WebServlet("*.do")
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
		request.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = null;
		BoardService boardService = null;
		String filepath = request.getRequestURI().substring(request.getContextPath().length());
		switch (filepath) { 
		case "/board/bList.do":
			boardService = new BoardServiceList();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./boardList.jsp");
			break;
		case "/board/bView.do":
			boardService = new BoardServiceView();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./boardView.jsp");
			break;
		case "/board/bWrite.do":
			dispatcher = request.getRequestDispatcher("./boardWrite.jsp");
			break;
		case "/board/bWriteOk.do":
			boardService = new BoardServiceWrite();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("/");
			break;
		case "/board/bModify.do":
			boardService = new BoardServiceView();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./boardModify.jsp");
			break;
		case "/board/bModifyOk.do":
			boardService = new BoardServiceModify();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("/");
			break;
		case "/board/bDelete.do":
			boardService = new BoardServiceDelete();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("/");
			break;
		case "/board/bReply.do":
			boardService = new BoardServiceView();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./boardReply.jsp");
			break;
		case "/board/bReplyOk.do":
			boardService = new BoardServiceReply();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("/");
			break;

		default:
			dispatcher = request.getRequestDispatcher("/");
		}
		dispatcher.forward(request, response);
	}
}
