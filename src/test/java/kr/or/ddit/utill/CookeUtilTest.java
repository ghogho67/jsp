package kr.or.ddit.utill;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class CookeUtilTest {

	/**
	* Method : getCookieTest
	* 작성자 : PC21
	* 변경이력 :
	* Method 설명 : getCookieTest
	*/
	@Test
	public void getCookieTest() {
		/***Given***/
		String cookieString = "userId=brown; remember=true; test=testValue";
		CookieUtil.setCookiesstring(cookieString);

		/***When***/
		String cookieValue = CookieUtil.getCookie("userId");
		String cookieValue1 = CookieUtil.getCookie("remember");
		String cookieValue2 = CookieUtil.getCookie("test");
		String cookieValue3 = CookieUtil.getCookie("test123123");
		String cookieValue4 = CookieUtil.getCookie("userI");

		/***Then***/
		assertEquals("brown", cookieValue);
		assertEquals("true", cookieValue1);
		assertEquals("testValue", cookieValue2);
		assertEquals("", cookieValue3);
		assertEquals("", cookieValue4);

	}

}
