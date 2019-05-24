package kr.or.ddit.user.service;

import java.util.List;

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


}
