<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>page</th>
			<td>
				<%=pageContext.getAttribute("pageAttribute")%></td>
		</tr>
		
		<tr>
			<th>request</th>
			<td>
				<%=request.getAttribute("requestAtrribute")	%></td>
		</tr>
		
		<tr>
			<th>session</th>
			<td><%=session.getAttribute("sessionAtrribute") %></td>
		</tr>
		
		<tr>
			<th>application</th>
			<td><%=application.getAttribute("applicationAtrribute") %></td>
		</tr>

	
	</table>
</body>
</html>