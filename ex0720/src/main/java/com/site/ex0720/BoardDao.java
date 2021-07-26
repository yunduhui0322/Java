package com.site.ex0720;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds = null;
//	int bid,bgroup,bstpe,bindent,bhit;
//	String btitle,bcontent,bname,bupload;
//	Timestamp bdate;
	//if(rs.next)문에서 하나하나씩 데이터값 받아와서 bVo생성자로 넣는다.
	public BoardDao(){
		
	}
	
	public Connection getConnection() throws Exception {
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		
		return ds.getConnection();
	}
	
	public BoardVo selectOneUser(int bId) {
		BoardVo bVo = new BoardVo();
		try {
			conn = getConnection();
			String sql = "select * from board where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bVo.setbId(rs.getInt("bid"));
				bVo.setbTitle(rs.getString("btitle"));
				bVo.setbContent(rs.getString("bcontent"));
				bVo.setbName(rs.getString("bname"));
				bVo.setbGroup(rs.getInt("bgroup"));
				bVo.setbStep(rs.getInt("bstep"));
				bVo.setbIndent(rs.getInt("bindent"));
				bVo.setbDate(rs.getTimestamp("bdate"));
				bVo.setbHit(rs.getInt("bhit"));
				bVo.setbUpload(rs.getString("bupload"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return bVo;
	}
	
	public ArrayList<BoardVo> selectAllUser() {
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		try {
			conn = getConnection();
			String sql = "select * from board ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVo bVo = new BoardVo();
				bVo.setbId(rs.getInt("bid"));
				bVo.setbTitle(rs.getString("btitle"));
				bVo.setbContent(rs.getString("bcontent"));
				bVo.setbName(rs.getString("bname"));
				bVo.setbGroup(rs.getInt("bgroup"));
				bVo.setbStep(rs.getInt("bstep"));
				bVo.setbIndent(rs.getInt("bindent"));
				bVo.setbDate(rs.getTimestamp("bdate"));
				bVo.setbHit(rs.getInt("bhit"));
				bVo.setbUpload(rs.getString("bupload"));
				list.add(bVo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public int boardInsert(BoardVo bVo) {
			int resultNum = 0;
		try {
			conn = getConnection();
			String sql = "insert into board values(board_seq.nextval,?,?,?,board_seq.currval,0,0,sysdate,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getbTitle());
			pstmt.setString(2, bVo.getbContent());
			pstmt.setString(3, bVo.getbName());
			pstmt.setString(4, bVo.getbUpload());
			resultNum = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultNum;
	}
}
