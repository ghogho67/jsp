<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/scope/scopeReceive.jsp" method="post">
	<h2>jsp scope 테스트</h2>
	page	<input type="text" name="pageParam" value="pageValue"><br> 
	request <input type="text" name="requestParam" value="requestValue"><br>
	session <input type="text" name="sessionParam" value="sesionValue"><br>
	application <input type="text" name="applicationParam" value="aplicationValue"><br>
	
	<button>전송하기</button>	
	</form>
</body>
</html>