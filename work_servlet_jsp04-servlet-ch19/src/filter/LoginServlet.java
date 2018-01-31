package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import util.CookieHelper;

public class LoginServlet extends HttpServlet {

	/*
	 * p.560
	 * doPost: 클라이언트가 HTTP Method POST로 요청을 하면 doPost 메소드가 실행된다.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		/*
		 * 클라이언트로부터 전달받은 요청 주문서에서
		 * body 부분을 확인하여 id값과 password 값을
		 * getParameter 메소드를 이용하여 가져온다.
		 */
		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		session.setAttribute("MEMBER",id);
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		
		out.println("<head><title>로그인</title></head>");
		out.println("<body>");
		out.println("로그인");
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println("</html>");
		
		out.flush();
		out.close();
	}
}









