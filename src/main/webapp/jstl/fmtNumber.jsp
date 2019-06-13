<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>formatNumber(number -> String / 1000000 ->1,000,000)</h2>
	<%--  test할 숫자를 set 해준다 
	pageContext.setAtrribute("num",1000000); 와 같다.
	(밑에있는 set테그랑)				--%>				
	<c:set value="1000000.55" var="num"></c:set>
	num : ${num } <br>
	
	<h3>한국</h3>
	<fmt:setLocale value="ko_KR"/> <!-- ko_KR 국가 선택해줘야됨 -->
	ko(기본) :<fmt:formatNumber value="${num }"></fmt:formatNumber><br>
	<%-- type: number, currency, or percentage. --%>
	ko(type="currency") :<fmt:formatNumber value="${num }" type="currency"></fmt:formatNumber><br>
	ko(type="percent") :<fmt:formatNumber value="${num }" type="percent"></fmt:formatNumber><br>
	
	
	<h3>독일</h3>
	<h5>독일은 소수점, 단위는 .으로 되어있다. </h5>
	<fmt:setLocale value="de_DE"/>
	de(기본) :<fmt:formatNumber value="${num }"></fmt:formatNumber><br>
	de(type="currency") :<fmt:formatNumber value="${num }" type="currency"></fmt:formatNumber><br>
	de(type="percent") :<fmt:formatNumber value="${num }" type="percent"></fmt:formatNumber><br>
	
	<h2>parseNumber(String -> number / 1,000,000 ->1000000)</h2>
	<fmt:setLocale value="ko_KR"/>
	<c:set value="1,000,000" var="numStr"/>
	numStr = ${numStr }<br>
	parseNumber numStr : <fmt:parseNumber value="${numStr }" pattern="0,000"/>




</body>
</html>