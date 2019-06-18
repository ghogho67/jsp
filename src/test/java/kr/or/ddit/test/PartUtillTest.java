package kr.or.ddit.test;

import static org.junit.Assert.*;

import java.util.UUID;

import kr.or.ddit.utill.PartUtill;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtillTest {
	private static final Logger logger = LoggerFactory
			.getLogger(PartUtillTest.class);
	@Test
	public void test() {
		/***Given***/
		String contentDisposition = "form-data; name=\"profile\"; filename=\"sally.png";

		/***When***/
		String fileName = PartUtill.getFileName(contentDisposition);

		/***Then***/
		assertEquals("sally.png", fileName);
		
	}
	
	//uuid test
	@Test
	public void uuidTest(){
		/***Given***/
		

		/***When***/
		//이름 이름이나온다 UUID 랜덤으로 하면 87751942-ecc7-4102-9590-498e86d82ed1
		logger.debug("UUID.randomUUID().toString() : {}" , UUID.randomUUID().toString());
		/***Then***/

	}
	
	
	//
	@Test
	public void getextTest(){
		/***Given***/
		String fileName = "sally.png";
		String filename2 = "sally.picture.png";
		String filename3 = "sally";

		/***When***/
		
		String ext = PartUtill.getExt(fileName);
		String ext2 = PartUtill.getExt(filename2);
		String ext3 = PartUtill.getExt(filename3);
		

		/***Then***/
		assertEquals(".png", ext);
		assertEquals(".png", ext2);
		assertEquals("", ext3);

	}
	
	
	@Test
	public void subStringTest(){
		/***Given***/
		String yyMm = "201006";
		

		/***When***/
		String a = yyMm.substring(0, 4);
		String b = yyMm.substring(4);
		/***Then***/
		assertEquals("2010", a);
		assertEquals("06", b);
		
		
	}
	

}
