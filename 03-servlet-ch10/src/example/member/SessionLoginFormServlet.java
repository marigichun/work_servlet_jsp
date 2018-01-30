package example.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionLoginFormServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		PrintWriter out  = resp.getWriter();
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>로그인폼</title>");
		out.println("</head>");
		
		
		out.println("<body>");
		out.println("<form action='" + req.getContextPath() + "/member/session-login.do " + "method='post>");
		out.println("<lebel>아이디 <input type='text' name= 'id' size= '10' </lebel>");
		out.println("<inpt type = 'submit' value= '로그인'>");
		out.println("<form>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}
}
