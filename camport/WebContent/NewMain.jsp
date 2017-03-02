<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/home.css" />
<title>Wellcome to SeaCamport!</title>
<style>

</style>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<script src="js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script>

</script>
<!-- 윈도우 팝업 실행 문구
<script type="text/javascript">
	window.onload =function () {
	   window.open("http://localhost:8090/camport/images/main/pop.png",  "popup", "width=291, height=319, scrollbars=no, resizable=no, left=150, top=150");
	}
</script> 
-->
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<nav class="navbar navbar-inverse">
			<div class="container-fluid">
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="#">study</a>
			    </div>
			
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
			      <ul class="nav navbar-nav">
			        <li class="active"><a href="#">main<span class="sr-only">(current)</span></a></li>
			        <li><a href="#">Link</a></li>
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
			          <ul class="dropdown-menu" role="menu">
			            <li><a href="#">Action</a></li>
			            <li><a href="#">Another action</a></li>
			            <li><a href="#">Something else here</a></li>
			            <li class="divider"></li>
			            <li><a href="#">Separated link</a></li>
			            <li class="divider"></li>
			            <li><a href="#">One more separated link</a></li>
			          </ul>
			        </li>
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
		</div><!-- header 메뉴 -->
		<!--  메인화면 설계 -->
		<div id="mains">
			<div id="banner">
				<div id="ad"><!-- 광고 이미지 --></div>
				<form class="form-horizontal" id="login">
					<fieldset>
					  <legend>Login</legend>
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
		<div id="footer" class="main">
			<div class="f_main">
				<div class="headf">
					<ul><!-- 목록시작 li a b-->
						<li><a href="#">회사소개</a></li>
						<li><a href="#">이용약관</a></li>
						<li><a href="#"><b>개인정보취급방침</b></a></li>
						<li><a href="#">G포인트 멤버십 회원약관</a></li>
						<li><a href="#">온라인 소비자 패널</a></li>
						<li><a href="#">공정거래</a></li>
						<li><a href="#">CCM</a></li>
						<li class="cs"><a href="tel:080-800-0422"><b>해피캠퍼스 고객기쁨센터</b> / <span>080.800.0422</span></a></li>
						<!-- <li class="button"><button type="button"><img src="images/main/tops.jpg" alt="TOP"/></button></li> -->
					</ul><!-- 목록 종료 -->
				</div><!-- class="headf" 종료 -->
			</div><!-- class="utill" -->
			<div class="content">
				<div>
					<h1><img src="images/main/pros.PNG" alt="해피레포트" style="width: 100px;
		height: 80px; position: relative; left: 80px; bottom: 27px;"/></h1>
					<ul class="info">
						<li class="lines">해피캠퍼스(주) 서울지점 서울시 강남구 한독빌딩 8층</li>
						<li class="lines">대표전화 : 02.2186.8500</li>
						<li>개인정보관리책임자 : 해피장 happycamport@naver.com</li>
						<li class="lines"><a href="#">사업자정보확인</a></li>
						<li class="lines">사업자등록번호 : 120-85-32517</li>
						<li>통신판매업신고 : 강남 351532호</li>
						<li>대표이사 : 피카츄</li>
						<li>Copyright © HappyCamport Health&Living Co, Ltd. All Rights Reserved</li>
					</ul>
					
					<div class="family">
						<div>
							<!-- <a href="#" class="button">FAMILY SITE</a> -->
							<ul>
								<li><a href="#"> 해피캠포트</a></li>
								<li><a href="#"> 자료실</a></li>
								<li><a href="#"> 캠포트정책</a></li>
								<li><a href="#"> 사업자정보</a></li>
								<li><a href="#"> 회사소개</a></li>
								<li><a href="#"> 리포트</a></li>
								<li class="line"><a href="#">메인홈</a></li>
								<li class="line2"><a href="#"> 키워드검색</a></li>
								<li><a href="#"> 공지사항</a></li>
								<li><a href="#"> 커뮤니티 게시판</a></li>
								<li class="line"><a href="#">이메일:happycamport@naver.com</a></li>
								<li class="line2"><a href="#">구매자료</a></li>
								<li><a href="#"> 포인트정책</a></li>
								<li><a href="#"> 무료서식</a></li>
								<li><a href="#"> 이용약관</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--  footer -->
	</div><!--  wrapper -->
</body>
</html>