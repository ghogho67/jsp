package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

import org.w3c.dom.ls.LSInput;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/userList")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService;
       
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//중프 했던 과정
		//controller -> service -> dao
		
		//db에서 데이터를 조회했다고 가정 하고
		
		
		//userList객체를 userList.jsp에서 참고할 수 있도록 request객체에 속성으로 넣어준다
		request.setAttribute("userList",userService.userList());
		
		//userList객체를 이용하여 사용자 화면 생성하는 jsp
		request.getRequestDispatcher("/user/userList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
