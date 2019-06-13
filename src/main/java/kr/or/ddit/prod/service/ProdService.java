package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.model.ProdVo;

public class ProdService implements IProdService {
	
	private IProdDao dao;
	
	
	
	public ProdService() {
		dao = new ProdDao();
	}



	@Override
	public List<ProdVo> selectProd(String prod_lgu) {
		return dao.selectProd(prod_lgu);
	}
	
}
