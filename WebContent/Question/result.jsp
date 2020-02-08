<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String gender = (String)request.getAttribute("gender");
	String naidae = (String)request.getAttribute("naidae");
	String result = (String)request.getAttribute("result");
	String result2 = (String)request.getAttribute("result2");
%>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
</head>
<body>
전체 설문자의 대답 중 가장 인기있는 장르는 <%= result %> <br><br>
<%= naidae%> <%=gender %> 중 가장 있기있는 장르는 <%= result2 %>
<form action="result2.jsp">
	전체 통계를 보시겠습니까?
	<input type="submit" value="예">
</form>
</body>
</html>