package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowDate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			PrintWriter pw = resp.getWriter();
			pw.write((new Date().toString()));
			pw.close();
			
//			SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd hh:mm");
//			dt.write(sd.format(date));
//			dt.close();
			
		
	}
	
}