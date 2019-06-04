package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IuserDao {

	//인터페이스에는 접근자를 작성하지 않는다.
	/**
	* Method : userList
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	*/
	List<UserVo> userList();
	
	/**
	* Method : getUser
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : 특정 사용자 조회
	*/
	UserVo getUser(String userId);
	
	
	/**
	* Method : userPagingList
	* 작성자 : PC21
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이지 리스트 조회
	*/
	List<UserVo> userPagingList(PageVo pageVo);
	
	/**
	* Method : usersCnt
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체수 조회
	*/
	int usersCnt();
	
	
	/**
	* Method : insertUser
	* 작성자 : PC21
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자등록
	*/
	int insertUser(UserVo userVo);
	
	
	
	/**
	* Method : deleteUser
	* 작성자 : PC21
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	*/
	int deleteUser(String userId);
	
	
	
	/**
	* Method : updateUser
	* 작성자 : PC21
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 수정
	*/
	int updateUser(UserVo userVo);
	
	
	
	
	
	/**
	* Method : lprodPagingList
	* 작성자 : PC21
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : lprod 페이지 리스트 조회
	*/
	List<LprodVo> lprodPagingList(PageVo pageVo);
	
	/**
	* Method : lprodCnt
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체수 조회
 	*/
	int lprodCnt();
	
	/**
	* Method : getlprodAll
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체 갖고오기
	*/
	List<LprodVo> lprodAllList();

	/**
	* Method : userListForPassEncrypt
	* 작성자 : PC21
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 비밀번호 암호화 적용대상 사용자 전체 조회
	*/
	List<UserVo> userListForPassEncrypt(SqlSession sqlSession);

	/**
	* Method : updateUserEncyptPass
	* 작성자 : PC21
	* 변경이력 :
	* @param sqlSession
	* @param userVo
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 적용
	*/
	int updateUserEncyptPass(SqlSession sqlSession, UserVo userVo);
	
}
