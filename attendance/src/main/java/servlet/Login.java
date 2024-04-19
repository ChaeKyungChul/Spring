package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attendance.dto.DBto;
import attendance.dto.PDto;
import dao.DBConnect;
import dao.MemberDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection conn = null;
	DBConnect db = new DBConnect();
       
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");	
        request.setCharacterEncoding("utf-8");
        String mode = "student";
        PrintWriter out = response.getWriter();
		String uname = request.getParameter("name");
		String unum = request.getParameter("student_id");
		String upass = request.getParameter("password");
		
		System.out.println(unum);
		
		if(unum=="") {
			mode = "professor";
		}
		String tname = request.getParameter("tname");
		String tpass = request.getParameter("tpass");
		
		System.out.println(mode);
		try {
			
			if(mode.equals("student")) {
				conn = db.getConnection();
				MemberDao dao = new MemberDao(conn);
				DBto dbto = dao.login(uname, upass, unum);
				if(dbto.getId() != 0){
					HttpSession session = request.getSession();
					session.setAttribute("name", dbto.getName());
					session.setAttribute("student_id", dbto.getStudent_id());
					session.setAttribute("password", dbto.getPassword());		
					response.sendRedirect("loginok.jsp");
					System.out.println("로그인성공");
				}else {
					System.out.println("로그인 실패");
					String src = "<script>alert('아이디 또는 비밀번호가 틀렸습니다. 다시 확인하세요.');"
		   		         	+ "location.href='index.jsp';</script>"; 
					out.println(src);
				}
			}
			else if(mode.equals("professor")) {
				conn = db.getConnection();
				MemberDao dao = new MemberDao(conn);
				PDto pbto = dao.login(tname, tpass);
				if(pbto.getId() != 0){
				HttpSession session = request.getSession();
				session.setAttribute("name", pbto.getName());
				session.setAttribute("password", pbto.getUserpass());		
				response.sendRedirect("loginok.jsp");
				System.out.println("로그인성공");
				}else {
				System.out.println("로그인 실패");
				String src = "<script>alert('아이디 또는 비밀번호가 틀렸습니다. 다시 확인하세요.');"
	   		         	+ "location.href='index.jsp';</script>"; 
				out.println(src);
				}
			}
	}catch(SQLException e) {
		e.printStackTrace();
	}catch(NamingException e) {
		e.printStackTrace();
	}
	}
}
