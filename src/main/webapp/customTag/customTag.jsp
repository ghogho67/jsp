<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>구분자 만들기</h2>
	1. 고정문자열 :
	===============================================================================
	<br> 2. loop(core-forEach) :
	<br>
	<c:forEach begin="1" end="80">=</c:forEach>
	<br> 3. customTag(logging) :
	<ct:logging />
	<br> 4. customTag(loopLogging) :
	<ct:loopLogging />
	<br> 5. colorLoggingTag :
	<ct:colorLogging color="blue" size="10" />
	<br> 5-1. colorLoggingTag :
	<ct:colorLogging color="red" />
	<br> 6. rangersTag :
	<ct:rangers rangers="brown,cony,james,sally,moon" />
	<br> 7. code :<ct:code code="P201"></ct:code>
	

</body>
</html>
