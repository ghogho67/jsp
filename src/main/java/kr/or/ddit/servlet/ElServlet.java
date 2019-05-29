package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ElServlet
 */
@WebServlet("/el")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		//3가지 scope 객체에 같은 이름의 속성명으로 다른 값을 설정
				request.setAttribute("userId", "brown_request"); //애는 request에 바로 담겻고
				request.getSession().setAttribute("userId", "cony_session"); // 애는 session에 담겻고
				
				//application 객체에 넣어줄꺼임 근데 application 객체는 context 에서 받을수 있다 그래서 서블릿에서 getServletContext 로 만든다
				getServletContext().setAttribute("userId", "sally_application"); // 애는 context에 담겻고
				
				
				//각영역의 속성을 출력하기 위해 출력을 담당하는 el.jsp로 forword
				request.getRequestDispatcher("/el/el.jsp").forward(request, response);
				
				
				//el로 객체를 찾으면 request --> session --> application 순으로 찾는다 영역이 작은데서 부터 찾아서 순서대로 올라온다.
	}

		
		
		
		
		

}
