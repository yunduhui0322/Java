package com.site.ex0726.Service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.site.ex0726.Dao.BDao;

public class BoardServiceModify implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();
		String path = "c:/upload";
		int size = 10 * 1024 * 1024;
		MultipartRequest multi = null;
		String bupload = "";
		try {
			multi = new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
			bupload = multi.getFilesystemName("file");
			if(multi.getFilesystemName("file") == null) {
				bupload = multi.getParameter("oldFile");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int modifyResult = bDao.modifyBoard(Integer.parseInt(multi.getParameter("bid")), multi.getParameter("btitle"),multi.getParameter("bname"),bupload);
		request.setAttribute("modifyResult", modifyResult);

	}

	}

