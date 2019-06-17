package kr.or.ddit.core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewResolver {//스프링에서 자주 쓸꺼임 뷰를찾아주는 클래스라고 알면됨
	
	private static final Logger logger = LoggerFactory
			.getLogger(ViewResolver.class);
	
	public static void viewResolve(String viewName, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		//viewName redirect:으로  시작할경우 redirect로 보내고
				//그외는 forward로 보내면됨
				logger.debug("ViewResolover.viewResolve : {}" , viewName);
				if(viewName.startsWith("redirect:")){
					//redirect:/main.jsp 우리가 필요한건 /main.jsp 를 구하기위한 작업
					response.sendRedirect(viewName.substring("redirect:".length()));
				}else{
					request.getRequestDispatcher(viewName).forward(request, response);
				}
	}
}
