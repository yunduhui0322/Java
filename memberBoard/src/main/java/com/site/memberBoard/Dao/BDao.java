package com.site.memberBoard.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.site.memberBoard.Vo.BVo;

public class BDao {

	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public Connection getConnection() throws Exception {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		return ds.getConnection();
	}

	public ArrayList<BVo> allListBoard(int startRow, int endRow) {
		ArrayList<BVo> list = new ArrayList<BVo>();
		try {
			conn = getConnection();
			String sql = "select * from\r\n"
						+ "(select rownum as rnum,b.* from"
						+ "(select * from board order by bgroup desc, bstep asc) b) where rnum >=? and rnum<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BVo bVo = new BVo(rs.getInt("bid"), rs.getString("btitle"), rs.getString("bcontent"),
						rs.getString("bname"), rs.getInt("bgroup"), rs.getInt("bstep"), rs.getInt("bindent"),
						rs.getTimestamp("bdate"), rs.getString("bupload"), rs.getInt("bhit"));
				list.add(bVo);
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
		
	}// allListBoard

	public BVo oneBoardList(int bid) {
		BVo bVo = new BVo();
		try {
			conn = getConnection();
			String sql = "select * from board where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bVo = new BVo(rs.getInt("bid"), rs.getString("btitle"), rs.getString("bcontent"), rs.getString("bname"),
						rs.getInt("bgroup"), rs.getInt("bstep"), rs.getInt("bindent"), rs.getTimestamp("bdate"),
						rs.getString("bupload"), rs.getInt("bhit"));
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
	}// oneBoardList

	public int boardWrite(String btitle, String bcontent, String bname, String bupload) {
		int resultNum = 0;
		try {
			conn = getConnection();
			String sql = "insert into board values(board_seq.nextval,?,?,?,board_seq.currval,0,0,sysdate,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bcontent);
			pstmt.setString(3, bname);
			pstmt.setString(4, bupload);
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
	}// boardWrite

	public int boardDelete(int bid) {
		int resultNum = 0;
		try {
			conn = getConnection();
			String sql = "delete board where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
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
	}// boardDelete

	public int increaseHit(int bid) {
		int resultNum = 0;
		try {
			conn = getConnection();
			String sql = "update board set bhit = bhit+1 where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
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
	}// increaseHit

	public int modifyBoard(int bid, String btitle, String bcontent, String bupload) {
		int resultNum = 0;
		try {
			conn = getConnection();
			String sql = "update board set btitle = ?, bcontent = ?, bupload = ? where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bcontent);
			pstmt.setString(3, bupload);
			pstmt.setInt(4, bid);
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
	}// modifyBoard

	
	public int replyBoard(int bgroup, int bstep, int bindent,String btitle, String bcontent, String bname, String bupload) {
		int resultNum = 0;
		String sql = "";
		try {
			conn = getConnection();
			sql = "update board set bstep = bstep+1 where bstep > ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bstep);
			pstmt.executeUpdate();
			sql = "insert into board values(board_seq.nextval,?,?,?,?,?,?,sysdate,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bcontent);
			pstmt.setString(3, bname);
			pstmt.setInt(4, bgroup);
			pstmt.setInt(5, bstep+1);
			pstmt.setInt(6, bindent+1);
			pstmt.setString(7, bupload);
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
	}


	public ArrayList<BVo> searchListBoard(int startRow, int endRow, String category, String searchWord) {
		ArrayList<BVo> list = new ArrayList<BVo>();
		try {
			conn = getConnection();
			if(category.equals("title")) {
				String sql = "select * from\r\n"
						+ "(select rownum as rnum,b.* from"
						+ "(select * from board order by bgroup desc, bstep asc) b where btitle like ?) where rnum >=? and rnum<=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,"%" + searchWord + "%");
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
			}else if(category.equals("all")) {
				String sql = "select * from\r\n"
						+ "(select rownum as rnum,b.* from"
						+ "(select * from board order by bgroup desc, bstep asc) b where btitle like ? or bcontent like ?) where rnum >=? and rnum<=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,"%" + searchWord + "%");
				pstmt.setString(2,"%" + searchWord + "%");
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
				
			}else if(category.equals("content")) {
				String sql = "select * from\r\n"
						+ "(select rownum as rnum,b.* from"
						+ "(select * from board order by bgroup desc, bstep asc) b where bcontent like ?) where rnum >=? and rnum<=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,"%" + searchWord + "%");
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
			}else if(category.equals("")) {
				String sql = "select * from\r\n"
							+ "(select rownum as rnum,b.* from"
							+ "(select * from board order by bgroup desc, bstep asc) b) where rnum >=? and rnum<=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
			}
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BVo bVo = new BVo(rs.getInt("bid"), rs.getString("btitle"), rs.getString("bcontent"),
						rs.getString("bname"), rs.getInt("bgroup"), rs.getInt("bstep"), rs.getInt("bindent"),
						rs.getTimestamp("bdate"), rs.getString("bupload"), rs.getInt("bhit"));
				list.add(bVo);
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
	}//searchListBoard

	public int allSearchCount( String category, String searchWord) {
		int listCount = 0;
		String sql = "";
		try {
			conn = getConnection();
			switch (category) {
			case "all":
				sql = "select count(*) count from board where btitle like ? or bcontent like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,"%" + searchWord + "%");
				pstmt.setString(2,"%" + searchWord + "%");
				System.out.println(searchWord);
				System.out.println(category);
				break;
			case "title":
				sql = "select count(*) count from board where btitle like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,"%" + searchWord + "%");
				System.out.println(category);
				break;
			case "content":
				sql = "select count(*) count from board where bcontent like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,"%" + searchWord + "%");
				System.out.println(category);
				break;
			case "":
				sql = "select count(*) as count from board ";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				break;
			default:
				break;
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt("count");
			}
			System.out.println(listCount);
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
		return listCount;
	}//allSearchCount
	
	
}
