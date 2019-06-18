package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/*")
public class DefaultParamFilter implements Filter {

    public DefaultParamFilter() {

    }

	public void destroy() {

	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		DefaultPramWrapper requestWrapper = new DefaultPramWrapper((HttpServletRequest)request);
		/*이 필터클래스는 @WebFilter("/*") 모든 영역에 있는것이고  
		DefaultPramWrapper requestWrapper = new DefaultPramWrapper((HttpServletRequest)request);
		를 통해서 
		requestWrapper.setParameter("UNT_CD", new String[]{"LINE"}); 파라미터를 set 해주고
		chain.doFilter(requestWrapper, response); //파라미터 세팅 일반 request를 보내주는게 아니라 
		우리가 만들어준 requestWrapper를 세팅하여 보내주면
		전지역에 request.getparmeter("UNT_CD") 해주면 그안에있는 배열값을 보낼수있다.
		
		이거 하기 전에 DefaultPramWrapper.java 안에서 오버라이드를 해준다. 오른쪽 상단에 
		quick Access에 override 를 쳐서 parameter 를 포함하는것들을
		오버라이드 해준다음 연결해준다. 저 자세한것은 DefaultPramWrapper.java안에 확인!
		*
		*/
		requestWrapper.setParameter("UNT_CD", new String[]{"LINE"});
		chain.doFilter(requestWrapper, response); //파라미터 세팅
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
