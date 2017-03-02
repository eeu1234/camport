<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<title>Wellcome to SeaCamport!</title>
<style>
	#wrapper{
		width:1280px;
		margin:0 auto;
	}
	ul,ol{
		list-style:none;
	}
	#mains {
	       width: 100%;
	       border: 1px solid blue;
	       
	     }
	#ad{
		/* 너비폭은 유지 */
		width: 800px;
		height:300px;
		border-bottom:3px solid red;
		position:relative;
		background-image: url("images/main/sea.jpg");
		background-repeat: no-repeat;
		background-size: 800px 300px;
	}
	#ad:hover{
		background-image:url("images/main/ground.jpg");
		background-repeat: no-repeat;
		background-size: 800px 300px;
		transition: 5.0s; /* event 전환 효과 5초*/
	}
	#login{
		width:479px;
		height:300px;
		background-color:#cfc;
		position:relative;
		bottom:300px;
		right:-799px;
		/* top:123px; */
		/* top: 73px; */
		/*템플릿 불러오는 과정 중 header메뉴 내려옴*/
		/* right:163px; */
		/* right:312px; */
		/* 연한초록 - 위치 확인값 */	
	}
	#buttons1{ /* 로그인 */
		position: absolute;
		right: 90px;
		bottom: 100px;
	}
	#buttons2{ /* 회원가입 */
		position: absolute;
		right: 10px;
		bottom: 100px;
	}
	#buttons3{
		position: absolute;
		right: 180px;
		bottom: 100px;
	}
	/* 메인 테이블 3가지 */
	#mains .contents01{
		position:relative;
		width: 400px;
		margin:20px 10px 10px 10px;
		display:inline-block;
	}
	#mains .contents01 thead tr th{
		text-align:center;
	}
	#slide{
		width:1280px;
		height:200px;
		margin-bottom:50px;
	}
	#slide div{
		display:inline-block;
	}
/* 버튼 */
	.second button{
		border:1px solid #dfdfdf;
		border-radius:5px;
		color:#999;
		width:240px;
		height:50px;
		text-align:center;
		line-height:30px;
		padding-left:40px;
		position:relative;
		background:-webkit-linear-gradient(#fff 1px,#ececec 1px,#dbdbdb,#ececec);
		box-shadow:0 3px 5px rgba(0,0,0,0.4);
	}
	
	.btn_21 span{
		display:block;
		background-image:-webkit-linear-gradient(#ffc126,#f77d28);
		border:1px solid #c68b49;
		border-radius:2px;
		position:absolute;
		left:8px;
		top:-4px
	}
	.btn_21 span:after{
		display:block;
		content:"";
		width:28px;
		height:25px;
		background:url(images/main/ico01.png) no-repeat center;
		background-size:auto 22px
	}/* second button */
	.btn_22 span{
		display:block;
		background-image:-webkit-linear-gradient(#4082c6,#1c52a2);
		border:1px solid #6985b3;
		border-radius:2px;
		position:absolute;
		left:8px;
		top:-4px;
	}
	.btn_22 span:after{
		display:block;
		content:"";
		width:28px;
		height:25px;
		background:url(images/main/ico02.png) no-repeat center;
		background-size:auto 22px;
	}
	.btn_23 span{
		display:block;
		background-image:-webkit-linear-gradient(#df1d16,#9a1d20);
		border:1px solid #ab666a;
		border-radius:2px;
		position:absolute;
		left:8px;
		top:-4px;
	}
	.btn_23 span:after{
		display:block;
		content:"";
		width:28px;
		height:25px;
		background:url(images/main/ico03.png) no-repeat center;
		background-size:auto 22px;
	}
	.btn_24 span{
		display:block;
		background-image:-webkit-linear-gradient(#98b540,#609437);
		border:1px solid #a3bb98;
		border-radius:2px;
		position:absolute;
		left:8px;
		top:-4px;
	}
	.btn_24 span:after{
		display:block;
		content:"";
		width:28px;
		height:25px;
		background:url(images/main/ico04.png) no-repeat center;
		background-size:auto 22px;
	}
	#shortcut .second li button:hover{color:red;}
	
	#menu_btn {
		width: 940px;
		height: 200px;
		text-align:center;
		margin-left: 20px;
		position: absolute;
		border:2px solid #000;
		background-color:#fff;
	}
	#menu_btn div{
		display:inline-block;
		width:150px;
		margin:10px;
		height:150px;
	}
	#menu_btn div:hover{
		border:1px solid green;
		transition: 1.0s; /* event 전환 효과 1초*/
	}
	#menu_btn .pays a img{
		margin-bottom:18px;
	}
	#footer{
		wdith:1280px;
		height:200px;
		border:2px solid green;
		position:relative;
		background-color: #eee;
	} 
 	
	#footer .f_main ul li{
		height:20px;
		line-height:20px;
		padding-left:10px;
		padding-right:10px;
		background-color: #eee;
		display:inline-block;
	} /
	
	/* ************* footer ************* */
	#footer div.content ul.info li.lines{
		background:none;
	}
	#footer div.content span{
		display:inline-block;
		padding-left:53px;
		color:#666;
		margin-bottom:40px;
	}
	#footer div.content h1{
		float:left;
		padding:10px 0 0 6px;
	}
	#footer div.content ul.info{
		margin-left:155px;
		overflow:hidden;
		width:650px;
		/* 650px */
	}
	#footer div.content ul.info li{
		float:left;
		font-size:13px;
		line-height:22px;
		padding:0 12px 0 10px;
		color:#666;
	}
	#footer div.content ul.info li a{
		color:#8c8b8b;
		border:1px solid #8c8b8b;
		border-radius:3px;
		padding:0 10px;
	} 
	#footer div.content div.family{
		position:absolute;
		top:40px;
		right:0;
	}
	
	#footer div.content div.family div{ /*삭제 - Family site*/
	position:relative;
	display:inline-block;
	}
	
	#footer div.content div.family a.button{
		color:#434343;
		font-size:13px;
		width:173px;
		line-height:35px;
		border:1px solid #7e7e7e;
		padding:0 10px;
	}
	#footer div.content div.family ul {
		position:absolute;
		bottom:0;
		border:1px solid #7e7e7e;
		background-color:#fff;
		margin:0;
		width:100%;
		padding:15px 0;
		display:none;
	}
	#footer div.content div.family ul li.line{
		border-bottom:1px solid #7a7a7a;
	}
	#footer div.content div.family ul li.line a{
		margin-bottom:12px;
	}
	#footer div.content div.family ul li.line2 a{
		margin-top:13px;
	}
	#footer div.content div.family ul li a{
		color:#7a7a7a;
		line-height:20px;
		font-size:13px;
		padding:1px 20px;
	}
	#footer div.content div.family ul li a:hover{
		background-color:#f1f1f1;
	}
	#footer .f_main .headf{margin-top:10px; padding:10px;}
	
	#footer div.content div{
		width:1000px;
	}
	/*
		footer
	*/
		
</style>
<script type="text/javascript" src="js/bootstrap.js" ></script>
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
			<div id="sum_main" style="height:300px;">
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