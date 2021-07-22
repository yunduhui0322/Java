package com.site.ex0722.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.site.ex0722.Vo.BVo;
import com.site.ex0722.dao.BDao;

public class BoardServiceWrite implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "c:/upload";
		int size = 10 * 1024 * 1024;
		String bname = "", btitle = "", bcontent = "", bupload = "";

		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			bname = multi.getParameter("bname");
			btitle = multi.getParameter("btitle");
			bcontent = multi.getParameter("bcontent");
			bupload = multi.getFilesystemName("file");
		} catch (Exception e) {
			e.printStackTrace();
		}
		BVo bVo = new BVo(btitle, bcontent, bname, bupload);
		BDao bDao = new BDao();
		int writeResult = bDao.writeBoard(bVo);
		request.setAttribute("writeResult", writeResult);
	}
}
