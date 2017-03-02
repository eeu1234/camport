<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>del</title>

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

	<!-- del.jsp -->
	<div id="wrapper">
		<%@include file="/inc/top.jsp" %>
		<div id="middle">
		
		<form method="POST" action="/camport/delOk.do">
		<table id="tbl1" class="table table-striped">
			<tr>
				<th>암호</th>
				<td><input type="password" name="pw" id="pw" required class="form-control"></td>
			</tr>
		</table>
		<div id="btnList">
			<input type="button" value="돌아가기" class="btn btn-default"
					onclick="history.back();">
			<input type="submit" value="삭제하기" class="btn btn-primary">
		</div>
		
		<!-- 삭제할 글번호 -->
		<input type="hidden" name="reportBoardSeq" id="seq" value="${reportBoardSeq}">
		</form>
		
		</div>
		<%@include file="/inc/Dark_footer.jsp" %>
	</div>

</body>
</html>



















