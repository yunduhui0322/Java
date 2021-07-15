package com.site.ex0715_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


//db연결 class -> 여기서함
public class MDao {

	public MDao(){}
	MDto mDto = new MDto();
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public Connection getConnection() throws Exception {
		
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		
		
		return ds.getConnection();
	}
	
	//로그인 id,pw 체크
	public MDto loginSelect(String userId, String userPw){
		try {
			conn = getConnection();
			String sql = "select * from member2 where id = ? and pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mDto.setId(rs.getString("id"));
				mDto.setPw(rs.getString("pw"));
				mDto.setGender(rs.getString("gender"));
				mDto.setAddress1(rs.getString("address1"));
				mDto.setAddress2(rs.getString("address2"));
				mDto.setTel(rs.getString("tel"));
				mDto.setHobby(rs.getString("hobby"));
				mDto.setNickName(rs.getString("nickname"));
				mDto.setName(rs.getString("name"));
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
		return mDto;
	}
	
	//회원가입메소드
	public int memberInsert(MDto mDto) {
		int resultNum = 0;
		try {
			conn = getConnection();
			String sql = "insert into member2 values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,mDto.getId());
			pstmt.setString(2,mDto.getPw() );
			pstmt.setString(3,mDto.getName() );
			pstmt.setString(4, mDto.getNickName());
			pstmt.setString(5,mDto.getGender() );
			pstmt.setString(6,mDto.getTel() );
			pstmt.setString(7,mDto.getAddress1() );
			pstmt.setString(8,mDto.getAddress2() );
			pstmt.setString(9,mDto.getHobby() );
			resultNum = pstmt.executeUpdate();
			
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
		
		return resultNum;
	}
}
