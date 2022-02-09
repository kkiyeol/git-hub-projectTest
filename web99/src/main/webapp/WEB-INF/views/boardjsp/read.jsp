<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[ 글읽기 ]</title>
</head>
<body>
	<table border="1">
		<tr>
			<th style="width:100px;">작성자 </th>
			<td style="width:600px;">${board.id}</td>
		</tr>
		<tr>
			<th>작성일 </th>
			<td>${board.inputdate }</td>
		</tr>
		<tr>
			<th>조회수 </th>
			<td>${board.hits}</td>
		</tr>
		<tr>
			<th>제목 </th>
			<td>${board.title}</td>
		</tr>
		<tr>
			<th>내용 </th> 
			<td><pre>${board.contents}</pre></td>
		</tr>
		<tr>
			<th>파일첨부 </th> 
			<td>
			<!-- 첨부된 파일이 있는 경우, 해당 파일을 다운로드 할 수 있는 링크 제공 -->
			<c:if test="${board.originalfile != null}">
				<a href="download?boardnum=${board.boardnum}">
					${board.originalfile}
				</a>
			</c:if>
			</td>
		</tr>
	</table>
	<a href="list">목록보기</a>
	<c:if test="${loginId == board.id}">
		<a href="update?boardnum=${board.boardnum}">수정하기</a>
		<a href="delete?boardnum=${board.boardnum}">삭제하기</a>
	</c:if>
</body>
</html>