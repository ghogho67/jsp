package kr.or.ddit.mulCalculation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class MulCalulation
 */
@WebServlet("/mulCalulation")
public class MulCalulation extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private static final Logger logger = LoggerFactory
			.getLogger(MulCalulation.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/mulInput.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("param1");
		String b = request.getParameter("param2");
		
		int param = Integer.parseInt(a);
		int param2 = Integer.parseInt(b);
		int mulResult = 0;
		
		mulResult = param * param2;
		
		logger.debug("param1 * param2 : {}", mulResult);
//		logger.debug(String.valueOf(mulResult));
		
		
		request.getSession().setAttribute("mulResult", mulResult);
		request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response);
		
		
	}

}
