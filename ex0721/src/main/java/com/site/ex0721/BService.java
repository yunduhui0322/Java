package com.site.ex0721;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BService {
	//db에 접근해서 데이터를 가져오는 메소드 -AarayList,Vo,int
	public void execute(HttpServletRequest request, HttpServletResponse rsponse);
}
