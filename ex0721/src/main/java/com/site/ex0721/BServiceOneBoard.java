package com.site.ex0721;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BServiceOneBoard implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse rsponse) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao boardDao = new BoardDao();
		BoardVo boardVo = boardDao.selectOneBoard(bid);
		request.setAttribute("boardVo", boardVo);
	}

}
