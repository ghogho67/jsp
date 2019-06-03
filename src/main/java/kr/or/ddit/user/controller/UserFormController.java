package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.utill.PartUtill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/userForm")
@MultipartConfig(maxFileSize= 1024*1024*3, maxRequestSize = 1024*1024*15)
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
			userVo = new UserVo(userId,name,alias,pass,addr1,addr2,zipcd, sdf.parse(birth) ,"" ,"");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//사용자가 입력한 userid 가 이미 존재하는 userId인지 체크
		UserVo dbUser = userService.getUser(userId);
		
		//등록된 사용가 아닌경우 --> 정상입력이 가능한 상황
		if(dbUser == null){
			// profile 파일 업로드 처리
			Part profile = request.getPart("profile");
			
			// 사용자가 파일을 업로드한 경우
			if(profile.getSize() > 0){
				// 실제 파일명
				String contentDisposition = profile.getHeader("content-disposition");
				String fileName = PartUtill.getFileName(contentDisposition);
				String ext = PartUtill.getExt(fileName);
				
				String uploadpath = PartUtill.getUploadPath();
				File uploadFolder = new File(uploadpath);
				String filePath = uploadpath + File.separator + UUID.randomUUID().toString() + ext;
				
				if(uploadFolder.exists()){
					// 파일 디스크에 쓰기
					// UUID.randomUUID().toString() ==> 중복되지 않은 값, 랜덤
					// c3efe11d-8d00-41be-b41b-7222c7b770dc
					profile.write(filePath);
					profile.delete(); // 임시파일 지우기
				}
				
					userVo.setPath(filePath);
					userVo.setFilename(fileName);
			}else{
				String path = "D:\\A_TeachingMaterial\\5.JQuery\\images\\back051.jpg";
//				UserVo vo = new UserVo();
//				vo.setPath(path);
//				vo.setFilename("back051");
				
				userVo.setPath(path);
				userVo.setPath("back051");
				
			}
				
			// - userService 객체를 통해 insertUser(userVo);
			int insertCnt = userService.insertUser(userVo);
			
			// 		정상적으로 입력이 된 경우
			if(insertCnt == 1){
				//			사용자 페이징 리스트 1페이지로 이동
				response.sendRedirect(request.getContextPath() + "/userPagingList");
			
			}
			// 		정상적으로 입력되지 않은 경우
			//			사용자 등록페이지로 이동, 사용자가 입력한 값을 input에 넣어준다

			
		// 존재할 경우 (아이디 중복)
		} else {
			// - 사용자 등록페이지로 이동, 사용자가 입력한 값을 input에 넣어준다
			// - 이미 존재하는 userId입니다 (alert or text 표시)
			request.setAttribute("msg", "이미 존재하는 사용자 입니다.");
			doGet(request, response);
		}
	}
}

//		if(dbUser == null){
//			//profile 파일 업로드 처리
//			Part profile = request.getPart("profile");
//			
//			//사용자가 파일을 업로드 한경울
//			if(profile.getSize()>0){
//				//실제 파일명
//				String contentDisposition = profile.getHeader("content-disposition");
//				String filename = PartUtill.getFileName(contentDisposition);
//				String ext = PartUtill.getExt(fileName);
//				//년도에 해당하는 폴더가 있는지, 년도안에 월에 해당하는 폴더가있는지 
//				Date dt = new Date();
//				SimpleDateFormat yyyyMmSdf = new SimpleDateFormat("yyyyMM"); 
//				String yyyyMm = yyyyMmSdf.format(dt);
//				String yyyy = yyyyMm.substring(0,4);
//				String mm= yyyyMm.substring(4);
//				
//				
//				
//				File yyyyFolder = new File("d:\\upload\\"+ yyyy);
//				//신규년도로 넘어 갔을때 해당 년도의 폴더를 생성한다.
//				if(!yyyyFolder.exists()){
//					yyyyFolder.mkdir();
//				}
//				//월에 해당하는 폴더가 있는지 확인
//				File mmFolder = new File("d:\\upload\\"+ yyyy + "\\" + mm);
//				if(!mmFolder.exists()){
//					mmFolder.mkdir();
//				}
//				
//				String uploadPath = "d:\\upload\\"+ yyyy + File.separator + mm;  // File.separator = \\
//				File uploadFolder = new File(uploadPath);
//				if(uploadFolder.exists()){
//					//파일 디스크에 쓰기 / UUID.randomUUID 이름값을 중복이 안되게 임의의 값으로 출력한다.
//					profile.write( uploadPath +"\\"+ UUID.randomUUID() + ext);  // 경로를 써준다.
//					profile.delete();
//				}
//			}
//			
//			int insertCnt = userService.insertUser(userVo);
//			//정상등록 경우
//			if(insertCnt == 1){
//				response.sendRedirect(request.getContextPath()+"/userPagingList");
//			}
//			// 아이디가 중복될 경우
//			//사용자 아이디가 존재 할 경우
//			// 이미존재하는 userId 입니다. 을 경고창이나, 디자인이 깨져도 좋으니깐 단순 text로 표시해도 된다.
//		}else{
//			//redirect, forward(O)
////			request.getRequestDispatcher("/userForm").forward(request, response);
//			request.setAttribute("msg", "이미 존재하는 사용자입니다.");
//			doGet(request,response); // do Get으로 보내준다.
//		}
//		
//		
//		
//		
//		
//		//사용자 아이디가 존재 하지 않을 경우 
//		
//		//userService 객체를 통해서 insertUser(UserVo userVo);
//		
//		//정상적으로 입력이 된경우
//		// 사용자 페이징 리스트 1페이지로 이동
//		
//		
//		//정상적으로 입력되지 않은 경우
//		//사용자 등록페이지로 이동하는데 사용자가 입력한 값을 input에 넣어준다.
//	
//	
//	
//	}
//	
//}
