<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = 'java.sql.*' %><%-- JDB 관련 import 밑에 자바객체관련  --%>
<%!
   Connection conn = null;
   Statement stmt = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   int cnt = 0; 
   
   final String DRIVER = "oracle.jdbc.driver.OracleDriver";
   final String URL ="jdbc:oracle:thin:@localhost:1521:XE";
   final String USERID = "scott0316";
   final String USERPW = "tiger0316";
%>    

<%

	Class.forName(DRIVER);
	out.println("드라이버 성공 <br>");
	conn = DriverManager.getConnection(URL, USERID, USERPW);
	out.println("conn 성공 <br>");
	
%>

<%
if(rs!=null)rs.close();
if(stmt!=null)stmt.close();
if(pstmt!=null)pstmt.close();
if(conn!=null)conn.close();

%>