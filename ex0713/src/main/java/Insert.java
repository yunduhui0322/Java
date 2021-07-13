

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex0713.Board;

@WebServlet("/t")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int bid1 = Integer.parseInt(request.getParameter("bid"));
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Board>list = new ArrayList<Board>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"ora_user","1234");
			stmt = conn.createStatement();
			String sql = "select bid,btitle,bname,to_char(bdate,'yyyy-mm-dd') as bdate,bcontent,bgroup,bstep,bindent,bupload,bhit from board where bid = "+bid1;
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bname = rs.getString("bname");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				int bhit = rs.getInt("bhit");
				String bdate = rs.getString("bdate");
				String bupload = rs.getString("bupload");
				list.add(new Board(bid,bgroup,bstep,bhit,bindent,btitle,bcontent,bname,bupload,bdate));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			}catch(Exception e2) {
				e2.printStackTrace();
				
			}
		}
		
		request.setAttribute("list", list);
		getServletConfig().getServletContext().getRequestDispatcher("/content_view.jsp").forward(request,response);
		
	}

	
}
