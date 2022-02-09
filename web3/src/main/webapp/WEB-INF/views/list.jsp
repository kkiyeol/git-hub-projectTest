<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<h1>[ web3 예제 ]</h1>
	<div>
		<table border="1">
			<tr>
				<td colspan="3">회원 목록</td>
			</tr>
			<tr>
				<td>id</td>
				<td>name</td>
				<td></td>
			</tr>
			<c:forEach var="i" items="${searchAll}">
				<tr>
					<td><a href="info?id=${i.id }">${i.id}</a></td>
					<td>${i.name}</td>
					<td><a href="delete?id=${i.id }">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>