<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Notice</title>
<style>

</style>
<script>
$(document).ready(function() {
	
});
</script>
</head>
<body>
	
	<!--adminnoticeadd.jsp  -->
	<div id="main">
		<%@include file="/inc/top.jsp" %>
		<div id="middle">
		
		<form method="POST" action="/camport/adminnoticeaddok.do" entype="multipart/form-data">
		<table id="tbl1" class="table table-striped">
			<tr>
				<th>제목</th>
				<td><input type="text" name="name" id="name" required class="form-control"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name="content" id="content" required class="form-control"></td>
			</tr>
		
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="attach" id="attach" required class="form-control"></td>
			</tr>
		
		</table>
		<div id="btnList">
			<input type="button" value="돌아가기" class="btn btn-default" onclick="history.back()">
			<input type="submit" value="글쓰기" class="btn btn-primary">
		</div>
		
		<input type="hidden" name="mode" value="${mode}">
		<input type="hidden" name="seq" value="${seq}">
		</form>
			
		</div><!--middle-->	
		<%@include file="/inc/bottom.jsp" %>
	</div><!--main-->

</body>
</html>