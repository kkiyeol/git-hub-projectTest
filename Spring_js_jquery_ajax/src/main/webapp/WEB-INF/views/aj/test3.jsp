<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="../resources/js/jquery-3.6.0.js"></script>
<script>
$(document).ready(function() {
	//버튼을 Click하면 함수 실행
	$('#bt1').on('click', call1);
	$('#bt2').on('click', call2);
	$('#bt3').on('click', call3);
});

//서버로 배열 보내기
function call1() {
	var ar = [];
	ar.push('aaa');
	ar.push('bbb');
	ar.push('ccc');
	ar.push('ddd');
	ar.push('eee');
	alert(ar);
	
	$.ajax({
		url: 'arrayTest1',
		type: 'post',
		traditional : true,
		data : {ar : ar},
		dataType: 'text',
		success: function () {
			alert('성공');
		},
		error: function (e) {
			alert(JSON.stringify(e));
		}
	});		
}

//서버에서 문자열 배열 받기
function call2() {
	$.ajax({
		url: 'arrayTest2',
		type: 'get',
		dataType: 'json',
		success: function (list) {
			var str = '';
			$.each(list, function(i, item) {
				str += '[' + i + '] : ';
				str += item;
				str += '<br>';
			});
			$('#outputString').html(str);
		},
	});		
}

function call3() {
	$.ajax({
		url: 'arrayTest3',
		type: 'get',
		dataType: 'json',
		success: function (list) {
			var str = '';
			$.each(list, function(i, item) {
				str += '[' + i + '] : ';
				str += '이름:' + item.name;
				str += ' 나이:' + item.age;
				str += ' 전화번호:' + item.phone;
				str += '<br>';
			});
			$('#outputObject').html(str);
		}
	});		
}

</script>
</head>
<body>

<!-- 서버로 배열 전달 -->
<p><input type="button" id="bt1" value="배열 전달"></p>

<!-- 서버에서 배열 받기 -->
<p><input type="button" id="bt2" value="서버에서 배열 받기 - 문자열 배열"></p>
<div id="outputString"></div>

<p><input type="button" id="bt3" value="서버에서 배열 받기 - 객체 배열"></p>
<div id="outputObject"></div>

</body>
</html>