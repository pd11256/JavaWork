<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Session List</title>
</head>
<body>
<%
	if(request.isRequestedSessionIdValid()){
		out.println("유효한 세션이 있습니다<hr>");
	} else {
		out.println("유효한 세션이 없습니다<hr>");
	}

	String sessionName, sessionValue;
	
	// 현재 세션의 모든 name 들 가져오기
	Enumeration<String> enumeration = session.getAttributeNames();   // Enumeration<String> 리턴
	
	int i = 0;
	while(enumeration.hasMoreElements()){
		
		sessionName = enumeration.nextElement();
		// session.getAttribute(sessionName)  <-- 특정 name의 세션값 추출, name 없으면 null 리턴 
		sessionValue = session.getAttribute(sessionName).toString();
		out.println((i + 1) + "] " + sessionName + " : " + sessionValue + "<br>");
		i++;
	} // end while
		
	if(i == 0){
		out.println("세션이 없습니다<br>");
	}
%>
<hr>
<form action="sessionCreate.jsp">
<input type="submit" value="세션생성">
</form>

<br>

<form action="sessionDelete.jsp">
<input type="submit" value="세션삭제">
</form>

<hr>
<%
	String sessionId = session.getId();
	int sessionInterval = session.getMaxInactiveInterval();

	out.println("세션 ID: " + sessionId + "<br>");
	out.println("세션 유효시간: " + sessionInterval + "<br>");
%>

<%
	out.println("--- session.invalidate()후 --<br>");
	//세션 무효화 invalidate
	//세션테이블 삭제 (session id 무효화)
	// - 그안의 모든 attribute(이름)도 삭제됨.
	// 새로운 세션테이블 생성
	// 이 밑에있는것은 아무떄나 쓰는게 아니다 한번 확인하려고 하는것
	
	session.invalidate();
	
	sessionId = session.getId();
	sessionInterval =session.getMaxInactiveInterval();
	out.println("세션 ID: " + sessionId + "<br>");
	out.println("세션 유효시간: " + sessionInterval + "<br>");
	
	
	
	
%>

<!-- 세션은 요청하는 브라우저 마다 생성된다 , 여기서 실행하는것과 chrome에서 새로 실행하는것  은 새로운 브라우저를 여는것이라 
	세션이없다고 생선된다.
  -->

</body>
</html>















