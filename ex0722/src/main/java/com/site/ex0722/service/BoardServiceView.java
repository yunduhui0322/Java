package com.site.ex0722.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0722.Vo.BVo;
import com.site.ex0722.dao.BDao;

public class BoardServiceView implements BoardService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		BDao bDao = new BDao();
		bDao.increase_bhit(bid);
		BVo bVo = bDao.oneBoardList(bid);
		
		request.setAttribute("bVo", bVo);
	}
}
