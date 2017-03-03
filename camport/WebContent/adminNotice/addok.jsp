<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD</title>
<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/> 
<meta http-equiv="Pragma" content="no-cache"/>

<%@include file="/inc/asset.jsp"%>

</head>
<script>
$(document).ready(function() {
	<c:if test="${result == 1}">
	alert("축하합니다 글쓰기 성공하셨습니다.");
	location.href="/camport/adminNotice/list.do";
	</c:if>

	<c:if test="${result == 0}">
	alert("글쓰기 실패!!");
	history.back();
	</c:if>
});

</script>
<body>

	<!--addok.jsp  -->
	<div id="wrapper">
		<%@include file="/inc/top.jsp" %>
		<div id="middle"></div>
		<%@include file="/inc/Dark_footer.jsp" %> %>
	</div>
	

</body>
</html>