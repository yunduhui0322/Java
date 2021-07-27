package com.site.ex0726.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.site.ex0726.Vo.BVo;

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

	public ArrayList<BVo> allListBoard() {
		ArrayList<BVo> list = new ArrayList<BVo>();
		try {
			conn = getConnection();
			String sql = "select * from board order by bgroup desc, bstep asc";
			pstmt = conn.prepareStatement(sql);
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

	public ArrayList<BVo> searchTitle(String btitle) {
		ArrayList<BVo> list = new ArrayList<BVo>();
		try {
			conn = getConnection();
			String sql = "select * from board where btitle like ? order by bgroup desc, bstep asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%" + btitle + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BVo bVo = new BVo();
				bVo = new BVo(rs.getInt("bid"), rs.getString("btitle"), rs.getString("bcontent"),
						rs.getString("bname"), rs.getInt("bgroup"), rs.getInt("bstep"), rs.getInt("bindent"),
						rs.getTimestamp("bdate"), rs.getString("bupload"), rs.getInt("bhit"));
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
	}// searchTitle

	public ArrayList<BVo> searchContent(String bcontent) {
		ArrayList<BVo> list = new ArrayList<BVo>();
		try {
			conn = getConnection();
			String sql = "select * from board where bcontent like ? order by bgroup desc, bstep asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ bcontent + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BVo bVo = new BVo();
				bVo = new BVo(rs.getInt("bid"), rs.getString("btitle"), rs.getString("bcontent"),
						rs.getString("bname"), rs.getInt("bgroup"), rs.getInt("bstep"), rs.getInt("bindent"),
						rs.getTimestamp("bdate"), rs.getString("bupload"), rs.getInt("bhit"));
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
	}// searchContent
	
	public ArrayList<BVo> searchAll(String all) {
		ArrayList<BVo> list = new ArrayList<BVo>();
		try {
			conn = getConnection();
			String sql = "select * from board where btitle like ? or bcontent like ? order by bgroup desc, bstep asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%" + all + "%");
			pstmt.setString(2,"%" + all + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BVo bVo = new BVo();
				bVo = new BVo(rs.getInt("bid"), rs.getString("btitle"), rs.getString("bcontent"),
						rs.getString("bname"), rs.getInt("bgroup"), rs.getInt("bstep"), rs.getInt("bindent"),
						rs.getTimestamp("bdate"), rs.getString("bupload"), rs.getInt("bhit"));
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
	}
}
