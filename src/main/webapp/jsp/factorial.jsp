<%@page import="org.eclipse.jdt.internal.compiler.batch.Main"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! public String hello(){
	 return "hello";
			
}	
		public static int fact(int n){
			if(n <= 1){
				return n;
			}else{
				return fact(n-1)*n;
		}
	}
	%>
	hello() : <%= hello() %><br>
	
	fac(1) : <%=fact(1) %> <br>
	fac(2) : <%=fact(2) %> <br>
	fac(3) : <%=fact(3) %> <br>
	fac(4) : <%=fact(4) %> <br>
	fac(5) : <%=fact(5) %> <br>
	fac(6) : <%=fact(6) %> <br>
	fac(7) : <%=fact(7) %> <br>
	fac(8) : <%=fact(8) %> <br>

</body>
</html>