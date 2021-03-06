<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>

<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-cache" />

<%@include file="/inc/asset.jsp"%>

<style>
</style>
<script>
	$(document).ready(function() {
		<c:if test="${result == 1}">
		alert("블라인드 처리 완료");
		location.href = "/camport/communication/list.do";
		</c:if>

		<c:if test="${result == 0}">
		alert("블라인드 처리 실패!!");
		history.back();
		</c:if>

		
	});
</script>


</head>

<body>

	<div id="main">
		<%@include file="/inc/top.jsp"%>
		<div id="middle"></div>
	<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="http://xmlns.jcp.org/xml/ns/javaee"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
	version="3.1">
	<display-name>camport</display-name>
	<welcome-file-list>
		<welcome-file>index.html</welcome-file>
		<welcome-file>index.htm</welcome-file>
		<welcome-file>index.jsp</welcome-file>
		<welcome-file>default.html</welcome-file>
		<welcome-file>default.htm</welcome-file>
		<welcome-file>default.jsp</welcome-file>
	</welcome-file-list>
	
	

  
 <!--목록 페이지  -->	
  <servlet>
  	<servlet-name>List</servlet-name>
  	<servlet-class>com.camport.admin.controller.List</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>List</servlet-name>
  	<url-pattern>/adminNotice/list.do</url-pattern>
  </servlet-mapping>
  
