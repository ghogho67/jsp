package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.or.ddit.user.dao.IuserDao;
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
		assertEquals("토끼", vo.getAlais());
		assertEquals("코니", vo.getName());
		logger.debug("vo.getUserId() : {}" ,  vo.getUserId());
		logger.debug("vo.getAlais() : {}" ,  vo.getAlais());
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
	
}
