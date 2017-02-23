<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Notice</title>

<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/> 
<meta http-equiv="Pragma" content="no-cache"/>

<%@include file="/inc/asset.jsp"%>

<style>
#tbl1{width:800px; margin:0px auto;}

#tbl1 th{width:150px; text-align:center;}
#tbl1 td{width:650px;}
#tbl1 #name,#tbl1 #tag,#tbl1 #pw{width:150px;}
#tbl1 #content{height:300px;}
#btnList{width:800px; margin:30px auto;}

</style>

<script>



</script>

</head>
<body>

	<!--admin  -->
	<div id="main">
		<%@include file="/inc/top.jsp" %>
	<div id="middle">
		<form method="POST" action="/camport/adminNotice/addok.do">
			<table id="tbl1" class="table table-striped">
				<tr>
					<th>아이디</th>
					<td><input type="email" name="email" id="email" required class="form-control"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="subject" id="subject" required class="form-control"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" id="content" required class="form-control"></textarea></td>
				</tr>
			</table>
			<div id="btnList">
				<input type="button" value="돌아가기" class="btn btn-default" onclick="history.back();">
				<input type="submit" value="글쓰기" class="btn btn-primary">
			</div>
		</form>
		
	</div><!--middle-->
	<%@include file="/inc/bottom.jsp" %>
	</div><!--main-->




	

</body>
</html>