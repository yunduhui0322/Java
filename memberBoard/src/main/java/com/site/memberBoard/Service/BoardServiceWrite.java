package com.site.memberBoard.Service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.site.memberBoard.Dao.BDao;

public class BoardServiceWrite implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();
		String path = "c:/upload";
		int size = 10 * 1024 * 1024;
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int insertResult = bDao.boardWrite(multi.getParameter("btitle"), multi.getParameter("bcontent"), multi.getParameter("bname"), multi.getFilesystemName("file"));
		request.setAttribute("insertResult", insertResult);

	}

}
