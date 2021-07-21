package com.site.ex0721.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0721.dao.BDao;

public class BoardServiceDelete implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BDao bDao = new BDao();
		int deleteResult = bDao.deleteBoard(Integer.parseInt(request.getParameter("bid")));
		request.setAttribute("deleteResult",deleteResult );
	}

}
