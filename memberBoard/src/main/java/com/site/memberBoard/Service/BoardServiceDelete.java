package com.site.memberBoard.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.memberBoard.Dao.BDao;

public class BoardServiceDelete implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();
		
		int deleteNum = bDao.boardDelete(Integer.parseInt(request.getParameter("bid")));
		request.setAttribute("deleteNum", deleteNum);
	}

}
