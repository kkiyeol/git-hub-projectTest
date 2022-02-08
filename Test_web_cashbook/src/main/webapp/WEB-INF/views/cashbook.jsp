<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 가계부</title>
<script>

</script>
</head>
<body>
<h2>내 가계부</h2>
<form action="insert" method="post">
	<table>
		<tr>
			<th>구분</th>
			<td>
				<input type="radio" name="type" value="수입" checked>수입
				<input type="radio" name="type" value="지출">지출
			</td>
		</tr>
		<tr>
			<th>메모</th>
			<td><input type="text" id="memo" name="memo" placeholder="내용 입력"></td>
		</tr>
		<tr>
			<th>금액</th>
			<td><input type="text" id="amount" name="amount" placeholder="금액 입력"></td>
		</tr>
		<tr>				
			<td colspan="2"><input type="submit" value="등록"></td>
		</tr>
	</table>
</form>
<br><br>

<table style="border:1px solid black;">
<tr>
	<th style="width:100px;">날짜</th>
	<th style="width:100px;">구분</th>
	<th style="width:100px;">메모</th>
		<th>금액</th>
	</tr>
	
	<c:forEach var="data" items="${list}">
	<tr>
		<td>${data.inputdate}</td>
		<td>${data.type}</td>
		<td>${data.memo}</td>
		<td>${data.amount}</td>
		<td><input type="button" value="삭제" onclick="location.href='delete?infonum=${data.infonum}'"></td>
	</tr>
	</c:forEach>

</table>
</body>
</html>
