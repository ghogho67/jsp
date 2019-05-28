package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;


public class UserService implements IUserService{
	private IuserDao dao;
	
	public UserService() {
		dao = new UserDao();
	}
	
	/**
	* Method : userList
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	@Override
	public List<UserVo> userList() {
		
	
		List<UserVo> userList = dao.userList(); 
		
		return userList;
	}

	@Override
	public UserVo getUser(String userId) {
		
		UserVo vo = dao.getUser(userId);
		
		return vo;
	}

	@Override
	public Map<String, Object> userPagingList(PageVo pageVo) {
		//1. List<UserVo>, userCnt 를 필도로 하는 vo
		//2. List<Object> resultList = new AraagyList<Object>();
		
		// resultList.add(userList);
		// resultList.add(usersCnt);
		
		//3. Map<string, Object> resultMap = new HashMap<String, Object>();
		// resultMap.put("userList", userList);
		// resultMap.put("userLIst", userCnt);
		
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", dao.userPagingList(pageVo));// 10개씩 갖고오는거고 지금은 105개라서 11번을 갖고와야된다.
		
		//usersCnt 대신에 --> paginationSize 으로 변경 그냥 여기서 연산해서 보내준다.
		int usersCnt = dao.usersCnt();
		//pageSize --> pageVo.getpageSize();
		int paginationSize = (int)Math.ceil((double)usersCnt/pageVo.getPageSize());
		
		
		resultMap.put("paginationSize", paginationSize); //전체 갯수를 갖고오는거고
		
		return resultMap;
	}

	@Override
	public Map<String, Object> lprodPagingList(PageVo pageVo) {
		int lprodCnt = dao.lprodCnt();
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lprodList", dao.lprodPagingList(pageVo));
		resultMap.put("lprodAllList", dao.lprodAllList());
		
		int pagenationSize = (int)Math.ceil((double)lprodCnt/pageVo.getPageSize());
		
		resultMap.put("lprodPagenationSize", pagenationSize);
		
		return resultMap;
	}




}
