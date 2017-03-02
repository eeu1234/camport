<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit</title>

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
	
});

</script>


</head>

<body>

	<!-- edit.jsp -->
	<div id="wrapper">
		<%@include file="/inc/top.jsp" %>
		<div id="middle">
		
		<form method="POST" action="/camport/editok.do">
			<table id="tbl1" class="table table-striped">
				<tr>
					<th>유저ID</th>
					<td><input type="text" name="userId" id="name" required class="form-control" value="${dto.userId}"></td>
				</tr>
				<tr>
					<th>소개글</th>
					<td><input type="text" name="reportBoardSummary" id="summary" class="form-control" value="${dto.reportBoardSummary}"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="reportBoardName" id="subject" required class="form-control" value="${dto.reportBoardName}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="reportBoardContent" id="content" required class="form-control">${dto.reportBoardContent}</textarea>
					</td>
				</tr>
				<tr>
					<th>암호</th>
					<td><input type="password" name="pw" id="pw" required class="form-control">비밀번호 보기: ${dto.pw}</td>
				</tr>
				<tr>
					<th>단과대학 번호</th>
					<td><input type="number" name="collageSeq" id="collage" class="form-control">${dto.collageSeq}</td>
				</tr>
			</table>
			<div id="btnList">
				<input type="button" value="돌아가기" class="btn btn-default"
						onclick="history.back();">
				<input type="submit" value="수정하기" class="btn btn-primary">
			</div>
		
		<!-- 수정할 글번호 -->
		<input type="hidden" name="reportBoardSeq" value="${dto.reportBoardSeq}">
		<input type="hidden" name="collageSeq" value="${dto.collageSeq}">
		</form>
		
		</div>
		<%@include file="/inc/Dark_footer.jsp" %>
	</div>

</body>
</html>



















