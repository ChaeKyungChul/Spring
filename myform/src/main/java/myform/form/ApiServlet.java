package myform.form;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

//자바를이용해서 리엑트이용한것
@WebServlet("/api")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		StringBuilder jsonBuilder = new StringBuilder();
		String line;
		try(BufferedReader reader = request.getReader()){	
		while((line = reader.readLine()) != null) {
			jsonBuilder.append(line);
		  }
	    }catch(Exception e) {
	 	//
		}
		
		Gson gson = new Gson();
		
		RememberData data = gson.fromJson(jsonBuilder.toString(), RememberData.class );
		
		data.setRemember(!data.isRemember());
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		//object 타입으로 변환 해서 response 해준다.
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		//cors 설정
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Method","POST,GET,OPTIONS,DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
		
	/*	PrintWriter out = response.getWriter();
		out.print("{");
		out.print("\"remember\": \"성공적으로 데이터를 받았습니다.\",");
		out.print("\"email\": \"" + email + "\", ");
		out.print("\"pwd\": \"" + pwd + "\"");
		out.println("}");
		out.close();
		*/
		response.getWriter().write(gson.toJson(data));
		
	}

}
