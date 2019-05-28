package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.MyBatisUtill;
import kr.or.ddit.paging.model.PageVo;
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
		
		
		/***When***/
		UserVo vo = userDao.getUser("cony");
		/***Then***/
		logger.debug("Uservo : {}", vo);
	

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
		sqlSession.close();
		return userlist;
	}

	/**
	* Method : getUser
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : 특정 사용자 조회
	*/
	@Override
	public UserVo getUser(String userId) {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		UserVo vo = sqlSession.selectOne("user.getUser", userId);
		sqlSession.close();
		return vo;
	}

	/**
	* Method : userPagingList
	* 작성자 : PC21
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	@Override
	public List<UserVo> userPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("user.userPagingList", pageVo);
		sqlSession.close();
		return userList;
	}
	
	
	/**
	* Method : usersCnt
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체수 조회
	*/
	@Override
	public int usersCnt() {
		 SqlSession sqlSessiont = MyBatisUtill.getSqlSession();
		 int usersCnt = (Integer)sqlSessiont.selectOne("user.usersCnt");
		 sqlSessiont.close();
		 return usersCnt;
	}

	/**
	* Method : lprodPagingList
	* 작성자 : PC21
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : lprod 페이지 리스트 조회
	*/
	@Override
	public List<LprodVo> lprodPagingList(PageVo pageVo) {
		SqlSession sqlsession = MyBatisUtill.getSqlSession();
		List<LprodVo> lprodList = sqlsession.selectList("user.lprodPagingList", pageVo);
		sqlsession.close();
		
		
		return lprodList;
	}

	/**
	* Method : lprodCnt
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체수 조회
	*/
	@Override
	public int lprodCnt() {
		SqlSession sqlsession = MyBatisUtill.getSqlSession();
		int lprodCnt = sqlsession.selectOne("user.lprodCnt");
		sqlsession.close();
		
		return lprodCnt;
	}
	
	public List<LprodVo> lprodAllList(){
		SqlSession sqlsession = MyBatisUtill.getSqlSession();
		List<LprodVo> lprodList = sqlsession.selectList("user.lprodAllList");
		sqlsession.close();

		return lprodList;
		
	}
}
