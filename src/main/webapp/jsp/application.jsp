<%@page import="java.io.IOException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
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
	request.setCharacterEncoding("UTF-8");

	out.write(" application.getContextPath() :" +  application.getContextPath() + "<br>"); 
	out.write("application.getServerInfo() :" +  application.getServerInfo() + "<br>"); 
	out.write("application.getMajorVersion() :" +  application.getMajorVersion() + "<br>"); 
	out.write("application.getMinorVersion() :" + application.getMinorVersion() + "<br>"); 
	out.write("application.getInitParameter(\"ADMIN\") :" + application.getInitParameter("ADMIN") + "<br>"); 
	
	//
	out.write("application.getRealPath(\"/res/190522.txt\") :" +application.getRealPath("/res/190522.txt"));
	
	out.write("<br> <h2>구글을 믿으십쇼 그안에 뜻이있습니다.</h2><h3>파일불러와서 읽기</h3>");
	BufferedReader reder = null;
	try{
		String filePath = application.getRealPath("/res/190522.txt");
		reder = new BufferedReader(new FileReader(filePath));
		while(true){
			String str = reder.readLine(); // 한행의 텍스트 데이터를 읽는다.
			if(str==null){
				
				break;
			}
			out.write(str + "<br>");
		}
		
	}catch(FileNotFoundException e){
		e.printStackTrace();
		out.write("파일이 존재하지 않음");
		
	}catch(IOException e){
		e.printStackTrace();
		out.write("파일이 존재하지 않음");
		
	}finally{
		try{
			reder.close();
		}catch(Exception e){
			e.printStackTrace();	
		}
		
	}
	

%>


</body>
</html>