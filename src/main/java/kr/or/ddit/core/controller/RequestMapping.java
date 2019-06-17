package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.db.dbvo.DbVo;
import kr.or.ddit.db.service.DbService;
import kr.or.ddit.db.service.IDbService;

public class RequestMapping  {
	//main.do 로 요청이오면 ->MainController 로 넘어오게되고
	//userList.do  -> 요청이오면 UserListController
	// 그리하여 이건 맵형태가 좋을꺼같다. 
	// 키값에 컨트롤러를 넣어준다.
	
//	private static Map<String, String> requestMappingClass;
	private static Map<String, Controller> requestMapping;
	
	private static IDbService dbService = new DbService();

	private static final Logger logger = LoggerFactory
			.getLogger(RequestMapping.class);
	
	static{
//		requestMapping = new HashMap<String, Controller>();
		/* 이것은 간단하게 map 으로 한것
		 requestMappingClass 이것은 /main.do 가 실행되면 클래스를 만들어 주기위한 단계
		requestMappingClass = new HashMap<String, String>();
		requestMappingClass.put("/main.do", "kr.or.ddit.controller.MainController");
		
		requestMapping = new HashMap<String , Controller>();
		for(String key : requestMappingClass.keySet()){ // 키값은 uri를 뜻하고 
			//classInfo : "kr.or.ddit.controller.MainController" 와 같다.
			String classInfo = requestMappingClass.get(key);
			try {
				Class clazz = Class.forName(classInfo);
				Object obj = clazz.newInstance();
				requestMapping.put(key, (Controller)obj);
				
			} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
		}
		*/
		
		// db를 통한 uri 갖고오기(일반 for문)
		/*
		requestMapping = new HashMap<String, Controller>();
		List<DbVo> uriClassMappingList = dbService.dbVoList();
		for(int i = 0; i < uriClassMappingList.size(); i++){
			String classInfo = uriClassMappingList.get(i).getClassname();
			Class clazz;
			Object obj = null;
			try {
				clazz = Class.forName(classInfo);
				obj = clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String key = uriClassMappingList.get(i).getUri();
			requestMapping.put(key, (Controller)obj);
			
		}
		*/
		
		// db를 통한 uri 갖고오기(향상 for문)
		requestMapping = new HashMap<String, Controller>();
		List<DbVo> uriClassMappingList = dbService.dbVoList();
		for(DbVo dbVo : uriClassMappingList){ // 키값은 uri를 뜻하고 
			//classInfo : "kr.or.ddit.controller.MainController" 와 같다.
			String classInfo = dbVo.getClassname();
			try {
				Class clazz = Class.forName(classInfo);
				Object obj = clazz.newInstance();
				requestMapping.put(dbVo.getUri(), (Controller)obj);
				
			} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
		}
		
		
		
		
		// 밑에 3개는 main.do 같이 들어왔을때 컨트롤러로 보내서 거기서 일을 처리한다.
//		requestMapping = new HashMap<String , Controller>();
//		requestMapping.put("/main.do", new MainController());
//		requestMapping.put("/userList.do", new UserListController());
	}

	public static Controller getController(String uri) {
		logger.debug("getController : {}" , uri);
		return requestMapping.get(uri);
	}
	
}
