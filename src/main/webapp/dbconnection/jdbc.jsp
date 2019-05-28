<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//DB작업에 필요한 객체 변수 선언
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 접속 ==> Connection객체 생성
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 20; i++){
			conn = DriverManager.getConnection(
					// 바뀌는 부분 => @localhost:1521:xe
					// 호스트이름, 포트번호, SID
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"pc05", // 사용자 아이디 
					"java"); // 패스워드
			
			conn.close();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("duration : " + (endTime-startTime));
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		// 6. 사용했던 자원들을 모두 반납한다. ==> !객체가 생성된 순서의 역순으로 닫아준다!
		if(rs!=null){ try {	rs.close();	} catch (SQLException e2) {} }
		if(stmt!=null){ try { stmt.close();	} catch (SQLException e2) {} }
		if(conn!=null){ try { conn.close();	} catch (SQLException e2) {} }
	}
%>