<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<c:choose>
				<c:when test ="${param.param2 eq null && param.param1 eq null}"> <!-- 3항 연산자 쓰면된다. -->
					 ${parma.param2 = 9 } ${parma.param1 = 9 }
				</c:when>
		</c:choose>
					<table border=2>
				
					<c:forEach begin="0" end=${param.param1 } step="1" var="i">
						<tr>
						<c:forEach begin="2" end=${parma.param2 } 
																	
									step="1" var="j">
						<c:choose>
							<c:when test="${i eq 0 }">
				
					<th>${j }단</th>
					</c:when>
					
					<c:otherwise>
					<td>${j } x ${i } = ${j*i }</td>&nbsp;
		
					</c:otherwise>
					</c:choose >
				
					</c:forEach>
					</tr>
				</c:forEach>
				
		
	</table>

</body>
</html>