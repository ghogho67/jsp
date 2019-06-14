package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DefaultPramWrapper extends HttpServletRequestWrapper{
	
	private Map<String, String[]> paramMap; // String배열인 이유는 리턴값이 배열이다.
	
	public DefaultPramWrapper(HttpServletRequest request) {
		super(request);
		paramMap = new HashMap<String, String[]>(request.getParameterMap());
		
	}
	//파라미터를 받는 4종류 이다.
	@Override
	public String getParameter(String name) {
		String[] values = paramMap.get(name);
		return values == null ? null : values[0];
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return paramMap;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(paramMap.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		return paramMap.get(name);
	}
	
	public void setParameter(String name, String[] value){
		paramMap.put(name, value);
	}

}
