package com.site.memberBoard.Service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.site.memberBoard.Dao.BDao;

public class BoardServiceReply implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();
		String path = "c:/upload";
		int size = 10 * 1024 * 1024;
		MultipartRequest multi = null;
		String bupload = "",btitle = "", bcontent = "", bname = "";
		int bgroup = 0, bstep = 0, bindent = 0;
		try {
			multi = new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
			bupload = multi.getFilesystemName("file");
			btitle = multi.getParameter("btitle");
			bcontent = multi.getParameter("bcontent");
			bname = multi.getParameter("bname");
			bgroup = Integer.parseInt(multi.getParameter("bgroup"));
			bstep = Integer.parseInt(multi.getParameter("bstep"));
			bindent = Integer.parseInt(multi.getParameter("bindent"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		int ReplyResult = bDao.replyBoard(bgroup,bstep,bindent,btitle,bcontent,bname,bupload);
		request.setAttribute("ReplyResult", ReplyResult);
	}

}
