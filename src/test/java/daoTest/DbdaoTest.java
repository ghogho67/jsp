package daoTest;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.dao.DbVoDao;
import kr.or.ddit.db.dao.IDbDao;
import kr.or.ddit.db.dbvo.DbVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbdaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(DbdaoTest.class);
	
	private IDbDao dao;
	
	@Before
	public void setup(){
		dao = new DbVoDao();
		logger.debug("setup");
	}
	
	@Test
	public void selectDbVoList() {
		
		/***Given***/
		

		/***When***/
		List<DbVo> dbVoList = dao.dbVoList();
		logger.debug("dbVoList :{}", dbVoList);
		/***Then***/
		assertEquals(2, dbVoList.size());
	
	}

}
