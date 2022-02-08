<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 가계부</title>
</head>
<body>
	<h2>연도별 통계</h2>
	<table style="border:1px solid black;">
		<tr>
			<th style="width:100px;">연도</th>
			<th style="width:100px;">수입 총합계</th>
			<th style="width:100px;">지출 총합계</th>
		</tr>
		<c:forEach var="data" items="${list}">
			<tr>
				<td>${data.year}</td>
				<td>${data.totalIn}원</td>
				<td>${data.totalOut}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
