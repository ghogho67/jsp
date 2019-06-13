package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtill;
import kr.or.ddit.prod.model.ProdVo;

public class ProdDao implements IProdDao {

	@Override
	public List<ProdVo> selectProd(String prod_lgu) {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		List<ProdVo> prodList = sqlSession.selectList("prod.selectprod",prod_lgu); 
		sqlSession.close();
		
		return prodList;
	}

}
