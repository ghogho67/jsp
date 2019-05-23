<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<%
		
		//4가지 파라미터를 받아서, 4개의 영역에 속성으로 넣어준다.
		
		//속성으로 넣는 방법
		//속성 저장 : scope객체.setAttribute("속성명", 속성(객체));
		//scope객체 : pageContext, request, session, apllication
		// 4가지의 영역이 어떻게 다른지 확인할려고 만든거에요
		pageContext.setAttribute("pageAtrribute", request.getParameter("pageParam"));
		request.setAttribute("requestAtrribute", request.getParameter("requestParam"));
		session.setAttribute("sessionAtrribute", request.getParameter("sessionParam"));
		application.setAttribute("applicationAtrribute", request.getParameter("applicationParam"));
		
		request.getRequestDispatcher("/scope/scopePrint.jsp").forward(request, response);
		
		
	%>

