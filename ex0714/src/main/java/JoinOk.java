

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JO")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		String hobby = "";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw2");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String[] hobbys = request.getParameterValues("hobby");
		for( int i=0; i<hobbys.length;i++) {
			if (i == 0) {
				hobby += hobbys[i];
			}else {
				hobby += "," + hobbys[i];
			}
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url  = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"ora_user","1234");
			String sql = "insert into mem values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, gender);
			pstmt.setString(5, job);
			pstmt.setString(6, hobby);
			
			int i = pstmt.executeUpdate();
			
			if( i == 1) {
				System.out.println("데이터 저장 성공");
				response.sendRedirect("./joinResult.jsp");
			}else {
				System.out.println("데이터 저장 실패");
				response.sendRedirect("./index.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}

}
