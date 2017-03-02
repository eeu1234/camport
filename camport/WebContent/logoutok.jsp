<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

//1. 세션값 해제(인증 해제)
//2. 페이지 이동하기(시작 페이지)

//1.
/*
session.removeAttribute("seq");
session.removeAttribute("email");
session.removeAttribute("name");
session.removeAttribute("isAdmin");
session.removeAttribute("gender"); 
*/

session.removeAttribute("userId");
session.removeAttribute("userName");
session.removeAttribute("name");
session.removeAttribute("adminId");



//2.
%>
<script>
	location.href = "/camport";
</script>


















