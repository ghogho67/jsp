package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.mybatis.MyBatisUtill;
import kr.or.ddit.paging.model.PageVo;
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
	
	
	/**
	* Method : userPagingList
	* 작성자 : PC21
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : userList 와 userCnt 를 같이 보낼수있게 했다.
	*/
	public Map<String, Object> userPagingList(PageVo pageVo);
	
	
	
	/**
	* Method : lprodPagingList
	* 작성자 : PC21
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : lprodList 와 lprodCnt 를 같이 보낼수 있게 했다.
	*/
	public Map<String,Object> lprodPagingList(PageVo pageVo);
	
	
	
}
