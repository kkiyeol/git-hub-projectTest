<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID 중복 확인</title>

<link rel="stylesheet" type="text/css" href="../resources/css/default.css" />
<script src="../resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	$('#searchId').on('keyup', ajaxCheck);
})

function selectId(id) {
	opener.document.getElementById('id').value = id;
	opener.document.getElementById('idHidden').value = 1;
	this.close();
}
function formCheck(){
	let id = document.getElementById('searchId');
	if(id.value.length < 3){
		alert('3자 이상');
		return false;
	}
	return true;
}

function ajaxCheck(){
	let text = document.getElementById('checkText');
	
	$.ajax({
		url: 'idCheck2',
		type: 'POST',
		datatype:'text',
		data: {
			id: $('#searchId').val()
		},
		success: checkMsg,
		error: function(str){
			alert('err');
		}
	});
}
function checkMsg(str){
	/* text.innerHTML('사용가능'); */
	if(str == 'o'){
		$("#checkText").html('사용가능');
	}else{
		$("#checkText").html('중복됨');
	}
	
}
</script>
</head>
<body>
<div class="centerdiv">
<h1>[ ID 중복 확인 ]</h1>

<form action="idcheck" method="post" onsubmit="return formCheck()">
검색할 ID <input type="text" name="searchId" id="searchId">
		<input type="submit" value="검색" />
</form>

<!-- 검색 후에만 출력 -->
<c:if test="${searchId != null}">
	<!-- 검색 결과가 없는 경우에만 출력 -->
	<c:if test="${member == null}">
		<p>${searchId} : 사용할 수 있는 ID입니다.</p>
		<p><input type="button" value="ID사용하기" onclick="selectId('${searchId}')"></p>
	</c:if>
	<!-- 검색 결과가 있는 경우에만 출력 -->
	<c:if test="${member != null}">
		<p>${searchId} : 이미 사용중인 ID입니다.</p>
	</c:if>
</c:if>

<div id="checkText"></div>

<%-- 자바스크립트에서 ${} el식이 먼저 실행되서
opener.document.getElementById('id').value = ${searchId}; 는 인식을 못함
opener.document.getElementById('id').value = '${searchId}'; 이렇게 씀 --%>

</div>
</body>
</html>




