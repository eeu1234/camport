<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<div id="header">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">study</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-2">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#" onclick="location.href='/camport/camport.do';">main<span class="sr-only">(current)</span></a></li>
						<li><a href="#" onclick="location.href='/camport/loginPage.do';" title="현재 탭에서 로그인화면으로 이동합니다.">login / register</a></li>
						<li><a href="#" onclick="location.href='/camport/list.do';" title="현재 탭에서 게시판 목록으로 이동합니다.">게시판 목록</a></li>
						<li><a href="#" onclick="location.href='/camport/add.do';" title="현재 탭에서 게시판 글쓰기로 이동합니다.">글쓰기</a></li>
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
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Link</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<!-- header 메뉴 -->