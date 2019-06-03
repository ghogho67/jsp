package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/userForm")
public class UserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static final Logger logger = LoggerFactory
			.getLogger(UserFormController.class);
       
       private IUserService userService;
       
       
       
		@Override
	public void init() throws ServletException {
    	   userService = new UserService();
    }


	//사용자 등록 화면 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 등록 화면 으로 이동
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
	}
	
	
		// 사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("UserForm doPost");
		request.setCharacterEncoding("UTF-8");
		
		//사용자가 보낸 파라미터를 사용해서 userVo 인스턴스를 만들어서 
		String userId = request.getParameter("userId");
		String name   = request.getParameter("name");
		String alias  = request.getParameter("alias");
		String addr1  = request.getParameter("addr1");
		String addr2  = request.getParameter("addr2");
		String zipcd  = request.getParameter("zipcd");
		String birth  = request.getParameter("birth");
		String pass   = request.getParameter("pass");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		sdf.parse(birth)
//		sdf.format(birth);
		
		
		UserVo userVo = null;
		try {
			userVo = new UserVo(userId,name,alias,pass,addr1,addr2,zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//사용자가 입력한 userid 가 이미 존재하는 userId인지 체크
		UserVo dbUser = userService.getUser(userId);
		
		//등록된 사용가 아닌경우 --> 정상입력이 가능한 상황
		if(dbUser == null){
			int insertCnt = userService.insertUser(userVo);
			//정상등록 경우
			if(insertCnt == 1){
				response.sendRedirect(request.getContextPath()+"/userPagingList");
			}
			// 아이디가 중복될 경우
			//사용자 아이디가 존재 할 경우
			// 이미존재하는 userId 입니다. 을 경고창이나, 디자인이 깨져도 좋으니깐 단순 text로 표시해도 된다.
		}else{
			//redirect, forward(O)
//			request.getRequestDispatcher("/userForm").forward(request, response);
			request.setAttribute("msg", "이미 존재하는 사용자입니다.");
			doGet(request,response); // do Get으로 보내준다.
		}
		
		
		
		
		
		//사용자 아이디가 존재 하지 않을 경우 
		
		//userService 객체를 통해서 insertUser(UserVo userVo);
		
		//정상적으로 입력이 된경우
		// 사용자 페이징 리스트 1페이지로 이동
		
		
		//정상적으로 입력되지 않은 경우
		//사용자 등록페이지로 이동하는데 사용자가 입력한 값을 input에 넣어준다.
	
	
	
	}
	
}
