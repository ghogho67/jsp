package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {
// contextPath -> js, css 경로설정
//${pageContext.request.contextPath}/js/jquery.js
//${cp}/js/jquery.js
//aplication cp 속성에 contextPath값을 넣어주면
//${cp}/js/jquery.js 사용
	
	@Override
	public void contextInitialized(ServletContextEvent sce) { //context 가 발동되었을때 이벤트
		ServletContext application = sce.getServletContext();
		application.setAttribute("cp", application.getContextPath());
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
