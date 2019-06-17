package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Controller  {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/main.jsp";
		
		//기본 ->forward
		//redirect: /main.jsp -> redirect
		
		
		
		
		
		
		
		//이건 이 클래스로 들어왔을때 main.jsp 로 보내라 하는거고
//		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

}
