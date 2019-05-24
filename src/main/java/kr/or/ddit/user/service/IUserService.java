package kr.or.ddit.user.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtill;
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
	
	/**
	* Method : getUser
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	*/
	UserVo getUser(String userId);
	
	
	
}