<!--글쓰기 페이지  -->	
  <servlet>
  	<servlet-name>Add</servlet-name>
  	<servlet-class>com.camport.admin.controller.Add</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>Add</servlet-name>
  	<url-pattern>/adminNotice/add.do</url-pattern>
  </servlet-mapping>
  
  <!--글쓰기 완료  -->	
  <servlet>
  	<servlet-name>AddOk</servlet-name>
  	<servlet-class>com.camport.admin.controller.AddOk</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>AddOk</servlet-name>
  	<url-pattern>/adminNotice/addok.do</url-pattern>
  </servlet-mapping>
  
    
  <!--내용보기 페이지  -->	
  <servlet>
  	<servlet-name>View</servlet-name>
  	<servlet-class>com.camport.admin.controller.View</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>View</servlet-name>
  	<url-pattern>/adminNotice/view.do</url-pattern>
  </servlet-mapping>
  
  <!--수정하기  -->
    <servlet>
  	<servlet-name>Edit</servlet-name>
  	<servlet-class>com.camport.admin.controller.Edit</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>Edit</servlet-name>
  	<url-pattern>/adminNotice/edit.do</url-pattern>
  </servlet-mapping>
  
    <!--수정처리 페이지  -->
    <servlet>
  	<servlet-name>EditOk</servlet-name>
  	<servlet-class>com.camport.admin.controller.EditOk</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>EditOk</servlet-name>
  	<url-pattern>/adminNotice/editok.do</url-pattern>
  </servlet-mapping>
  
  <!--삭제 페이지  -->
    <servlet>
  	<servlet-name>Dell</servlet-name>
  	<servlet-class>com.camport.admin.controller.Del</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>Dell</servlet-name>
  	<url-pattern>/adminNotice/del.do</url-pattern>
  </servlet-mapping>
  
  <!--삭제처리 페이지  -->
    <servlet>
  	<servlet-name>DelOk</servlet-name>
  	<servlet-class>com.camport.admin.controller.DelOk</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>DelOk</servlet-name>
  	<url-pattern>/adminNotice/delok.do</url-pattern>
  </servlet-mapping>
  
  
  
   <!--로그인 처리 -->
    <servlet>
  	<servlet-name>LoginOk</servlet-name>
  	<servlet-class>com.camport.login.controller.LoginOk</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>LoginOk</servlet-name>
  	<url-pattern>/login/loginok.do</url-pattern>
  </servlet-mapping>
  

  <!--로그인 처리 -->
    <servlet>
  	<servlet-name>Login</servlet-name>
  	<servlet-class>com.camport.login.controller.Login</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>Login</servlet-name>
  	<url-pattern>/login.do</url-pattern>
  </servlet-mapping>
  
  <!--로그아웃 처리 -->
    <servlet>
  	<servlet-name>LogOut</servlet-name>
  	<servlet-class>com.camport.login.controller.LogOut</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>LogOut</servlet-name>
  	<url-pattern>/logout.do</url-pattern>
  </servlet-mapping>
  
    <!--회원가입 처리 -->
    <servlet>
  	<servlet-name>Join</servlet-name>
  	<servlet-class>com.camport.login.controller.Join</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>Join</servlet-name>
  	<url-pattern>/join.do</url-pattern>
  </servlet-mapping>
  
  
  
  <!-- 템플릿 페이지 -->
	<servlet>
		<servlet-name>Template</servlet-name>
		<servlet-class>com.project.main.Template</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>Template</servlet-name>
		<url-pattern>/camport.do</url-pattern>
	</servlet-mapping>
	
	<!-- 목록(list) 페이지 -->
	<servlet>
		<servlet-name>List1</servlet-name>
		<servlet-class>com.project.main.List</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>List1</servlet-name>
		<url-pattern>/list.do</url-pattern>
	</servlet-mapping>
	
	<!-- 글 상세보기(view) 페이지 -->
	<servlet>
		<servlet-name>View</servlet-name>
		<servlet-class>com.project.main.View</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>View</servlet-name>
		<url-pattern>/view.do</url-pattern>
	</servlet-mapping>
	
	<!-- 글쓰기폼(add) 페이지 -->
	<servlet>
		<servlet-name>Add</servlet-name>
		<servlet-class>com.project.main.Add</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>Add</servlet-name>
		<url-pattern>/add.do</url-pattern>
	</servlet-mapping>
	
	<!-- 글쓰기처리(addok) 페이지 -->
	<servlet>
		<servlet-name>AddOk</servlet-name>
		<servlet-class>com.project.main.AddOk</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>AddOk</servlet-name>
		<url-pattern>/addok.do</url-pattern>
	</servlet-mapping>
	
	<!-- 로그인폼(loginPage) 페이지 -->
	<servlet>
		<servlet-name>LoginPage</servlet-name>
		<servlet-class>com.project.main.LoginPage</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>LoginPage</servlet-name>
		<url-pattern>/loginPage.do</url-pattern>
	</servlet-mapping>
	
	
	<!-- 글삭제폼(del) 페이지 -->
	<servlet>
		<servlet-name>Del</servlet-name>
		<servlet-class>com.project.main.Del</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>Del</servlet-name>
		<url-pattern>/del.do</url-pattern>
	</servlet-mapping>
	
	<!-- 글삭제처리(delok) 페이지 -->
	<servlet>
		<servlet-name>DelOk</servlet-name>
		<servlet-class>com.project.main.DelOk</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>DelOk</servlet-name>
		<url-pattern>/delOk.do</url-pattern>
	</servlet-mapping>
	
	
	<!-- 수정하기 -->
	<servlet>
		<servlet-name>Edit</servlet-name>
		<servlet-class>com.project.main.Edit</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>Edit</servlet-name>
		<url-pattern>/edit.do</url-pattern>
	</servlet-mapping>
	
	<!-- 수정 완료 -->
	<servlet>
		<servlet-name>EditOk</servlet-name>
		<servlet-class>com.project.main.EditOk</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>EditOk</servlet-name>
		<url-pattern>/editok.do</url-pattern>
	</servlet-mapping>
	
	
	
	
	<!-- 댓글확인 -->
	<servlet>
		<servlet-name>ReportCommentOk</servlet-name>
		<servlet-class>com.project.main.ReportCommentOk</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>ReportCommentOk</servlet-name>
		<url-pattern>/reportCommentOk.do</url-pattern>
	</servlet-mapping>
	
	<!-- 댓글 삭제 --> 
	<servlet>
		<servlet-name>DelCommentOk</servlet-name>
		<servlet-class>com.project.main.DelCommentOk</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>DelCommentOk</servlet-name>
		<url-pattern>/delCommentOk.do</url-pattern>
	</servlet-mapping>
	
	
	<!-- 신고하기 --> 
	<servlet>
		<servlet-name>Police</servlet-name>
		<servlet-class>com.project.main.Police</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>Police</servlet-name>
		<url-pattern>/police.do</url-pattern>
	</servlet-mapping>
	
	
		<!--  freeboardlist   -->
  <servlet>
  	<servlet-name>FreeBoardList</servlet-name>
  	<servlet-class>com.project.freeboard.FreeBoardList</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>FreeBoardList</servlet-name>
  	<url-pattern>/freeboard/freeboardlist.do</url-pattern>
  </servlet-mapping>
  
  
   <!-- freeboardview  -->
  <servlet>
  	<servlet-name>FreeBoardView</servlet-name>
  	<servlet-class>com.project.freeboard.FreeBoardView</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>FreeBoardView</servlet-name>
  	<url-pattern>/freeboard/freeboardview.do</url-pattern>
  </servlet-mapping>
  
  <!-- freeboardviewok  -->
  <servlet>
  	<servlet-name>FreeBoardViewOk</servlet-name>
  	<servlet-class>com.project.freeboard.FreeBoardViewOk</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>FreeBoardViewOk</servlet-name>
  	<url-pattern>/freeboard/freeboardviewok.do</url-pattern>
  </servlet-mapping>
  
  
  
   <!-- freeboardadd  -->
  <servlet>
  	<servlet-name>FreeBoardadd</servlet-name>
  	<servlet-class>com.project.freeboard.FreeBoardAdd</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>FreeBoardadd</servlet-name>
  	<url-pattern>/freeboard/freeboardadd.do</url-pattern>
  </servlet-mapping>
  
  <!-- freeboardaddok  -->
  <servlet>
  	<servlet-name>FreeBoardaddOk</servlet-name>
  	<servlet-class>com.project.freeboard.FreeBoardAddOk</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>FreeBoardaddOk</servlet-name>
  	<url-pattern>/freeboard/freeboardaddok.do</url-pattern>
  </servlet-mapping>
  
   <!-- freeboarddel  -->
  <servlet>
  	<servlet-name>FreeBoardDel</servlet-name>
  	<servlet-class>com.project.freeboard.FreeBoardDel</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>FreeBoardDel</servlet-name>
  	<url-pattern>/freeboard/freeboarddel.do</url-pattern>
  </servlet-mapping>
  
    <!-- freeboarddelok  -->
  <servlet>
  	<servlet-name>FreeBoardDelOk</servlet-name>
  	<servlet-class>com.project.freeboard.FreeBoardDelOk</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>FreeBoardDelOk</servlet-name>
  	<url-pattern>/freeboard/freeboarddelok.do</url-pattern>
  </servlet-mapping>
  
   <!-- freeboardedit  -->
  <servlet>
  	<servlet-name>FreeBoardEdit</servlet-name>
  	<servlet-class>com.project.freeboard.FreeBoardEdit</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>FreeBoardEdit</servlet-name>
  	<url-pattern>/freeboard/freeboardedit.do</url-pattern>
  </servlet-mapping>
  
<!-- freeboardeditOK  -->
  <servlet>
  	<servlet-name>FreeBoardEditOk</servlet-name>
  	<servlet-class>com.project.freeboard.FreeBoardEditOk</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>FreeBoardEditOk</servlet-name>
  	<url-pattern>/freeboard/freeboardeditok.do</url-pattern>
  </servlet-mapping>
  
   <!-- freecommentok  -->
  <servlet>
  	<servlet-name>FreeBoardCommentOk</servlet-name>
  	<servlet-class>com.project.freeboard.FreeBoardCommentOk</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>FreeBoardCommentOk</servlet-name>
  	<url-pattern>/freeboard/freeboardcommentok.do</url-pattern>
  </servlet-mapping>
  
  
  <!-- freecommentdelok  -->
  <servlet>
  	<servlet-name>FreeBoardCommentDelOk</servlet-name>
  	<servlet-class>com.project.freeboard.FreeBoardCommentDelOk</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>FreeBoardCommentDelOk</servlet-name>
  	<url-pattern>/freeboard/freeboardcommentdelok.do</url-pattern>
  </servlet-mapping>
  
  
    
    
    
</web-app>

















	</div>

</body>
</html>