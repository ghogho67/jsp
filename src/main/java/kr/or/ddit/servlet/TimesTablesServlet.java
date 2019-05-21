package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTablesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html; charset = utf-8 ");
		PrintWriter pw = resp.getWriter();

		
		//localhost/jsp/TimesTables?param=6
//		String param = req.getParameter("param");
		String param = req.getParameter("i");
		System.out.println("param : " + param);
		
		
		//http://localhost/jsp/TimesTables?i=4&j=6
		
//		String param2 = req.getParameter("param2");
		String param2 = req.getParameter("j");
		Integer b =  Integer.parseInt(param2);
		Integer a = Integer.parseInt(param);
		
		
		
		
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("		<title>TimesTablesServlet!</title>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("		<table border = '1'>");

		for (int i = 0; i <= b; i++) {
			
			pw.write("			<tr>" );
			

			for (int j = 2; j <= a; j++) {
				if(i == 0){
					pw.write("			<th>"+ j +"´Ü");
				}else if(i >= 1){
					pw.write("				<td> "+ j +" x "+ i + " = " + j * i + "</td>");
				}
				
			}
			pw.write("			</th>");
		}
		
		pw.write("		</tr>");
		pw.write("		</table>");
		pw.write("	</body>");
		pw.write("</html>");

		pw.close();

	}

}
