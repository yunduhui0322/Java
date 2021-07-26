package com.site.ex0726.Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0726.Dao.BDao;
import com.site.ex0726.Vo.BVo;

public class BoardServiceList implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();
		ArrayList<BVo> list = bDao.allListBoard();
		request.setAttribute("list", list);

	}

}
