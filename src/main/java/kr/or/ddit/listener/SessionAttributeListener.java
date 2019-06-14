package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import kr.or.ddit.user.model.UserVo;

public class SessionAttributeListener implements HttpSessionAttributeListener {
	
	private Map<String, UserVo> sessionUserMap = new HashMap<String, UserVo>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) { //세션에 속성이 추가됬을때 발생하는 이벤트
		event.getSession().getServletContext().setAttribute("sessionUserMap", sessionUserMap);
		//속성명(event.getName())
		if("USER_INFO".equals(event.getName())){ // 체크할려는 속성을 맵에 넣어준다.
			sessionUserMap.put(event.getSession().getId(), (UserVo)event.getValue()); //j세션에 아이디를 갖고와서 키값으로주고 이벤트의 값을 넣어준다. 
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) { // 값이 없어질떄
		//속성명(event.getName())
		if("USER_INFO".equals(event.getName())){ // 체크할려는 속성을 맵에 넣어준다.
			sessionUserMap.remove(event.getSession().getId()); //값을 없애 준다.
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}

}
