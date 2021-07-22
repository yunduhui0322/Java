package com.site.ex0722.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0722.dao.BDao;

public class BoardServiceDelete implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		BDao bDao = new BDao();
		int deleteResult = bDao.deleteBoard(bid);
		request.setAttribute("deleteResult", deleteResult);
		request.setAttribute("bid", bid);
	}

}
