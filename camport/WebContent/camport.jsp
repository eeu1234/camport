<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해피레포트 메인</title>

<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/> 
<meta http-equiv="Pragma" content="no-cache"/>

<%@include file="/inc/asset.jsp" %> <!-- css js -->

<style>

</style>
</head>

<body>

	<div id="wrapper">
		<%@include file="/inc/top.jsp" %>
		<div id="mains">
			<div id="sum_main" style="height:300px;">
				<div id="ad"><!-- 광고 이미지 --></div>
				<form class="form-horizontal" id="login">
					<fieldset>
					  <legend>Login</legend>
					  <h1 style="font-size:20px; font-weight:bold; padding:10px; margin-bottom:15px; border-bottom:2px solid #000;">Login</h1>
					  <div class="form-group">
					  	<label for="inputEmail" class="col-lg-2 control-label">Email</label>
					    <div class="col-lg-10">
					    	<input type="text" class="form-control" id="inputEmail" placeholder="Email">
					    </div>
					  </div><!-- Email -->
					  <div class="form-group">
					  	<label for="inputPassword" class="col-lg-2 control-label">Password</label>
					    <div class="col-lg-10">
					    	<input type="password" class="form-control" id="inputPassword" placeholder="Password">
					  </div><!-- Password -->
					  <button class="btn btn-primary btn-sm" type="button" id="buttons1">ID/PW찾기</button>
					  <button class="btn btn-primary btn-sm" type="button" id="buttons2">회원가입</button>
					  <button class="btn btn-primary btn-sm" type="button" id="buttons3">로그인</button>
					</fieldset>
				</form>
			</div><!--  banner -->
			<div class="contents01">
				<table class="table table-striped table-hover ">
				  <thead>
				    <tr>
				      <th>#</th>
				      <th>제목</th>
				      <th>등록일</th>
				      <th>조회수</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr class="info">
				      <td>3</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				    <tr class="success">
				      <td>4</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				    <tr class="danger">
				      <td>5</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				    <tr class="warning">
				      <td>6</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				    <tr class="active">
				      <td>7</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				  </tbody>
				</table> 
			</div>
			<div class="contents01">
				<table class="table table-striped table-hover ">
				  <thead>
				    <tr>
				      <th>#</th>
				      <th>제목</th>
				      <th>등록일</th>
				      <th>조회수</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr class="info">
				      <td>3</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				    <tr class="success">
				      <td>4</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				    <tr class="danger">
				      <td>5</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				    <tr class="warning">
				      <td>6</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				    <tr class="active">
				      <td>7</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				  </tbody>
				</table> 
			</div>
			<div class="contents01">
				<table class="table table-striped table-hover ">
				  <thead>
				    <tr>
				      <th>#</th>
				      <th>제목</th>
				      <th>등록일</th>
				      <th>조회수</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr class="info">
				      <td>3</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				    <tr class="success">
				      <td>4</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				    <tr class="danger">
				      <td>5</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				    <tr class="warning">
				      <td>6</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				    <tr class="active">
				      <td>7</td>
				      <td>Column content</td>
				      <td>Column content</td>
				      <td>Column content</td>
				    </tr>
				  </tbody>
				</table> 
			</div>
			<div id="slide"><!-- 버튼 바로가기 메뉴 -->
				<div id="shortcut">
					<ul class="second">
						<li><button type="button" class="btn_21">커뮤니케이션<span></span></button></li>
						<li><button type="button" class="btn_22">마이페이지<span></span></button></li>
						<li><button type="button" class="btn_23">게시판 검색<span></span></button></li>
						<li><button type="button" class="btn_24">즐겨찾기<span></span></button></li>
					</ul>
				</div>
				<div id="menu_btn">
					<div><a href="#" title="검색" target="_blank"><img src="images/main/search.png" alt="search" /></a></div>
					<div><a href="#" title="무료서식" target="_blank"><img src="images/main/free.png" alt="freeDownload" /></a></div>
					<div class="pays" title="유료다운" target="_blank"><a href="#"><img src="images/main/download.png" alt="payDownload" /></a></div>
					<div><a href="#" title="문서*레포트" target="_blank"><img src="images/main/document.png" alt="document" /></a></div>
				</div>
			</div><!-- 버튼 바로가기 메뉴 -->
		</div>	<!--  mains END -->
		<%@include file="/inc/bottom.jsp" %>
	</div>

</body>
</html>



















