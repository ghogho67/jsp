package kr.or.ddit.lprod.controller;

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

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class LprodPagingList
 */
@WebServlet("/lprodPagingList")
public class LprodPagingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUserService userSevice;
	private static final Logger logger = LoggerFactory
			.getLogger(LprodPagingList.class);
       

	@Override
	public void init() throws ServletException {
		userSevice = new UserService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		
		int pageInt = page == null ? 1 : Integer.parseInt(page);
		int pageSizeInt = pageSize == null ? 5 : Integer.parseInt(pageSize);
		PageVo pageVo = new PageVo(pageInt, pageSizeInt);
		
		Map<String, Object> resultMap = userSevice.lprodPagingList(pageVo);
		
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("lprodList");
		int lprodPagenationSize = (Integer) resultMap.get("lprodPagenationSize");
		List<LprodVo> lprodAllList = (List<LprodVo>) resultMap.get("lprodAllList");
		
		
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("lprodPagenationSize", lprodPagenationSize);
		request.setAttribute("pageVo", pageVo);
		request.setAttribute("lprodAllList",lprodAllList);
		
		request.getRequestDispatcher("/user/lprodList.jsp").forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
