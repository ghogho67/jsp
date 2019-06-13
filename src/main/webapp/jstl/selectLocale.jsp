<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/basicLib.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	$(document).ready(function(){
		$("#select").val("${setLocale}");
	
		$("#select").on("change",function(){
			$("#frm").submit();
		});
		
		
	});
	
	
</script>
</head>
<body>

	<h2>select locale</h2>
	
	<form id="frm" action="${pageContext.request.contextPath }/selectLocale" method="post">
		<select id="select" name = "optionVal">
			
		  		<option value="ko">한국어</option>
				<option value="en">english</option>
				<option value="ja">日本語</option>
		</select>
	</form>	
		
			<fmt:setLocale value="${setLocale }"/>
			<fmt:bundle basename="kr.or.ddit.msg.msg">
				<fmt:message key="GREETING"/>
				<fmt:message key="VISITOR">
					<fmt:param value="brown" /><br>
				</fmt:message>
			</fmt:bundle>
		


</body>
</html>