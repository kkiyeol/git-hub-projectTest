<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[ 게시판 ]</title>
</head>
<body>

<br>
<table border="1">
<tr>
	<td class="white">
		전체 : ${navi.totalRecordsCount}
	</td>
	<td class="white" colspan="3"></td>
	<td class="white">
		<input type="button" value="글쓰기" onClick="location.href='write';">
	</td>
	
</tr>
<tr>
	<th>번호</th>
	<th style="width:220px">제목</th>
	<th>작성자</th>
	<th>조회수</th>
	<th>등록일</th>
</tr>

<!-- 반복 시작 -->
<c:forEach var="board" items="${list}">
<tr>
	<td class="center">${board.boardnum}</td>
	<td>
		<a href="read?num=${board.boardnum}">${board.title}</a>
	</td>
	<td class="center">${board.id}</td>
	<td class="center">${board.hits}</td>
	<td>${board.inputdate}</td>
</tr>

</c:forEach>        
<!-- 반복 끝 -->
</table>
<br/><br/>
	
	
</body>
</html>