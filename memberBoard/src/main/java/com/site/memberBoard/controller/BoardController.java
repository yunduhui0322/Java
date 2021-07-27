package com.site.memberBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.memberBoard.Service.BoardService;
import com.site.memberBoard.Service.BoardServiceDelete;
import com.site.memberBoard.Service.BoardServiceList;
import com.site.memberBoard.Service.BoardServiceModify;
import com.site.memberBoard.Service.BoardServiceModifyView;
import com.site.memberBoard.Service.BoardServiceReply;
import com.site.memberBoard.Service.BoardServiceReplyView;
import com.site.memberBoard.Service.BoardServiceView;
import com.site.memberBoard.Service.BoardServiceWrite;

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
		request.setCharacterEncoding("UTF-8");
		String filePath = request.getRequestURI().substring(request.getContextPath().length());
		RequestDispatcher dispatcher = null;
		BoardService boardService = null;
		switch (filePath) {
		case "/board/bList.do":
				boardService = new BoardServiceList();
				boardService.execute(request, response);
				dispatcher = request.getRequestDispatcher("./bList.jsp");
				
			break;
		case "/board/bView.do":
			boardService = new BoardServiceView();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./bView.jsp");
			
			break;
		case "/board/bWrite.do":
			dispatcher = request.getRequestDispatcher("./bWrite.jsp");
			break;
		case "/board/bWriteOk.do":
			boardService = new BoardServiceWrite();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("/board/bList.do");
			break;
		case "/board/bDelete.do":
			boardService = new BoardServiceDelete();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("/board/bList.do");
			break;
		case "/board/bModify.do":
			boardService = new BoardServiceModifyView();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./bModify.jsp");
			break;
		case "/board/bModifyOk.do":
			boardService = new BoardServiceModify();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("/board/bList.do");
			break;
		case "/board/bReply.do":
			boardService = new BoardServiceReplyView();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("./bReply.jsp");
			break;
		case "/board/bReplyOk.do":
			boardService = new BoardServiceReply();
			boardService.execute(request, response);
			dispatcher = request.getRequestDispatcher("/board/bList.do");
			break;

		default:
			dispatcher = request.getRequestDispatcher("/");
			break;
		}
		dispatcher.forward(request, response);
			
		}
	}


