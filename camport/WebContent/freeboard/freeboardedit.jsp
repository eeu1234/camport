<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>

<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/> 
<meta http-equiv="Pragma" content="no-cache"/>

<%@include file="/inc/asset.jsp" %>

<style>
	
#tbl1 { width: 800px; margin: 30px auto; }

#tbl1 th { width: 150px; text-align: center; }
#tbl1 td { width: 650px; }
#tbl1 #name, #tbl1 #tag, #tbl1 #pw { width: 150px; }
#tbl1 #content { height: 200px; }
#btnList { width: 800px; margin: 30px auto; }
	
</style>
<script>
$(document).ready(function() {
	//init();
});

function init() {

}
</script>


</head>

<body>

	<!-- edit.jsp -->
	<div id="main">
		<%@include file="/inc/top.jsp" %>
		<div id="middle">
		
		<form method="POST" action="/camport/freeboard/freeboardeditok.do">
		<table id="tbl1" class="table table-striped">
			<tr>
				<th>이름</th>
				<td>${id}  <input type="hidden" name="userId" value="${id}"></td>
				
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="freeBoardName" id="subject" required class="form-control" value="${dto.freeBoardName}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="freeBoardContent" id="content" required class="form-control">${dto.freeBoardContent}</textarea>
				</td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="freeboardPw" id="pw" required class="form-control"></td>
			</tr>
		</table>
		<div id="btnList">
			<input type="button" value="돌아가기" class="btn btn-default"
					onclick="history.back();">
			<input type="submit" value="수정하기" class="btn btn-primary">
		</div>
		
		<!-- 수정할 글번호 -->
		<input type="hidden" name="freeBoardSeq" value="${dto.freeBoardSeq}">
		</form>
		
		</div>
		<%@include file="/inc/Dark_footer.jsp" %>
	</div>

</body>
</html>


