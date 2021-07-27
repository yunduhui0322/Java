package com.site.memberBoard.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.memberBoard.Dao.BDao;
import com.site.memberBoard.Vo.BVo;

public class BoardServiceReplyView implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int page = 1;//현재페이지
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		String searchWord = request.getParameter("searchWord");
		String category = request.getParameter("category");
		if(searchWord == null) {
			category = "";
		}
		int bid = Integer.parseInt(request.getParameter("bid"));
		BDao bDao = new BDao();
		BVo bVo = bDao.oneBoardList(bid); 
		request.setAttribute("bVo", bVo);
		request.setAttribute("page", page);
		request.setAttribute("searchWord", searchWord);
		request.setAttribute("category", category);
	}
	

}
