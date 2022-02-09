<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>[ web99 ]</h1>

<c:if test="${sessionScope.loginId != null}">
	<p>${sessionScope.loginName} (${sessionScope.loginId})님 로그인 중</p>
</c:if>
<ul>
<c:if test="${sessionScope.loginId == null}">
	<li><a href="member/join">회원가입</a></li>
	<li><a href="member/login">로그인</a></li>
</c:if>
<c:if test="${sessionScope.loginId != null}">
	<li><a href="member/logout">로그아웃</a></li>
	<li><a href="member/update">개인정보 수정</a></li>
</c:if>	
	<li><a href="board/list">게시판</a></li>
</ul>

</body>
</html>
