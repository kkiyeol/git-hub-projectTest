<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>방명록</title>
<link rel="stylesheet" href="${path }/web4/resources/css/board.css">
<link rel="stylesheet" media="(max-width:750px)" href="${path }/web4/resources/css/mobile.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
	
</style>
<script>
	function btn(password){
		var pw = document.getElementById('pw');

		if(pw.value == null){
			alert('비밀번호를 입력해주세요.');
			pw.focus();
			pw.select();
			return false;
		}
		
		if(pw.value != null && pw.value != password){
			alert('비밀번호가 틀렸습니다.');
			pw.focus();
			pw.select();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<h1>[ 방명록 ]</h1>
	<div class="head">
		<div class="head1"><a href="./">홈</a></div>
		<div class="head2"><a href="write">글쓰기</a></div>
	</div>
	<hr><br>
	
	<div class="container">
		<c:forEach var="board" items="${list }" varStatus="status">
		<div class="item">
			<table class="listTable">
					<tr>
						<td>
							<p class="name1">작성자: ${board.name}
								<c:if test="${maxNum == board.num}">
									<p class="maxNum">NEW</p>
								</c:if>
							</p>
							<p>작성일: ${board.inputdate}</p>
							<pre class="preSpace">${board.content }</pre>
							
							<form action="delete" method="post" onsubmit="return btn(${board.password})">
								<input type="password" name="password2" id="pw" placeholder="password 입력">
								<input type="hidden" name="num" value="${board.num}">
								<input type="submit" value="삭제">
								<%-- <input type="submit" value="삭제" onclick="btn(${board.password})"> --%>
							</form>
						</td>
					</tr>
			</table>
		</div>
		</c:forEach>
	</div>


</body>
</html>