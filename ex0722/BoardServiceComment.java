package com.site.ex0722.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0722.Vo.BVo;
import com.site.ex0722.dao.BDao;

public class BoardServiceComment implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		String repy = request.getParameter("reply");
		BDao bDao = new BDao();
		ArrayList<BVo> list  = bDao.writeComment(bid, repy);
		request.setAttribute("list", list);
	}

}
