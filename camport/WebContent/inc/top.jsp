<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div id="header" style="width:1280px; margin:0 auto; text-align:center;" >
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/camport/adminNotice/list.do">Notice</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-2">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#" onclick="location.href='/camport/list.do';" title="현재 탭에서 메인 게시판으로 이동합니다.">Main Camport<span class="sr-only">(current)</span></a></li>
						<li><a href="#" onclick="location.href='/camport/communication/list.do';" title="현재 탭에서 커뮤니케이션 화면으로 이동합니다.">SNS</a></li>
						<li><a href="#" onclick="location.href='/camport/freeboard/freeboardlist.do';" title="현재 탭에서 무료서식 게시판으로 이동합니다.">Free Report</a></li>
						<!-- 
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">Extra Menu
								<span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Mypage</a></li>
								<li><a href="#">university</a></li>
								<li><a href="#">community</a></li>
								<li class="divider"></li>
								<li><a href="#">point</a></li>
								<li class="divider"></li>
								<li><a href="#">notice</a></li>
							</ul></li> -->
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					
					<ul class="nav navbar-nav navbar-right">
					
					<c:if test="${empty id}">
					<li style="padding:10px;"><input type="button" value="로그인" onclick="location.href='/camport/login.do';" class="btn btn-primary"></li>
					</c:if>
					
					
					<c:if test="${!empty id}">
					<form method="POST" action="/camport/login/logout.do">
					<li id="logout" style="padding:10px;"><input type="submit" value="로그아웃" class="btn btn-default"></li>
					</form>
					</c:if>
					
					
					
					
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<!-- header 메뉴 -->
