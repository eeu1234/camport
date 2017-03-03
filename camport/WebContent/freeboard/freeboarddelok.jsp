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
	alert("삭제하기 성공!!");
	location.href = "/camport/freeboard/freeboardlist.do?freeBoardSeq=${freeBoardSeq}";
	</c:if>

	<c:if test="${result == 0}">
	alert("삭제하기 실패!!");
	history.back();
	</c:if>

	<c:if test="${result == 2}">
	alert("암호 틀림!!");
	history.back();
	</c:if>
	
});
</script>


</head>

<body>

	<!-- delok.jsp -->
	<div id="main">
		<%@include file="/inc/top.jsp" %>
		<div id="middle"></div>
		<%@include file="/inc/Dark_footer.jsp" %>
	</div>

</body>
</html>

