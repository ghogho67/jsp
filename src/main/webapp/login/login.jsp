<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 어디로 요청을 보낼지?? form태그 action속성을 이용하여 보낸다. 
		 어떻게 보낼지 (http method) ?? form태그 method 속성 (get-default/ post)  -->
	<%-- /login/login.jsp 를  /login/loginprocess.jsp 로 보낸다. --%>
	<!-- get 방식(기본적으로 get방식임) -->
	
	<p>get방식(파라미터가 남는다.)</p><br>
	<form action="<%=request.getContextPath()%>/login/loginprocess.jsp">
		userId : <input type="text" name="userId" value="sally" ><br>
		userId : <input type="text" name="userId" value="샐리"><br>
		password : <input type="password" name="password" value="pass1234"><br>
		
		<input type="submit" value="로그인">
	</form><br>
	<br>
	<br>
	
	
	<p>post방식(파라미터가 남지 않는다.)</p><br>
	<form action="<%=request.getContextPath()%>/login/loginprocess.jsp" method="post">
		userId : <input type="text" name="userId" value="sally" ><br>
		userId : <input type="text" name="userId" value="샐리"><br>
		password : <input type="password" name="password" value="pass1234"><br>
		
		<input type="submit" value="로그인">
	</form>
</body>
</html>