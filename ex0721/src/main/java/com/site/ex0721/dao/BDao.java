package com.site.ex0721.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.site.ex0721.Vo.BVo;

public class BDao {
	
	 
	
	DataSource ds= null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int bid,bgroup,bstep,bindent,bhit;
	Timestamp bdate;
	String btitle,bcontent,bname,bupload;
	BVo bVo = null;
	public BDao(){}
	//context접근해서 DataSource Connection 객체1개 가져옴.
	public Connection getConnection() throws Exception {
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		return ds.getConnection();
	}
	//board 전체 게시물 가져오기
	public ArrayList<BVo> allBoardList(){
		ArrayList<BVo> list = new ArrayList<BVo>();
		try {
			conn = getConnection();
			String sql = "select * from board order by bgroup desc, bstep asc";
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
				list.add(new BVo(bid,btitle,bcontent,bname,bgroup,bstep,bindent,bdate,bupload,bhit));
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
	}//allBoardList
	
	public BVo oneBoardList(int bId){
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
				bVo = new BVo(bid,btitle,bcontent,bname,bgroup,bstep,bindent,bdate,bupload,bhit);
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
		return bVo;
	}//oneBoardList
	
	public int boardWrite(BVo bVo){
		int resultNum = 0;
		try {
			conn = getConnection();
			String sql = "insert into board values(board_seq.nextval,?,?,?,board_seq.currval,0,0,sysdate,?,1)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getBtitle());
			pstmt.setString(2, bVo.getBcontent());
			pstmt.setString(3, bVo.getBname());
			pstmt.setString(4, bVo.getBupload());
			resultNum = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultNum;
	}//boardWrite
	
	public int boardModify(BVo bVo){
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
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultNum;
	}
	
	public int deleteBoard(int bid){
		int resultNum = 0;
		try {
			conn = getConnection();
			String sql = "delete board where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			resultNum = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultNum;
	}
	
	public int replyBoard(BVo bVo1){
		int resultNum = 0;
		try {
			conn = getConnection();
			String sql = "select bgroup,bstep,bindent from board where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bVo1.getBid());
			rs = pstmt.executeQuery();
			
			if	(rs.next()) {
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				bVo = new BVo(bgroup,bstep,bindent);
			}
			conn = getConnection();
			sql = "update board set bstep = bstep +1 where bstep >= ? +1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bVo.getBstep());
			resultNum = pstmt.executeUpdate();
			
			conn = getConnection();
			sql = "insert into board values(board_seq.nextval,?,?,?,?,?,?,sysdate,?,1)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo1.getBtitle());
			pstmt.setString(2, bVo1.getBcontent());
			pstmt.setString(3, bVo1.getBname());
			pstmt.setInt(4, bVo.getBgroup());
			pstmt.setInt(5, (bVo.getBstep()+1));
			pstmt.setInt(6, (bVo.getBindent()+1));
			pstmt.setString(7, bVo1.getBupload());
			resultNum = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultNum;
	}
}
