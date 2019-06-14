package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class RequestParameterEncodingFilter
 */
//@WebFilter("/RequestParameterEncodingFilter") // 이 주소로 왔을때만 요청이 가능하다. 
//@WebFilter(urlPatterns={"/userForm", "/userList"}) // 여러개도 가능하다. 
//@WebFilter(urlPatterns = {"/*"}) //전체 를 뜻한다.

/**
 * uri를 갖고올려면 httpservlet으로 형변환해줬지만
 * encoding은 servlertrquest에 있다.
 */

public class RequestParameterEncodingFilter implements Filter {

    public RequestParameterEncodingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
