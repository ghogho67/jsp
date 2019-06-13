<%@page import="java.util.Date"%>
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

<c:set var="dt" value="<%=new Date() %>"/>
dt(기본) : ${dt }<br>
dt(fmt:formatDate) : <fmt:formatDate value="${dt }" pattern="yyyy-MM-dd - hh:mm" /><br>
dt(fmt:formatDate) : <fmt:formatDate value="${dt }"/><br>
dt(type="date",dateStyle ="FULL") : <fmt:formatDate value="${dt }" type="date" dateStyle ="FULL"/><br>
dt(type="time",dateStyle ="MEDIUM") : <fmt:formatDate value="${dt }" type="time" dateStyle ="MEDIUM"/><br>
dt(type="both",dateStyle ="SHORT") : <fmt:formatDate value="${dt }" type="both" dateStyle ="SHORT"/><br>
dt(type="time") : <fmt:formatDate value="${dt }" type="time"/><br>
dt(type="both") : <fmt:formatDate value="${dt }" type="both"/><br>
<br><br><br>


<h2>parseDate(String -> date / 2019.06.13 -> date)</h2>
<fmt:setLocale value="ko_KR"/>
<c:set value="2019.06.13" var="dtStr" />
dtStr : ${dtStr }<br>
dtStr : <fmt:parseDate value="${dtStr }" pattern="yyyy.MM.dd"/>  <br>


<br><br><br>

<h3>독일</h3>
<fmt:setLocale value="de_DE"/>
dt(fmt:formatDate)독일 : <fmt:formatDate value="${dt }"/><br>



</body>
</html>