package com.site.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UDao {
	public UDao(){}
	UDto uDto = new UDto ();
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public Connection getConnection() throws Exception {
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		return ds.getConnection();
	}
	
	public int insertUser(UDto uDto) {
		int resultNum = 0;
		try {
			conn = getConnection();
			String sql = "insert into member2 values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uDto.getId());
			pstmt.setString(2, uDto.getPw());
			pstmt.setString(3, uDto.getName());
			pstmt.setString(4, uDto.getNickName());
			pstmt.setString(5, uDto.getGender());
			pstmt.setString(6, uDto.getTel());
			pstmt.setString(7, uDto.getAddress1());
			pstmt.setString(8, uDto.getAddress2());
			pstmt.setString(9, uDto.getHobby());
			
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
	public UDto loginUser(String id, String pw) {
		UDto uDto = new UDto();
		try {
			conn = getConnection();
			String sql = "select * from member2 where id = ? and pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				uDto.setId(rs.getString("id"));
				uDto.setPw(rs.getString("pw"));
				uDto.setName(rs.getString("Name"));
				uDto.setNickName(rs.getString("nickName"));
				uDto.setGender(rs.getString("gender"));
				uDto.setTel(rs.getString("tel"));
				uDto.setAddress1(rs.getString("address1"));
				uDto.setAddress2(rs.getString("Address2"));
				uDto.setHobby(rs.getString("hobby"));
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
		return uDto;
	}
	public int m_User(UDto uDto,String id) {
		int resultNum = 0;
		try {
			conn = getConnection();
			String sql = "update member2 set id=?,pw=?,name=?,nickname=?,gender=?,tel=?,address1=?,address2=?,hobby=? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uDto.getId());
			pstmt.setString(2, uDto.getPw());
			pstmt.setString(3, uDto.getName());
			pstmt.setString(4, uDto.getNickName());
			pstmt.setString(5, uDto.getGender());
			pstmt.setString(6, uDto.getTel());
			pstmt.setString(7, uDto.getAddress1());
			pstmt.setString(8, uDto.getAddress2());
			pstmt.setString(9, uDto.getHobby());
			pstmt.setString(10, id);
			
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
