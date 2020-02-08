<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="question.QuestionDAO" %>
<%
	QuestionDAO dao = new QuestionDAO();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
전체 연령대 중 가장 인기있는 장르 : <%= dao.result() %><br>
10대 이하 남자 <%= dao.result2("남자", 15) %>, 10대 이하 여자 <%= dao.result2("여자", 15) %><br>
20대 남자 <%= dao.result2("남자", 25) %>, 20대 여자 <%= dao.result2("여자", 25) %><br>
30대 남자 <%= dao.result2("남자", 35) %>, 30대 여자 <%= dao.result2("여자", 35) %><br>
40대 남자 <%= dao.result2("남자", 45) %>, 40대 여자 <%= dao.result2("여자", 45) %><br>
50대 이상 남자 <%= dao.result2("남자", 55) %>, 50대 이상 여자 <%= dao.result2("여자", 55) %><br>
</body>
</html>