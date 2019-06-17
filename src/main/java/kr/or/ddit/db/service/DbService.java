package kr.or.ddit.db.service;

import java.util.List;

import kr.or.ddit.db.dao.DbVoDao;
import kr.or.ddit.db.dao.IDbDao;
import kr.or.ddit.db.dbvo.DbVo;

public class DbService implements IDbService {
	private IDbDao dao;
	
	

	public DbService() {
		dao = new DbVoDao();
	}



	@Override
	public List<DbVo> dbVoList() {
		return dao.dbVoList();
	}

}
