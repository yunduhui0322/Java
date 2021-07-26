package com.site.ex0726.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0726.Dao.BDao;

public interface BoardService {
	
	public void execute(HttpServletRequest request, HttpServletResponse response); 
}
