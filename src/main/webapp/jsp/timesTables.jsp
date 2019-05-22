<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- localhost/jsp/jsp/timesTables.jsp --%>
	<%-- 9*9 단 출력(2~9단) --%>

	<table border=2>
		<%
		 String param = request.getParameter("i");
		 String param2 = request.getParameter("j");
		 Integer a = Integer.parseInt(param);
		 Integer b = Integer.parseInt(param2);
		 
		%>
	
	
		<%
			for (int i = 0; i <= a; i++) {
		%>	
			<tr>
	
		<%
			for (int j = 2; j <= b; j++) {
					if (i == 0) {
		%>
		
			<th><%=j%>단</th>
			<%
				} else if (i >= 1) {
			%>
			<td><%=j%> x <%=i%> = <%=j * i%></td>

			<%
				}
			%>
		
		<%
			}
			}
		%>
		</tr>
	</table>


</body>
</html>