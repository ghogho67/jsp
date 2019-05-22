<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 클라이언트의 요청을 받는다. -->
	<%
		//sendRedirect 메소드 인자 값을 웹브라우저가 수신한 후,
		//주소줄에 그대로 붙여 넣는다.
		System.out.println("userId parameter : " + request.getParameter("userId"));
		response.sendRedirect(request.getContextPath()+"/jsp/redirectTarget.jsp?userId=brown");
		//이것이 jsp/jsp/redirectTarget.jsp 가된다.
	%>

</body>
</html>