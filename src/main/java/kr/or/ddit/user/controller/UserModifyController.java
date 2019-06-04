package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.utill.PartUtill;

/**
 * Servlet implementation class UserModifyController
 */
@WebServlet("/modify")
@MultipartConfig(maxFileSize = 1024*1024*3, maxRequestSize = 1024*1024*15)
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
		
		//현재는 사용자가 보낸 평문 비밀번호 데이터
		String pass   = request.getParameter("pass");
		//암호화 하는 방법
		pass = KISA_SHA256.encrypt(pass);
		
		Part profile = request.getPart("profile");
		
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = null;
		
		try {
			userVo = new UserVo(userId,name,alias,pass,addr1,addr2,zipcd, sdf.parse(birth)/*, path, filename*/);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(profile.getSize() > 0){
			String contentDisposition = profile.getHeader("content-disposition");
			String fileName = PartUtill.getFileName(contentDisposition);
			String ext = PartUtill.getExt(fileName);
			
			String uploadpath = PartUtill.getUploadPath();
			File uploadFolder = new File(uploadpath);
			String filePath = uploadpath + File.separator + UUID.randomUUID().toString() + ext;
			
			if(uploadFolder.exists()){
				profile.write(filePath);
				profile.delete(); // 임시파일 지우기
			}
			
			userVo.setPath(filePath);
			userVo.setFilename(fileName);
		
		}else{	
			UserVo vo = userService.getUser(userId);
			userVo.setPath(vo.getPath());
			userVo.setFilename(vo.getFilename());
			
		}
		int updateCnt = userService.updateUser(userVo);
		logger.debug("update : {}",updateCnt);
		if(updateCnt == 1){
		
			request.setAttribute("userVo", userVo);
			request.getRequestDispatcher("/user/user.jsp").forward(request, response);
		}
			
		
			
	
	}
}
