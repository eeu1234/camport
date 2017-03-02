<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
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




</script>
</head>
<body>

	<!--view.jsp  -->
	<div id="main">
		<%@include file="/inc/top.jsp" %>
		<div id="middle">
			<table id="tbl1" class="table tale-striped">
				<tr>
					<th>번호</th>
					<td>${dto.noticeBoardSeq}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${dto.noticeBoardName}</td>
				</tr>
		
				<tr style="height:300px;">
					<th style="vertical-align:middle;">내용</th>
					<td style="vertical-align:middle;">${dto.noticeBoardContent}</td>
				</tr>
				<tr>
					<th>날짜</th>
					<td>${dto.noticeBoardRegdate}</td>
				</tr>
				<tr>
					<th>읽음</th>
					<td>${dto.noticeBoardReadcount}</td>
				</tr>
			</table>
			<div id="btnList">
				<input type="button" value="돌아가기"  class="btn btn-default"
					onclick="location.href='/camport/adminNotice/list.do';">
				<input type="button" value="수정하기" class="btn btn-primary"
					onclick="location.href='/camport/adminNotice/edit.do?seq=${dto.noticeBoardSeq}';">
				<input type="button" value="삭제하기" class="btn btn-primary" 
					onclick="location.href='/camport/adminNotice/del.do?seq=${dto.noticeBoardSeq}';">
			</div>
		</div>
	</div>
	

</body>
</html>