package kr.or.ddit.db.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import kr.or.ddit.db.dbvo.DbVo;
import kr.or.ddit.mybatis.MyBatisUtill;

public class DbVoDao implements IDbDao {

	@Override
	public List<DbVo> dbVoList() {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		List<DbVo> dbVoList = sqlSession.selectList("DbVo.selectDbVo");
		
		return dbVoList;
	}
	
}
