<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INFO</title>
</head>
<body>
	<h1>SELECT 결과</h1>
	<p>검색결과 : ${info }</p>
	<hr>
	<div>
		<table border="1">
			<tr>
				<td colspan="2">회원 목록</td>
			</tr>
			<tr>
				<td>id</td>
				<td>name</td>
			</tr>
			<c:forEach var="i" items="${searchAll}">
				<tr>
					<td>
						<p>${i.id}</p>
					
					</td>
					<td>
						
						<p>${i.name}</p>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>