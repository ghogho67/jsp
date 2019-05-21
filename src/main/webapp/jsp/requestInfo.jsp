<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- 스크립트릿 <% %> : 자바 로직을 작성하는 공간 --%>
	<%-- 표현식 <%= %> : 결과물을 출력  --%>
	
	<%
		String msg = "test";
		msg += "_append";
		
		//jsp의 내장객체, 묵시적객체(implict)(이미 선언되었기 때문에 별도의 선언 없이 사용가능한 객체의 하나)
		
	
	%>
	request.getRemoteAddr() : <%= request.getRemoteAddr() %><br>
	request.getLocalAddr() : <%= request.getLocalAddr() %><br>
	request.getContentType() : <%= request.getContentType() %><br>
	request.getContextPath() : <%= request.getContextPath() %><br>
	request.getMethod() : <%= request.getMethod() %><br>
	request.getRequestURI() : <%= request.getRequestURI() %><br>
	request.getProtocol() : <%= request.getProtocol() %><br>
	
	<br>
	이거 두개는 나중에 쓸수도있습니다.<br>
	request.getContextPath() : <%= request.getContextPath() %> 내가 요청한 서버 이름을 물어본다<br>
	request.getRequestURI() : <%= request.getRequestURI() %> 사용자가 어떤 url로 요청을 했는지 <br>
	
	<%-- 서버이름이없을때 쓰는방법 --%>
	<img src="<%= request.getContextPath() %>/image/벌쳐.jpg">
	
	
</body>
</html>