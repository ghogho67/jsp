package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.mybatis.MyBatisUtill;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;


public class UserService implements IUserService{
	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);
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
	
	
	/**
	* Method : deleteUser
	* 작성자 : PC21
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 등록
	*/
	@Override
	public int insertUser(UserVo vo) {
		return dao.insertUser(vo);
	}

	/**
	* Method : deleteUser
	* 작성자 : PC21
	* 변경이력 :
	* @param userId
	* @return 삭제 건수가 나온다.
	* Method 설명 : 사용자 등록
	*/
	@Override
	public int deleteUser(String userId) {
		return dao.deleteUser(userId);
	}

	/**
	* Method : updateUser
	* 작성자 : PC21
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 사용자 업데이트
	*/
	@Override
	public int updateUser(UserVo vo) {
		return dao.updateUser(vo);
	}
	
	/**
	* Method : encryptPassAllUser
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치
	*/
	
	@Override
	public int encryptPassAllUser() {
		//사용하지마세요!! 이미 암호화가 적용 되었습니다.
		if(1 ==1)
			return 0;
		//트랜잭션을 여기서 관린한다.
		//0.sql 실행에 필요한 sqlSession객체를 생성
		SqlSession sqlSession =MyBatisUtill.getSqlSession();
		
		//1.모든 사용자 정보를 조회(단, 기존 암호화 적용 사용자 제외, sujitasan)
		List<UserVo> userList = dao.userListForPassEncrypt(sqlSession);
		
		//2.조회된 사용자의 비밀번호를 암호화 적용후 사용자 업데이트
		int updateCntSum = 0;
		for(UserVo userVo : userList){
			String encryptPass = KISA_SHA256.encrypt(userVo.getPass());
			userVo.setPass(encryptPass);
			
			int updateCnt = dao.updateUserEncyptPass(sqlSession,userVo);
			updateCntSum += updateCnt;
			
			//비정상
			if(updateCnt != 1){
				sqlSession.rollback();
				break;
			}	
		}
		//3.sqlSession 객체를 commit,close
		sqlSession.commit();
		sqlSession.close();
		return updateCntSum;
	}
	
	public static void main(String[] args) {
		IUserService userService = new UserService();
		int updateCnt = userService.encryptPassAllUser();
		logger.debug("updateCnt : {}" , updateCnt);
	}




}
