package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//접속여부를 확인해서 (세션에 USER_INFO 속성이 존재하는지)
//접속이 안되어 있으면 --> login화면으로 이동
//접속이 되어있으면 정상적으로 최초요청한 리소스


// 잘봐야될것 ex: /user/suerList -- > login 으로 가야된다.
// 잘봐야될것 ex: /user/userPagingList -- > login 으로 가야된다.
// 잘봐야될것 ex: /login -- > login 으로 가야된다.

@WebFilter("/*")
public class LoginCheackFilter implements Filter {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginCheackFilter.class);

    public LoginCheackFilter() {

    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
//		String uri = req.getRequestURI(); 이렇게 그냥하면 ${pageContext.request.contextPath} 가 붙어서 그냥 넘어간다.
		
		String uri = req.getRequestURI();
		logger.debug("uri :{}", uri);
		// 주소가 /jsp/userPagingList --> /userPagingList로 바꿔준거임
		uri = uri.substring(req.getContextPath().length());
		
		
		//세션이 없어도 처리가 되어야 되는것들 : /login, /js, /css, /img (.js, .css, .png, .gif)  이미지파일 같은경는 폴더로 처리한다. 
		//처리가 되어야되는거가 로그인이 안됬을때 들어왔을때 지금 login으로 넘어가는거임
		
        if(uri.startsWith("/login") || uri.startsWith("/js")||
           uri.startsWith("/css") || uri.startsWith("/img") || uri.startsWith("/requestCount") || uri.startsWith("/sessionViewontroller")
           || uri.startsWith("/bootstrap"))
        	
        chain.doFilter(request, response);
        
        //session을 체크 해야하는 대상들
        else if(req.getSession().getAttribute("USER_INFO") != null){
        	   chain.doFilter(request, response);
        }
        else{
        	HttpServletResponse res = (HttpServletResponse)response;
        	res.sendRedirect(req.getContextPath()+"/login");
        }
	
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
