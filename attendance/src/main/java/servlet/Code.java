package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/code")
public class Code extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Code() {
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
        
        String j001 = request.getParameter("j001");
        String m001 = request.getParameter("m001");
        String p001 = request.getParameter("p001");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
	}

}
