package com.site.ex0726.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0726.Dao.BDao;
import com.site.ex0726.Vo.BVo;

public class BoardServiceView implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		BDao bDao = new BDao();
		bDao.increaseHit(bid);
		BVo bVo = bDao.oneBoardList(bid); 
		request.setAttribute("bVo", bVo);
	}

}
