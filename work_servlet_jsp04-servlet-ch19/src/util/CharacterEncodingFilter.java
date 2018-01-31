package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * p.568
 */
public class CharacterEncodingFilter implements Filter {

	private String encoding;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");//web.xml의 <init-param>
																     //<param-name>encoding</param-name>	<!-- key -->
													  			     //<param-value>utf-8</param-value>	<!-- value -->
		/*														  //</init-param>
		 * excoding 값이 null이면 param-name이 excoding인 것이 없다는 뜻이므로	
		 * 만약 없다면 utf-8을 기본값으로 설정해주는 것이													
		 */
		if (encoding == null) {
		encoding = "utf-8";
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("인코딩 필터 들어감");
		
		/*
		 * 이 필터의 기능은 클라이언트로부터 요청받은 내요의
		 * 인코딩을 변경하는 작업
		 */
		req.setCharacterEncoding(encoding);
		
		chain.doFilter(req, resp);
		System.out.println("인코딩 필터에서 빠져 나감");
	}
	
	@Override
	public void destroy() {}
}
