<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SelfTest</title>
<script></script>
<style>
#map {
	width: 500px;
	height: 400px;
}
</style>
</head>
<body>

<h1>[ 테스트 ]</h1>
<input type="text" id="contents" name="contents" class="typing-txt">
<br><hr>
<div id="map"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bd2b0c0e16eb6dbde7c4d1d62f1e620c"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(37.511973730287544, 127.05918373339686),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
	</script>
</body>
</html>