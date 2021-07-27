package com.site.ex0722.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.site.ex0722.Vo.BVo;

public class BDao {
	public BDao() {
	}

	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String btitle, bcontent, bname, bupload;
	int bid, bgroup, bstep, bindent, bhit;
	Timestamp bdate;

	public Connection getConnection() throws Exception {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		return ds.getConnection();
	}// getConnection

	public ArrayList<BVo> allBoardList() {
		ArrayList<BVo> list = new ArrayList<BVo>();
		try {
			conn = getConnection();
			String sql = "select * from board order by bgroup desc,bstep asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bid = rs.getInt("bid");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bname = rs.getString("bname");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				bdate = rs.getTimestamp("bdate");
				bupload = rs.getString("bupload");
				bhit = rs.getInt("bhit");

				BVo bvo = new BVo(bid, btitle, bcontent, bname, bgroup, bstep, bindent, bdate, bupload, bhit);
				list.add(bvo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}// allBoardList
	
	public BVo oneBoardList(int bId) {
			BVo bVo = null;
		try {
			conn = getConnection();
			String sql = "select bid,btitle,bcontent,bname,bdate,bupload,bhit from board where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bId);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				bid = rs.getInt("bid");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bname = rs.getString("bname");
				bdate = rs.getTimestamp("bdate");
				bupload = rs.getString("bupload");
				bhit = rs.getInt("bhit");

				bVo = new BVo(bid,btitle,bcontent,bname,bdate,bupload,bhit);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bVo;
	}//oneBoardList
	
	public int writeBoard(BVo bVo) {
		int resultNum = 0;
	try {
		conn = getConnection();
		String sql = "insert into board values(board_seq.nextval,?,?,?,board_seq.currval,1,0,sysdate,?,0)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bVo.getBtitle());
		pstmt.setString(2, bVo.getBcontent());
		pstmt.setString(3, bVo.getBname());
		pstmt.setString(4, bVo.getBupload());
		resultNum = pstmt.executeUpdate();


	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	return resultNum;
	}//writeBoard
	
	public int modifyBoard(BVo bVo) {
		int resultNum = 0;
	try {
		conn = getConnection();
		String sql = "update board set btitle = ?, bcontent = ?, bname = ?, bupload = ? where bid = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bVo.getBtitle());
		pstmt.setString(2, bVo.getBcontent());
		pstmt.setString(3, bVo.getBname());
		pstmt.setString(4, bVo.getBupload());
		pstmt.setInt(5, bVo.getBid());
		resultNum = pstmt.executeUpdate();


	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	return resultNum;
	}//modifyBoard
	
	public int deleteBoard(int bId) {
		int resultNum = 0;
	try {
		conn = getConnection();
		String sql = "delete board where bid = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bId);
		resultNum = pstmt.executeUpdate();


	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	return resultNum;
	}//deleteBoard
	
	public int replyBoard(BVo bVo1) {
		int resultNum = 0;
		BVo bVo2 = null;
	try {
		conn = getConnection();
		String sql = "select bgroup,bstep,bindent from board where bid = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bVo1.getBid());
		rs = pstmt.executeQuery();

		if(rs.next()) {
			bgroup = rs.getInt("bgroup");
			bstep = rs.getInt("bstep");
			bindent = rs.getInt("bindent");

			bVo2 = new BVo(bgroup,bstep,bindent);
		}
		
		sql = "update board set bstep = bstep+1 where bstep >= ? +1";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bVo2.getBstep());
		resultNum = pstmt.executeUpdate();
		
		sql = "insert into board values(board_seq.nextval,?,?,?,?,?+1,?+1,sysdate,?,0)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bVo1.getBtitle());
		pstmt.setString(2, bVo1.getBcontent());
		pstmt.setString(3, bVo1.getBname());
		pstmt.setInt(4, bVo2.getBgroup());
		pstmt.setInt(5, bVo2.getBstep());
		pstmt.setInt(6, bVo2.getBindent());
		pstmt.setString(7, bVo1.getBupload());
		resultNum = pstmt.executeUpdate();


	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	return resultNum;
	}//deleteBoard
	
	public ArrayList<BVo> writeComment(int bId, String bComment) {
		int resultNum = 0;
		ArrayList<BVo> list = new ArrayList<BVo>();
	try {
		conn = getConnection();
		String sql = "insert into b_reply values(?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bComment);
		pstmt.setInt(2, bId);
		resultNum = pstmt.executeUpdate();

		sql = "select * from b_reply";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			BVo bVo = new BVo();
			bVo.setComment(rs.getString("r_content"));
			list.add(bVo);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(rs != null) rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	return list;
	}//writeBoard
}
