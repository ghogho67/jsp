<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	response.setHeader("Content-Disposition", "attachment; filename=line.xls");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border ='1'>
		<tr>
			<th>이름</th>
			<th>영문명</th>
		</tr>
		
		<tr>
			<th>샐리</th>
			<th>sally</th>
		</tr>
		
		<tr>
			<th>브라운</th>
			<th>james</th>
		</tr>
	</table>
</body>
</html>