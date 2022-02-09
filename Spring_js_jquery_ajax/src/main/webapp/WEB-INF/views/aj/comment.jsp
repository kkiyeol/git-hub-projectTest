<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리플 달기</title>

<style type="text/css">
td.tdNum {
	background-color: #dddddd;
	width: 30px;
	text-align: center;
}
td.tdName {
	background-color: #dddddd;
	width: 100px;
	text-align: center;
}
td.tdText {
	background-color: #dddddd;
	width: 400px;
	text-align: left;
}
</style>

<script src="../resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	//리플 달기 버튼을 Click하면 formSubmit() 함수 실행
	$('#formButton').on('click', formSubmit);
	//기존 리플들 읽어옴
	init();
});

//입력한 내용 서버로 전송 
function formSubmit() {
 	//폼에 입력한 이름과 리플내용을 읽어옴
	var name = $('#name').val();
	var text = $('#text').val();
	
	if (name.length == 0 || text.length == 0) {
		alert('이름과 리플 내용을 입력하세요.');
		return;
	}
	
	//사용자가 입력한 내용을 서버로 전송.
	$.ajax({
		url: 'insert',
		type: 'POST',
		contentType : "application/json; charset=utf-8",
		data: JSON.stringify({name: name, text: text}),
		success: function() {
			alert('저장되었습니다.');
			//폼 지우기
			$('#name').val('');
			$('#text').val('');
			//목록 갱신
			init();
		},
		error: function(e) {
			alert(JSON.stringify(e));
		}
	});
}

//페이지 로딩시 모든 리플 내용을 읽어옴. 성공하면 output()함수 실행
function init() {
	$.ajax({
		url: 'list',
		type: 'GET',
		dataType: 'json',
		success: output
	});	
}

//목록 출력
function output(msg) {
	//서버로부터 받은 목록을 반복문으로 읽기
	var str = '<table>';
    $.each(msg, function(key, item){
		str += '<tr>';
		str += '<td class="tdNum">' + item.num + '</td>';
		str += '<td class="tdName">' + item.name + '</td>';
		str += '<td class="tdText">' + item.text + '</td>';
		//각 리플마다 삭제 버튼을 만든다. 사용자 정의 속성 'data-num'에 삭제할 글 번호 대입
		str += '<td><input type="button" value="삭제" class="btnDel" data-num="'+ item.num +'"></td>';
		str += '</tr>';
    });
    str += '</table>';
    
    //목록 출력 영역에 내용 삽입
    $('#listDiv').html(str);
    
    //삭제 버튼들에 클릭이벤트 처리
    $('input:button.btnDel').on('click', commentDel);
}

//삭제 버튼 클릭했을 때 실행
function commentDel() {
	//클릭한 버튼의 'data-num' 속성값을 읽음
	var num = $(this).attr('data-num');
	
	//서버로 삭제할 글번호를 전달.
 	$.ajax({
		url: 'delete',
		type: 'POST',
		data: { "num" : num},
		success: function(cnt) {
			if (cnt == 0) {
				alert('삭제 실패');
			}
			else {
				alert('삭제되었습니다.');
				init();
			}
		}
	});
}
</script>
</head>

<body>
<h1>[ Ajax Test - 리플 달기 ]</h1>

<!-- 리플 작성 폼 영역 -->
<div id="formDiv">
<form id="writeForm">
이름	<input type="text" id="name" name="name" style="width:100px;">
내용	<input type="text" id="text" name="text" style="width:300px;">
	<input type="button" id="formButton" value="저장">
</form>
</div>
<br><br>

<!-- 목록 출력 영역 -->
<div id="listDiv">
</div>

</body>
</html>
