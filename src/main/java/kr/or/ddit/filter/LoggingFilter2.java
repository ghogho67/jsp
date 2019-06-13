package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingFilter2 implements Filter {
	private static final Logger logger = LoggerFactory
			.getLogger(LoggingFilter2.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		 logger.debug("loggingFilter2 doFileter 전처리 : {}", uri);
		
		chain.doFilter(request, response);
		
		logger.debug("loggingFilter2 doFileter 후처리 : {}", uri);
		
	}

	@Override
	public void destroy() {
		
	}

}
