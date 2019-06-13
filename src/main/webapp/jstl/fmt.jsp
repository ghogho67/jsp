<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>한국어</h2>
<fmt:setLocale value="ko"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="GREETING"/>
	<fmt:message key="VISITOR">
		<fmt:param value="brown" /><br>
	</fmt:message>
</fmt:bundle>

<h2>영어</h2>
<fmt:setLocale value="en"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="GREETING"/>
	<fmt:message key="VISITOR">
		<fmt:param value="brown" /><br>
	</fmt:message>
</fmt:bundle>

<h2>일본어</h2>
<fmt:setLocale value="ja"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="GREETING"/>
	<fmt:message key="VISITOR">
		<fmt:param value="brown" /><br>
	</fmt:message>
</fmt:bundle>

<h2>SETBUNDLE</h2>
<fmt:setBundle basename="kr.or.ddit.msg.msg" var="message"/>
<fmt:message key="GREETING" bundle="${message }" />
<fmt:message key="VISITOR" bundle="${message }">
	<fmt:param value="brown"/><br>
</fmt:message>

</body>
</html>