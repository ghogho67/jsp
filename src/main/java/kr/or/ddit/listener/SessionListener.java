package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionListener implements HttpSessionListener{
	private static final Logger logger = LoggerFactory
			.getLogger(SessionListener.class);
	
	//사용하기 위해선 web.xml 가서 클래스를 등록한다.
	//로그인을 처음으로할때 가상으로 jsession을 만들어준다 그럴때 session이 생길때 생긴다.
	//그러므로 j세션이 만들어질때 관리를 할수있다.
	
	private Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().getServletContext().setAttribute("sessionMap", sessionMap);
		logger.debug("session created : {}", se.getSession().getId()); //쿠키의 세션값 우리가 쿠키에 user정보를 받아 session에 넣어줘서 그런듯
		sessionMap.put(se.getSession().getId(), se.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.debug("session Destroyed : {}", se.getSession().getId());
		sessionMap.remove(se.getSession().getId());
	}

}
