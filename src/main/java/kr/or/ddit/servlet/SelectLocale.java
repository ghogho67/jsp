package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class SelectLocale
 */
@WebServlet("/selectLocale")
public class SelectLocale extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(SelectLocale.class);
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String setLocale = optionVal == null ? "ko" : optionVal;
//		request.setAttribute("setLocale", setLocale);
//		request.getRequestDispatcher("/jstl/selectLocale.jsp").forward(request, response);
		
		doPost(request,response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String optionVal = request.getParameter("optionVal");
		logger.debug("optionVal:{}",optionVal);
		
		String setLocale = optionVal == null ? "ko" : optionVal;
		
		request.setAttribute("setLocale", setLocale);
		request.getRequestDispatcher("/jstl/selectLocale.jsp").forward(request, response);
	}

}
