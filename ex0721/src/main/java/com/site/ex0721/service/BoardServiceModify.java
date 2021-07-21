package com.site.ex0721.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.site.ex0721.Vo.BVo;
import com.site.ex0721.dao.BDao;

public class BoardServiceModify implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "c:/upload";
		int size = 10 * 1024 * 1024;
		String btitle ="",bcontent = "", bname = "", bupload = "";
		int bid = 0;
		try {
			MultipartRequest multi = new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
			bid = Integer.parseInt(multi.getParameter("bid"));
			btitle = multi.getParameter("btitle");
			bcontent = multi.getParameter("bcontent");
			bname = multi.getParameter("bname");
			bupload = multi.getFilesystemName("file");
		} catch (Exception e) {
			e.printStackTrace();
		}
		BVo bVo = new BVo(bid,btitle,bcontent,bname,bupload);
		BDao bDao = new BDao();
		int modifyResult = bDao.boardModify(bVo);
		request.setAttribute("modifyResult", modifyResult);
	}

}
