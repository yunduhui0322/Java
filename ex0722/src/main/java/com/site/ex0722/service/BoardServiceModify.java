package com.site.ex0722.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.site.ex0722.Vo.BVo;
import com.site.ex0722.dao.BDao;

public class BoardServiceModify implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "c:/upload";
		int size = 10 * 1024 * 1024;
		String bname = "", btitle = "", bcontent = "", bupload = "";
		int bid = 0;

		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			bid = Integer.parseInt(multi.getParameter("bid"));
			bname = multi.getParameter("bname");
			btitle = multi.getParameter("btitle");
			bcontent = multi.getParameter("bcontent");
			bupload = multi.getFilesystemName("file");
			if(bupload == null) {
				bupload = multi.getParameter("oldUpload");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BVo bVo = new BVo(bid,btitle, bcontent, bname, bupload);
		BDao bDao = new BDao();
		int modifyResult = bDao.modifyBoard(bVo);
		request.setAttribute("modifyResult", modifyResult);
	}

}
