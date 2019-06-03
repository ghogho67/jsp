package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class UserModifyController
 */
@WebServlet("/modify")
public class UserModifyController extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(UserModifyController.class);
	private static final long serialVersionUID = 1L;
	
	private IUserService userService;
	
	
@Override
	public void init() throws ServletException {
		userService = new UserService();
		
		
    }
	//       화면 요청 받는거임
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userId");
		UserVo uservo = userService.getUser(userid);
		request.setAttribute("userVo", uservo);
		logger.debug("userModifycontroller uservo : {}", uservo);
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		logger.debug("제발 연결되라");
		
		
		String userId = request.getParameter("userId");
		String name   = request.getParameter("name");
		String alias  = request.getParameter("alias");
		String addr1  = request.getParameter("addr1");
		String addr2  = request.getParameter("addr2");
		String zipcd  = request.getParameter("zipcd");
		String birth  = request.getParameter("birth");
		String pass   = request.getParameter("pass");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = null;
		
		try {
			userVo = new UserVo(userId,name,alias,pass,addr1,addr2,zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		logger.debug("userVo : {}", userVo);
		
			int updateCnt = userService.updateUser(userVo);
			logger.debug("update : {}",updateCnt);
			if(updateCnt == 1){
				request.getRequestDispatcher("/user/user.jsp");
			}
		}
	

}
