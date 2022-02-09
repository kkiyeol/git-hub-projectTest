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
	$('#formButton1').on('click', formSubmit1);
	$('#formButton2').on('click', formSubmit2);
	$('#formButton3').on('click', formSubmit3);
	$('#bt1').on('click', getJson1);
	$('#bt2').on('click', getJson2);
});

//입력한 내용을 서버로 전송 1
function formSubmit1() {
 	//폼에 입력한 이름과 리플내용을 읽어옴
	var name = $('#name').val();
	var age = $('#age').val();
	var phone = $('#phone').val();
	
	
	//사용자가 입력한 내용을 서버로 전송.
	$.ajax({
		url: 'insert1',
		type: 'POST',
		data: {"name": name, "age": age, "phone": phone},
		success: function() {
			alert('저장되었습니다.');
		},
		error: function(e) {
			alert(JSON.stringify(e));
		}
	});
}

//입력한 내용을 서버로 전송 2
function formSubmit2() {
 	//폼에 입력한 이름과 리플내용을 읽어옴
	var name = $('#name2').val();
	var age = $('#age2').val();
	var phone = $('#phone2').val();

	alert(age)
	//JSON 객체로 생성
	var ob = JSON.stringify({"name":name, "age": age, "phone": phone});

	$.ajax({
		url: 'insert2',
		type: 'POST',
		contentType : "application/json; charset=utf-8",
		data: ob,
		success: function() {
			alert('저장되었습니다.');
		},
		error: function(e) {
			alert(JSON.stringify(e));
		}
	});
	
}

//입력한 내용을 서버로 전송 3
function formSubmit3() {
	$.ajax({
        url : 'insert3',
        type : 'post',
        data : $('#writeForm3').serialize(),
        success : function() {
        	alert('저장되었습니다.');
        },
        error: function(e) {
        	alert(JSON.stringify(e));
        }
	});
}

//서버에서 객체 받기 요청 (String으로 받기)
function getJson1() {
	$.ajax({
		url : 'jsontest',
		type : 'get',
		dataType : 'text',
		success : function(ob) {
			$('#outputDiv1').html(ob);
		},
		error : function(e) {
			alert(JSON.stringify(e));
		}
	});	
}

//서버에서 객체 받기 요청 (JSON으로 받기)
function getJson2() {
	$.ajax({
		url : 'jsontest',
		type : 'get',
		dataType : 'json',
		success : function(ob) {
			var str = '받은 값 : ' + ob + '<br>';
			str += '이름 :' + ob.name + '<br>';
			str += '나이 :' + ob.age + '<br>';
			str += '전화 :' + ob.phone + '<br>';
			$('#outputDiv2').html(str);
		},
		error : function(e) {
			alert(JSON.stringify(e));
		}
	});	
}

</script>
</head>
<body>

<h1>[ Ajax 연습 2 ]</h1>

<p>1. 서버로 각각의 Parameter를 전달</p>
<form id="writeForm1">
이름 <input type="text" id="name"><br>
나이 <input type="number" id="age" value="0"><br>
전화 <input type="text" id="phone"><br>
    <input type="button" id="formButton1" value="저장">
</form>

<p>2. 서버의 VO객체로 전달 1</p>
<form id="writeForm2">
이름 <input type="text" id="name2"><br>
나이 <input type="number" id="age2" value="0"><br>
전화 <input type="text" id="phone2"><br>
	<input type="button" id="formButton2" value="저장">
</form>

<p>3. 서버의 VO객체로 전달 2</p>
<form id="writeForm3">
이름	<input type="text" name="name"><br>
나이   <input type="number" name="age" value="0"><br>
전화   <input type="text" name="phone"><br>
	<input type="button" id="formButton3" value="저장">
</form>

<p>4. 서버에서 VO객체의 값을 String으로 받기</p>
<p><input type="button" id="bt1" value="서버에서 객체 받기"></p>
<div id="outputDiv1"></div>

<p>5. 서버에서 VO객체의 값을 JSON으로 받기</p>
<p><input type="button" id="bt2" value="서버에서 객체 받기"></p>
<div id="outputDiv2"></div>

</body>
</html>
