<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>참여자 정보 입력</title>
<script src="../resource/jquery-2.2.4.js"></script>
<script>
	$(document).ready(function(){
		$("input[type='checkbox']").on("click",function(){
			var count = $("input:checked[type='checkbox']").length;
			if(count > 3) {
				$(this).attr("checked", false);
				alert("3개까지만 선택 가능합니다.");
			}
		});
	});
	
	
</script>
</head>
<body>
<h1>설문자 정보 입력</h1>
<form action="QuestionProc.jsp" name="QuestionForm">
<ul>
	<li>성별
	<input type="radio" name="gender" value="남자">남자
	<input type="radio" name="gender" value="여자">여자<br><br>
	</li>
	
	<li>나이
	<input type="number" name="age">
	<br><br>
	</li>
	<li>선호하는 음악(3개까지 선택가능)</li>
</ul>
	&nbsp;&nbsp;&nbsp;<input type="checkbox" name="song" value="ballad">발라드
	&nbsp;&nbsp;&nbsp;<input type="checkbox" name="song" value="hiphop">힙합
	&nbsp;&nbsp;&nbsp;<input type="checkbox" name="song" value="elec">일렉
	&nbsp;&nbsp;&nbsp;<input type="checkbox" name="song" value="rock">락
	&nbsp;&nbsp;&nbsp;<input type="checkbox" name="song" value="dance">댄스
	&nbsp;&nbsp;&nbsp;<input type="checkbox" name="song" value="indie">인디
	&nbsp;&nbsp;&nbsp;<input type="checkbox" name="song" value="rnb">R&B
	<br><br>
	&nbsp;&nbsp;&nbsp;<input type="submit">
</form>
</body>
</html>