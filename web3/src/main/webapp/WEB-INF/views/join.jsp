<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join</title>
<link rel="stylesheet" type="text/css" href="resources/css/join.css">
<script>
function check() {
	var custid = document.getElementById("id");
	var pwd = document.getElementById("pw1");
	var pwd2 = document.getElementById("pw2");
	var name = document.getElementById("name");
	
	if(id.value.length < 3){
		alert('ID를 3자 이상 써주세요。');
		custid.focus();
	    custid.select();
	    return false;
	}
	if(pwd.value.length == 0){
		alert('비밀번호를 기입해주세요。');
		pwd.focus();
	    pwd.select();
	    return false;
	}
	if(pwd2.value.length == 0){
		alert('확인을 위해 비밀번호를 기입해주세요。');
		pwd2.focus();
	    pwd2.select();
	    return false;
	}
	if(name.value.length == 0){
		alert('이름을 기입해주세요。');
		name.focus();
	    name.select();
	    return false;
	}
	if(pwd.value != pwd2.value) {
		alert('비밀번호가 일치하지 않아요。');
		return false;
	}
	alert('등록됬습니다。')
	return true;
}

//ID중복검사 창 열기
function check2() {
	//window는 미리 만들어진 자바객체 (web browser)
	//"idCheck" 경로 .. "idwin" 새 창의 이름 (이름이 같은 창을 또 열면 새로고침 같이됨)..세번째 = 창의 
	//window.open("idCheck", "idwin", "top=200,left=550,width=400,height=300,menubar=no");
	alert('중복체크');
}

</script>
</head>
<body>
<br><br>
<h1 class="title">회원가입</h1>
<br><br>
<hr>
<div class="middle">
<br>
<form action="join" method="post" onsubmit="return check()">
<table class="table">
	<tr>
		<th>
			<p>ID</p>
		</th>
		<td>
			&nbsp;&nbsp;<input type="text" name="id" id="id" size="55" 
			placeholder="ID중복확인 해주세요">
			<!-- readonly="readonly" --> 
			&nbsp;<input type="button" value="ID중복확인" onclick="check2()"> 
		</td>
	</tr>
	<tr>
		<th>
			<p>PW</p>
		</th>
		<td>
			&nbsp;&nbsp;<input type="password" name="password" id="pw1" size="70"><br>	
		</td>
	</tr>
	<tr>
		<th>
			<p>PW 확인</p>
		</th>
		<td>
			&nbsp;&nbsp;<input type="password" id="pw2" size="70"><br>	
		</td>
	</tr>
	<tr>
		<th>
			<p>이름</p>
		</th>
		<td>
			&nbsp;&nbsp;<input type="text" name="name" id="name" size="70"><br>	
		</td>
	</tr>

</table>
		<p class="home"><input type="submit" value="등록"></p>
</form>

<hr>
</div><br><br>
<p class="home"><a href="./" class="home3">메인메뉴</a><p>


</body>
</html>