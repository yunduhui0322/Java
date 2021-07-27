package com.site.memberBoard.Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.memberBoard.Dao.BDao;
import com.site.memberBoard.Vo.BVo;

public class BoardServiceList implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();
		//하단 넘버링 관련정보
		int page = 1;//현재페이지
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		String searchWord = request.getParameter("searchWord");
		String category = request.getParameter("category");
		if(searchWord == null) {
			category = "";
		}
		int limit = 10;//한 페이지당 리스트 게시글수 10, 15 ,20
		int listcount = bDao.allSearchCount(category,searchWord); //총 게시글수;
		int maxPage = (int)((double)listcount/limit+0.99);
		int startPage = ((int)((double)page/10+0.99)-1) * limit +1;
		int endPage = startPage+10-1;
		if(endPage > maxPage) endPage = maxPage;
		
		request.setAttribute("page", page);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("searchWord", searchWord);
		request.setAttribute("category", category);
		//DB관련 정보
		int startRow = (page-1) * limit+1;
		int endRow = startRow + limit -1;
		
		ArrayList<BVo> list = bDao.searchListBoard(startRow,endRow,category,searchWord);
		request.setAttribute("list", list);
	}

}
