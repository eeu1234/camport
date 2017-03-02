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
<%@ page import="java.sql.*"%> 
<%@include file="/inc/asset.jsp" %>

<style>

</style>
<script>
$(document).ready(function() {

	<c:if test="${result == 1}">
	alert("수정하기 성공하셨습니다");
	
	location.href = "/camport/view.do?reportBoardSeq=${reportBoardSeq}";
	</c:if>

	<c:if test="${result == 0}">
	alert("수정하기 실패하셨습니다. ㅠ_ㅠ");
	history.back();
	</c:if>

	<c:if test="${result == 2}">
	alert("암호 틀림!!");
	alert("올바르게 적어주세요.");
	history.back();
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



















