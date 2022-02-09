<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test1</title>
<script src="./resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	$('#bt1').on('click', bt1Click);
	$('#bt2').on('click', bt2Click);
	$('#btkky').on('click', btkky);
});

function bt2Click(){
	$.ajax({
		url: "ajaxtest2",
		type: 'post',
		data: {name: '홍길동'},		//{}가 vo처럼 객체로 만들어줌
		dataType: 'text',
		success: function(str){
			alert(str);
		},
		error: function(e){
			alert(JSON.stringify(e));	//JSON.stringify() 는 객체를 문자열화
		}
	})
}
//bt1 버튼 클릭했을 때 실행될 함수
function bt1Click(){
	$.ajax({
		url: 'ajaxtest1',
		type: 'POST',
		dataType: 'text',
		success: function(str){
			output(str)
		},
		error: error
	});
}
//bt1Click()함수에서 서버로 ajax요청을 보낸 후 성공했을때
function output(str){
	$('#div1').html(str);
}
//bt1Click()함수에서 서버로 ajax요청을 보낸 후 실패했을때
function error(){
	$('#div1').html('ajax 테스트 실패');
}
function btkky(){
	var name = $('#name').val();
	var pw = $('#pw').val();

	var obj = JSON.stringify({"name":name, "pw":pw});

	//$('#').serialize() jsp에 전부 name값줌
	$.ajax({
		url: 'btkky',
		type: 'POST',
		data: obj,
		contentType : "application/json; charset=UTF-8",
		dataType: 'json',
		success: function(person){
			alert(JSON.stringify(person));
			$('#div2').html(JSON.stringify(person));
		},
		error: function(e){
			alert(JSON.stringify(e));
			alert(e.statusText);
		}
	});
}
</script>
</head>
<body>
<h1>[ Ajax 연습1 ]</h1>

<p><input type="button" id="bt1" value="서버로 요청 보내기"></p>
<div id="div1"></div>
<p><input type="button" id="bt2" value="서버로 요청 보내기/받기"></p>

<hr><br><br>
<input type="text" id="name" name="test1"><br>
<input type="text" id="pw" name="test1"><br>
<p><input type="button" id="btkky" value="연습용"></p>
<div id="div2"></div>

<a href="selfTest">테스트</a>

</body>
</html>