package kr.or.ddit.dbconnection;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// baiscdatasource  만드는거
@WebServlet(urlPatterns = "/DbConnectionServlet" , loadOnStartup=1)
public class DbConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(DbConnectionServlet.class);
	
	


	
	/**
	* Method : init
	* 작성자 : PC21
	* 변경이력 :
	* @param config
	* @throws ServletException
	* Method 설명 : 어플리케이션과 연결이 가능하다.
	*/
	@Override
	public void init(ServletConfig config) throws ServletException {
//		dbcp.jsp에서 갖고온거임	
		//pom 에 dbcp 추가 후 임폴트 할때 dbcp2 로 추가
		logger.debug("DbConnectionServlet init()");
			//basicDatasource 객체를 생성 --> apllication 객체에 속석으로 저장
			BasicDataSource bs = new BasicDataSource();
			bs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			bs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			bs.setUsername("pc21");
			bs.setPassword("java");
			bs.setInitialSize(20); // connection 값을 초기에 얼마 갖고 시작할지 
			
			
			
			ServletContext application =  config.getServletContext();
			application.setAttribute("bs", bs);
			
	}
	
	

	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.debug("DbConnectionServlet doGet()");
	}

       
	
}
