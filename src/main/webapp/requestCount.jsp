<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- apllication(getServletContext()) :requestMap  --%>
	<table border="2">
		<tr>
			
				<th>uri</th>
				<th>요청횟수</th>
				
			<c:forEach items="${requestMap }" var="request" >
				<tr>
				<td>${request.key}</td>
				<td>${request.value}</td>
				</tr>	
			</c:forEach>
		</tr>
	</table>
	

</body>
</html>