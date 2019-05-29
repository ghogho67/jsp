package kr.or.ddit.sumcalculation;

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
 * Servlet implementation class sumCalculation
 */
@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory
			.getLogger(SumCalculation.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/sumInput.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		int a = Integer.parseInt(start);
		int b = Integer.parseInt(end);
		int sumResult = 0;
		for(int i = a; i <= b; i++){
			sumResult += i;
			
		}
		logger.debug("start 와 end 의 사이의 합산은 = " + sumResult);
		
		request.getSession().setAttribute("sumResult", sumResult);
		request.getRequestDispatcher(request.getContextPath()+"/jsp/sumResult.jsp").forward(request, response);
		
		
	}

}
