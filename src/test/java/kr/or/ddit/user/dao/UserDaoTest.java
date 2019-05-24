package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoTest {
	
	private IuserDao userDao;

	
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoTest.class);
	
	
//	junit실행순서
//	@BeforeClass가 적용된 메소드가 최초 1회 실행
//	다음 구간은 @Test가 적용된 모든 메소드에 대한 반복 적용
//	@Before가 적용된 메소드 실행
//	@Test가 적용된 메소드가 실행
//	@After가 적용된 메소드가 실행
//	@AfterClass가 적용된 메소드가 1회실행
	
	@BeforeClass
	public static void beforeClass(){
		logger.debug("beforeClass");
	}
	
	@Before
	public void setup(){
		userDao = new UserDao();
		logger.debug("setup");
	}

	@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterCalss");
	}
	
	
	/**
	* Method : userListTest
	* 작성자 : PC21
	* 변경이력 :
	* Method 설명 : 사용자 전체 조회 테스트
	*/
	@Test //어노테이션 붙은 건 테스트 인걸 확인한다.
	public void userListTest() {
		
		/***Given***/
		

		/***When***/
		List<UserVo> userList = userDao.userList();
		
		/***Then***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size()); 
		logger.debug("userList : {}", userList);

		
	}
	
	/**
	* Method : getUserTest
	* 작성자 : PC21
	* 변경이력 :
	* Method 설명 : 사용자 조회 테스트
	*/
	@Test//test 메소드는 public void 라고 꼭 쓰고 메서드에 참조변수가 있으면 안된다.
	public void getUserTest(){
		/***Given***/
		String userId = "brown";
		/***When***/
		UserVo vo = userDao.getUser(userId);

		/***Then***/
		assertEquals(userId, vo.getUserId());
		logger.debug("vo : {}", vo);

	}
	
	//사용자 페이징 리스트 조회
	//고려사항
	//볓번째 페이지 조회인지? , 페이징 몇건씩 데이터를 보여줄것인지?
	//정렬 순서를 무엇으로 할지 생각해봐야되요 --> 로직 -->파라미터화 시킬수 있
	//--> 우리는 사용자 아이디 순으로 정렬
	
	

}
