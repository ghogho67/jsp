package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceTest {
	
	private IUserService userService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceTest.class);
	
	@Before
	public void setup(){
		userService = new UserService();
	}
	
//	@Test
//	public void test() {
//
//		/***Given***/
//		IUserService userService = new UserService();
//		
//
//		/***When***/
//		
//		List<UserVo> userList =  userService.userList();
//		
//		/***Then***/
//		assertEquals("brown", userList.get(0).getUserId());
//		assertEquals(5, userList.size());
//		logger.debug("userList : {}" , userList);
//		logger.debug("userList.get(0) : {}", userList.get(0));
//	
//	}
//	
	@Test
	public void getUserTest(){
		/***Given***/
		String userId = "cony";
		/***When***/
		UserVo vo = userService.getUser(userId);

		/***Then***/
		assertEquals("cony", vo.getUserId());
		assertEquals("토끼", vo.getAlias());
		assertEquals("코니", vo.getName());
		logger.debug("vo.getUserId() : {}" ,  vo.getUserId());
		logger.debug("vo.getAlais() : {}" ,  vo.getAlias());
		logger.debug("vo.getName() : {}" , vo.getName());
	}
	
	//테스트 코드 부터 만들고 하는 방법
	/*
	 * 사용자 전체리스트를 조회 하는메소드
	 * 1.메소드 인자가 필요한가? 별다른 이자는 불필요 x
	 * 2.리턴 타입은 뭐가 될까? List(UserVo)
	 * 3.메소드 이름은 뭐가 적당하지? userList
	 */

	@Test
	public void userListTest(){
		/***Given***/

		/***When***/
		List<UserVo> userList = userService.userList();

		/***Then***/
		assertEquals(105, userList.size());

	}
	
	/**
	* Method : userPagingList
	* 작성자 : PC21
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	*/
	@Test
	public void userPagingList(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);

		/***When***/
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		/***Then***/
		//pagingList assert
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
		//usersCnt assert
		assertEquals(11, paginationSize);
	}
	
	@Test
	public void ceilTest(){
		/***Given***/
		int usersCnt = 105;
		int pageSize = 10;

		/***When***/
		double paginationSize = Math.ceil((double)usersCnt/pageSize);
		logger.debug("pagination : {}" , paginationSize);
		/***Then***/
		assertEquals(11, (int)paginationSize);
	}
	
	/**
	* Method : InsertUserTest
	* 작성자 : PC21
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	*/
	@Test
	public void InsertUserTest(){
		/***Given***/
		//사용자 담고 있는 vo 객체 준비
		
		UserVo vo = new UserVo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
	     vo.setUserId("userTest");
		 vo.setAlias("대덕인");
		 vo.setName("대덕");
		 vo.setAddr1("대전광역시 중구 중앙로76");
		 vo.setAddr2("영민빌딩 2층 204호");
		 vo.setZipcd("12345");
		 try {
			vo.setBirth(sdf.parse("2019-05-03"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 vo.setPass("userTest1234");
		

		/***When***/
		//userDao.insertUser()
		 
		 int insertCnt = userService.insertUser(vo);

		/***Then***/
		 assertEquals(1, insertCnt);
		//insertCnt(1)
		 
		 //data 삭제 
		int delete = userService.deleteUser(vo.getUserId());
		 assertEquals(1, delete);
	}
	
	
	@Test
	public void updateUser() {
		/***Given***/
		UserVo vo = new UserVo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
	     vo.setUserId("user2");
		 vo.setAlias("대덕인");
		 vo.setName("대덕");
		 vo.setAddr1("대전광역시 중구 중앙로76");
		 vo.setAddr2("영민빌딩 2층 204호");
		 vo.setZipcd("12345");
		 try {
			vo.setBirth(sdf.parse("2019-05-03"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 vo.setPass("userT1234");
		 /***When***/
		 int update = userService.updateUser(vo);
		 
		 /***Then***/
		 assertEquals(1, update);
	
		
	}
	

	
}
