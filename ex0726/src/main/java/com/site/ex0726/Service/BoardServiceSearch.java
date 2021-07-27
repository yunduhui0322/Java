package com.site.ex0726.Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0726.Dao.BDao;
import com.site.ex0726.Vo.BVo;

public class BoardServiceSearch implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();
		ArrayList<BVo> list= new ArrayList<BVo>();
		String category = request.getParameter("category"); 
		String bsearch = request.getParameter("bsearch");
		if(category.equals("0")) {
			list = bDao.searchAll(bsearch);
		}else if (category.equals("title")) {
			list = bDao.searchTitle(bsearch);
		}else if (category.equals("content")) {
			list = bDao.searchContent(bsearch);
		}
		request.setAttribute("list", list);
	}
	
		
}

