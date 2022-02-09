<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajaxtest</title>

<script src="../resources/js/jquery-3.6.0.js"></script>
<script>
$(document).ready(function() {
	//버튼을 Click하면 함수 실행
	$('#bt1').on('click', call1);
	$('#bt2').on('click', call2);
});

//서버 호출
function call1() {
	alert('call1() 실행');
	
	$.ajax({
		url: 'ajaxtest1',
		type: 'post',
		dataType: 'text',
		success: output1,
		//Server 중지한 후 호출하여 에러 확인
		error: function (e) {
			alert(JSON.stringify(e));
			alert('error: ' + e.status)
		}
	});	
}

//call1() 실행 후 돌아올 함수
function output1() {
	alert("output1()로 돌아옴.");
}

//서버로 문자열 데이터 전송
function call2() {
	alert("call2() 실행");
	
	$.ajax({
		url: 'ajaxtest2',
		type: 'POST',
		data: {str:'클라이언트에서 보낸 문자열'},
		dataType: 'text',
		success: output2,
		error: function (e) {
			alert(JSON.stringify(e));
		}
	});
}

//call2() 실행 후 돌아올 함수
function output2(text) {
	alert("서버에서 가져온 문자열 : " + text);
}
</script>
</head>
<body>

<h1>[ Ajax 연습 1 ]</h1>

<p><input type="button" id="bt1" value="서버로 요청 보내기"></p>
<p><input type="button" id="bt2" value="서버로 문자열 보내기 / 받기"></p>

</body>
</html>
