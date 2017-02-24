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

</style>
<script>
$(document).ready(function() {

	<c:if test="${result == 1}">
	alert("수정하기 성공!!");
	location.href = "/camport/adminNotice/view.do?seq=${noticeBoardSeq}";
	</c:if>

	<c:if test="${result == 0}">
	alert("수정하기 실패!!");
	history.back();
	</c:if>

	<c:if test="${result == 0}">
	alert("수정하기 실패!!");
	location.href = "/camport/adminNotice/list.do";
	</c:if>

	
	
});
</script>


</head>

<body>

	<!-- editok.jsp -->
	<div id="main">
		<%@include file="/inc/top.jsp" %>
		<div id="middle"></div>
		<%@include file="/inc/bottom.jsp" %>
	</div>

</body>
</html>



















