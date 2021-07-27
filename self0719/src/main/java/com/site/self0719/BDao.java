package com.site.self0719;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {
	DataSource ds = null;
	Connection conn= null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Connection getConnection() throws Exception {
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		return ds.getConnection();
	}
	
	public ArrayList<BDto> boardList(){
		ArrayList<BDto> list = new ArrayList<BDto>();
		try {
			conn = getConnection();
			String sql = "select * from board order by bgroup desc, bstep asc,bindent asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BDto bDto = new BDto();
				bDto.setbId(rs.getInt("bid"));
				bDto.setbTitle(rs.getString("btitle"));
				bDto.setbContent(rs.getString("bcontent"));
				bDto.setbUpload(rs.getString("bupload"));
				bDto.setbName(rs.getString("bName"));
				bDto.setbDate(rs.getTimestamp("bdate"));
				bDto.setbGroup(rs.getInt("bgroup"));
				bDto.setbStep(rs.getInt("bstep"));
				bDto.setbIndent(rs.getInt("bindent"));
				bDto.setbHit(rs.getInt("bhit"));
				list.add(bDto);
				
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
	}
}
