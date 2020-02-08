<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="question.QuestionDAO"  %>
<jsp:useBean id="dto" class="question.QuestionDTO"/>
<jsp:setProperty name="dto" property="*"/>
<% 
	QuestionDAO dao = QuestionDAO.getInstance();
	dao.insert(dto);
	String result = dao.result();
	String gender = "";
	String naidae = "";
	if(dto.getGender().equals("남자")) {
		gender = "남자";
	}else {
		gender = "여자";
	}
	int age = dto.getAge();
	
	if(age < 20) {
		naidae = "10대이하";
	}
	else if(age < 30) {
		naidae = "20대";
	}
	else if(age < 40) {
		naidae = "30대";
	}
	else if(age < 50) {
		naidae = "40대";
	}
	else {
		naidae = "50대이상";
	}
	String result2 = dao.result2(gender, age);
	
	request.setAttribute("gender", gender);
	request.setAttribute("naidae", naidae);
	request.setAttribute("result", result);
	request.setAttribute("result2", result2);
%>
<jsp:forward page="result.jsp"/>

<html>
<head>
<meta charset="UTF-8">
<title>설문조사 결과 처리</title>
</head>
<body>


</body>
</html>