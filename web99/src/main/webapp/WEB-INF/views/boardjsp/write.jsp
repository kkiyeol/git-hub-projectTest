<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[ 글쓰기 ]</title>
</head>
<body>
<div class="centerdiv">
<h1>[ 글쓰기 ]</h1>
<!-- 바이너리 데이터 포함되는 폼. enctype 반드시 정확히 지정 -->
<form id="writeform" action="write"  method="post" 
	enctype="multipart/form-data" onsubmit="return formCheck();">
	
<table>
<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" id="title" style="width:400px;">
	</td>
</tr>
<tr>
	<th>내용</th> 
	<td>
		<textarea name="contents" id="contents" style="width:400px;height:200px;resize:none;"></textarea>
	</td>
</tr>
<tr>
	<th>파일첨부</th> 
	<td>
		<input type="file" name="upload" size="30">
	</td>
</tr>
<tr>
	<td colspan="2" class="white center">
		<input type="submit" value="저장" />
	</td> 
</tr>
</table>
</form>
</div>
</body>
</html>