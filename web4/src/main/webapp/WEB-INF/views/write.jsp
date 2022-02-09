<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 글쓰기</title>
</head>
<body>
<h1>[ 방명록 글쓰기 ]</h1>

<form action="write" method="post">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" id="name" name="name" required="required"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" id="password" name="password" required="required"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea name="content" id="content" required="required"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="저장"></td>
		</tr>
	</table>
</form>


</body>
</html>