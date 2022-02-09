<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL2</title>
</head>
<body>
	<h1>함수 라이브러리 사용</h1>
	
	<c:forTokens var="value" items="${str }" delims=" ">
		<p>${value }</p>
	</c:forTokens>
	<hr>
	<p>원본문자열 : ${str}</p>
	<p>substring: ${fn:substring(str, 2, 5) }</p>
	<p>toUpperCase: ${fn:toUpperCase(str) }</p>
	<p>toLowerCase: ${fn:toLowerCase(str) }</p>
	<p>length: ${fn:length(str)}</p>
	<span>split: 
		<c:set var="ar" value="${fn:split(str, ' ')}" />
		<c:forEach var="i" items="${ar}">
			<p>${i }</p>
		</c:forEach>
	</span>
	<hr>


</body>
</html>