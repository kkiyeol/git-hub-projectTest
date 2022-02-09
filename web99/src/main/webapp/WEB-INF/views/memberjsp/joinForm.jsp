<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JoinForm</title>
<script>
	function formCheck(){
	var pw = document.getElementById('password');
	var pw2 = document.getElementById('password2');
	var name = document.getElementById('name');
	var h = document.getElementById('idHidden');

	if(h.value != 1){
		alert('ID중복확인을 해라');
		return false;
	}
	if(pw.value.length < 3){
		alert('비밀번호 3자 이상');
		return false;
	}
	if(pw.value != pw2.value){
		alert('비밀번호 불일치');
		return false;
	}
	if(pw.value.length < 3){
		alert('이름 3자 이상');
		return false;
	}
	return true;
	}
	function idcheck(){
		var w = window.open('idcheck', 'win', 'top=200,left=500,width=400,height=300');
	}
</script>
</head>
<body>
	<h1>[ 회원 가입 ]</h1>
	
	<form action="join" method="POST" onsubmit="return formCheck()">
	<table>
		<tr>
			<td>ID</td>
			<td>
				<input type="text" name="id" id="id">
				<input type="button" value="ID중복확인" onclick="idcheck()">
				<input type="hidden" id="idHidden">
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" name="password" id="password">
				<input type="password" id="password2">
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" id="name">
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
				<input type="tel" name="phone" id="phone">
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				<input type="text" name="address" id="address">	
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="email" name="email" id="email">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="가입">
				<input type="reset" value="다시 쓰기">
			</td>
		</tr>
	</table>
	</form>

</body>
</html>
