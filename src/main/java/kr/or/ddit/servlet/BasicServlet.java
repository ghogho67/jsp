package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

public class BasicServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
				
		resp.setContentType("text/html; charset = utf-8 ");
		PrintWriter pw = resp.getWriter();
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("		<title>hello, world!</title>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("		<span>hello, world!<span>");
		pw.write("	</body>");
		pw.write("</html>");
		
		pw.close();
		
		
		
		

		
		
	}
	
	/*
	 *  alt + shift + s  -> v 오버라이트 하는거에 있는 
	 *  init 메소드
	 * */
	
	@Override
	public void init() throws ServletException {
		System.out.println("BasicServlet init()");
	}
	
	
	
}
