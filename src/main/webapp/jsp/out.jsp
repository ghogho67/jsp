<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		out.write("<table>");
		for(int i = 2; i <= 9; i++){
			out.write("<tr>");
			for(int j = 1; j <= 9; j++){
				out.write("<td>" + i + "x" + j + " = " + i*j + "</td>");
				
			}
			out.write("</tr>");
		}
		out.write("</table><br>");
		out.write("out객체를 통한 출력 키득");
	%>
	
</body>
</html>