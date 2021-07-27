package com.site.memberBoard.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.memberBoard.Dao.BDao;

public interface BoardService {
	
	public void execute(HttpServletRequest request, HttpServletResponse response); 
}
