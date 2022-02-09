<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
<style type="text/css">
	/* Css주석 */
</style>
<script type="text/javascript">
	//Js주석
	/* Js주석 */
</script>
</head>
<body>
<!-- HTML주석 -->
<%-- JSP주석 --%>

	<h1>[ JSTL 코어 라이브러리 ]</h1>
	<p>${requestScope.number}</p>
	<p>${number * 2}</p>
	<p>${number == 2}</p>
	<c:if test="${(number%2) != 0}" >
		<p>출력</p>
	</c:if>
	<p>${str }</p>
	
	<hr>
	<p>forEach</p>
	<c:forEach var="i" begin="0" end="${list.size()-1 }">
		<p>${list.get(i)}</p>
	</c:forEach>
	
	<c:forEach var="value" items="${list }">
		<p>${value}</p>
	</c:forEach>
	
	<hr>
	<c:forEach var="i" begin="0" end="${list.size()-1 }">
		<c:choose>
			<c:when test="${list.get(i) == 'aaa'}">
				[${i} : ${list[i] = 'hello'}]
			</c:when>
			<c:otherwise>
				[${i} : ${list.get(i)}]
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<br>
	<c:forEach items="${list }" var="i" varStatus="status">
		<c:choose>
			<c:when test="${i == 'aaa'}">
				${i = 'hello'}
			</c:when>
			<c:otherwise>
				${i}
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<hr>
	<p>${list }</p>
	<p>${phone }</p>
	<p>${data }</p>
	
	
	<hr>
	<!-- forEach활용 (select문 반복) -->
	<select>
		<c:forEach var="i" begin="1" end="12">
			<option>${i }</option>
		</c:forEach>
	</select>월
		<select>
		<c:forEach var="i" begin="1" end="31">
			<option>${i }</option>
		</c:forEach>
	</select>일
	<hr>
	
	<!-- forTokens -->
	<table border="1">
		<c:forTokens var="value" items="${phone }" delims="-">
			<tr><td>${value }</td></tr>
		</c:forTokens>
	</table>
	
	<hr>
	<p>* out</p>
	<!-- 정확히 데이터만 가져옴 태그 안읽어 -->
	<P><c:out value="${data }"></c:out></P>
	
	<p>* url</p>
	<p>절대<img src="/resources/image/home.png"></p>
	<p>상대<img src="resources/image/home.png"></p>
	<!-- 정확한 위치를 가져와 줌 -->
	<p>url<img src="<c:url value="/resources/image/home.png" />"></p>
	
	
</body>
</html>