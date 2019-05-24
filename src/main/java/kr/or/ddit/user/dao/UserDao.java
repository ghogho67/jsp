package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.mybatis.MyBatisUtill;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao implements IuserDao {
	private static final Logger logger = LoggerFactory
			.getLogger(UserDao.class);
	public static void main(String[] args) {
		//alt + shift + x
		//gwt +컨트롤 +스페이스바 기본적인 환경을 작성한다.
		/***Given***/
		IuserDao userDao = new UserDao();

		/***When***/
		List<UserVo> userList = userDao.userList();
		/***Then***/
		logger.debug("userList : {}", userList);
	

	}

	/**
	* Method : userList
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	*/
	@Override
	public List<UserVo> userList() {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		List<UserVo> userlist = sqlSession.selectList("user.userList");
		
		return userlist;
	}
}
