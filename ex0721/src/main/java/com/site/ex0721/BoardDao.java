package com.site.ex0721;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	
	 
	
	DataSource ds= null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int bid,bgroup,bstep,bindent,bhit;
	Timestamp bdate;
	String btitle,bcontent,bname,bupload;
	BoardVo boardVo = null;
	//context접근해서 DataSource Connection 객체1개 가져옴.
	public Connection getConnection() throws Exception {
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		return ds.getConnection();
	}
	//board 전체 게시물 가져오기
	public ArrayList<BoardVo> selectAllBoard(){
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		try {
			conn = getConnection();
			String sql = "select * from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
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
				list.add(new BoardVo(bid,btitle,bcontent,bname,bgroup,bstep,bindent,bdate,bupload,bhit));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}//selectAllBoard
	
	public BoardVo selectOneBoard(int bId){
		try {
			conn = getConnection();
			String sql = "select * from board where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bId);
			rs = pstmt.executeQuery();
			
			if	(rs.next()) {
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
				boardVo = new BoardVo(bid,btitle,bcontent,bname,bgroup,bstep,bindent,bdate,bupload,bhit);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return boardVo;
	}
}
