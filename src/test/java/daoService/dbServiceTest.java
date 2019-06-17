package daoService;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.dbvo.DbVo;
import kr.or.ddit.db.service.DbService;
import kr.or.ddit.db.service.IDbService;

import org.junit.Test;

public class dbServiceTest {

	@Test
	public void test() {
		/***Given***/
		IDbService dbservice = new DbService();

		/***When***/
		List<DbVo> dbList = dbservice.dbVoList();

		/***Then***/
		assertEquals(2, dbList.size());

	}

}
