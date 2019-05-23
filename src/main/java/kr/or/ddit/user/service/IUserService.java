package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVo;


public interface IUserService {
	
	/**
	* Method : userList
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	public List<UserVo> userList();
}
