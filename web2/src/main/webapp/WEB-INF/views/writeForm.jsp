<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post method로 parameter보내기</title>
</head>
<body>
	<h1>WriteForm</h1>
	
	<form action="write" method="POST">
		이름: <input type="text" name="name"><br>
		전화번호: <input type="text" name="phone"><br>
		통신사: <input type="radio" name="com" value="kt">KT
				<input type="radio" name="com" value="lg">LG
				<input type="radio" name="com" value="skt">SKT
		<input type="submit" value="전송">
	</form>
</body>
</html>