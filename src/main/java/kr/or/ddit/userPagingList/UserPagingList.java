package kr.or.ddit.userPagingList;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class UserPagingList
 */
@WebServlet("/userPagingList")
public class UserPagingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService;
	private static final Logger logger = LoggerFactory
			.getLogger(UserPagingList.class);
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//page, pageSize 파리미터 받기
		//page, pageSize 파라미터가 없는  경우 page=1,page=10  기본값설정
		
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
//		PageVo pagevo = new PageVo();
//		if(page == null && pageSize ==null){
//			pagevo.setPage(1);
//			pagevo.setPageSize(10);
//		}else{
//			pagevo.setPage(Integer.parseInt(page));
//			pagevo.setPageSize(Integer.parseInt(pageSize));
//		}
		//3항 연산자
		int pageInt = page == null ? 1 : Integer.parseInt(page);
		int pageSizeInt = pageSize == null ? 10 : Integer.parseInt(pageSize);
		
		//page, pageSize 파라미터를 이용하여 pageVo 작성
		PageVo pagevo = new PageVo(pageInt, pageSizeInt);
		
		//pageVo를 이용한 사용자 페이징 리스트 조회
		Map<String,Object> resultMap = userService.userPagingList(pagevo);
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		//request scope에 사용자 리스를 공유할 수 있도록 속성 설정
		request.setAttribute("userList", userList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pagevo);
		
		
//		List<UserVo> vo = userService.userPagingList(pagevo);
//		request.setAttribute("userList", pagevo);
	    
	    request.getRequestDispatcher("/user/userPagingList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
