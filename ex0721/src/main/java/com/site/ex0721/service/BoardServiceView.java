package com.site.ex0721.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0721.Vo.BVo;
import com.site.ex0721.dao.BDao;

public class BoardServiceView implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		BDao bDao = new BDao();
		BVo bVo = bDao.oneBoardList(bid);
		request.setAttribute("bVo", bVo);
		
	}

}
