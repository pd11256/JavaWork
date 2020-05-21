<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import = 'java.sql.*' %><%-- JDB 관련 import --%>

   
<%
	//이거무조건해주야한다
	request.setCharacterEncoding("utf-8"); //한글 인코딩 꼭!
	//입력한 값 받아오기
	String name =request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	//유효성 체크(백엔드에서도 검사해줘야한다, 이부분이 백엔드!)
	//name ,subject 는 비어있으면 안된다. NN
	// null 이거나 빈 문자열이면 이전화면으로 돌아가기	
	if(name == null || subject == null || 
		name.trim().equals("") || subject.trim().equals("")){
		
%>		

	<script>
		alert("작성자 이름, 글 제목은 필수 입니다!");
		history.back(); //history.go(-1);		
	</script>
		
<% 
		return ; // ★★★★★ 더 이상 JSP 프로세싱 하지 않도록 종료!!
				//jsp코드에서 return을넣은것은 더이상 프로세싱 하지않는다는것이다!! 
	}
%>	
   
   
   
   <%!
   //JDBC 관련 기본 객체 변수
   Connection conn = null;
   Statement stmt = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null; //SELECT 결과, excuteQuery()
   int cnt = 0; // DML 결과 executeUpdate()
   
   //Connection 에 필요한 값 세팅
   String driver = "oracle.jdbc.driver.OracleDriver";
   String url ="jdbc:oracle:thin:@localhost:1521:XE";
   String uid = "scott0316";
   String upw = "tiger0316";
   %>
   
   <%!
   
   //쿼리문 준비
  	String sql_insert = "INSERT INTO test_write " +
   "(wr_uid, wr_subject, wr_content, wr_name)" +
  	"VALUES(test_write_seq.nextval, ?, ?, ?)"
  	;
   //쿼리문 부분 끝 
   
   %>
   <%
   try{
     Class.forName(driver);
     out.println("드라이버 로딩 성공"+"<br>");
     conn = DriverManager.getConnection(url,uid,upw);
     out.println("conn성공<br>");
     
     //트랜잭션 실행
     pstmt = conn.prepareStatement(sql_insert);
     
     pstmt.setString(1, subject);
     pstmt.setString(2, content);
     pstmt.setString(3, name);
    
     cnt =pstmt.executeUpdate();
     //트랜잭션 부분  끝 
     
   }catch(Exception e){
      e.printStackTrace();
      //예외처리
   }finally{
      //리소스 해제
      try{
         if(rs!=null)rs.close();
         if(stmt!=null)stmt.close();
         if(pstmt!=null)pstmt.close();
         if(conn!=null)conn.close();
      }catch(Exception e){
         e.printStackTrace();
      }
   }
   %>
   
<%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>


<% if(cnt == 0){ %>
			<script>
				alert("등록 실패!!!!!");
				history.back(); //브라우저가 기억하는 직전 페이지 (입력중 페이지)
			</script>
<%}else { %>
	<script>
		alert("등록 성공, 리스트를 출력합니다");
		location.href = "list.jsp";
	</script>
	
	
<% } %>

