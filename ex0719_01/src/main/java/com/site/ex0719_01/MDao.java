package com.site.ex0719_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MDao {
	MDto mDto = new MDto();
	ArrayList <MDto> list = new ArrayList<MDto>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	DataSource ds = null;
	ResultSet rs = null;
	
	public Connection getConnection() throws Exception {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		return ds.getConnection();
	}
	
	public MDto loginMember(String id, String pw) {
		try {
			conn = getConnection();
			String sql = "select * from member2 where id = ? and pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mDto.setId(rs.getString("id"));
				mDto.setPw(rs.getString("pw"));
				mDto.setName(rs.getString("Name"));
				mDto.setNickName(rs.getString("nickname"));
				mDto.setGender(rs.getString("gender"));
				mDto.setTel(rs.getString("Tel"));
				mDto.setAddress1(rs.getString("address1"));
				mDto.setAddress2(rs.getString("Address2"));
				mDto.setHobby(rs.getString("hobby"));
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
		return mDto;
	}
	
	public ArrayList<MDto> memberList() {
		try {
			conn = getConnection();
			String sql = "select * from member2 ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MDto mDto = new MDto();
				mDto.setId(rs.getString("id"));
				mDto.setPw(rs.getString("pw"));
				mDto.setName(rs.getString("Name"));
				mDto.setNickName(rs.getString("nickname"));
				mDto.setGender(rs.getString("gender"));
				mDto.setTel(rs.getString("Tel"));
				mDto.setAddress1(rs.getString("address1"));
				mDto.setAddress2(rs.getString("Address2"));
				mDto.setHobby(rs.getString("hobby"));
				list.add(mDto);
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
}
