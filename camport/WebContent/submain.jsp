<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/slide.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<title>Insert title here</title>
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
			      <a class="navbar-brand" href="#">공부</a>
			    </div>
			
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
			      <ul class="nav navbar-nav">
			        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
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
		</div>
		<div class="menu">
			<h2>단과대</h2>
			<ul>
				<li>
					<a href="#">기타</a>
					<ul>
						<li><a href="#">SNS게시판</a></li>
						<li><a href="#">공지사항</a></li>
					</ul>
				</li>
				<li>
					<a href="#">단과대</a>
					<ul>
						<li><a href="#">자료글</a></li>
						<li><a href="#">인기글</a></li>
					</ul>
				</li>
				<li>
					<a href="#">회원</a>
					<ul>
						<li><a href="#">마이페이지</a></li>
						<li><a href="#">즐겨찾기</a></li>
						<li><a href="#">내가쓴글</a></li>
					</ul>
				</li>
				<li>
					<a href="#">대학교</a>
					<ul>
						<li><a href="#">대학교</a></li>
						<li><a href="#">단과대학</a></li>
						<li><a href="#">전공선택</a></li>
					</ul>
				</li>
				<li><a href="#">찾아오시는 길</a></li>
			</ul>
		</div>	
		
		<div id="footer">
			방가방가
		</div>
		<script>
		$('.menu ul ul').hide();
		$('.menu>ul>li>a').click(function(){
			/*
				//클래스 이름이 없으며 slideDown, 있으면 slideUp
				$(this).parent().toggleClass('active');
				$(this).next().slideToggle(200);
			*/
			//클래시 해당 2dep만 열림
			$(this).parent().addClass('active').siblings().removeClass('active');
			$('.menu>ul>li').each(function(){
				//li 클래스 있으면 자식ul slideDown, 없으면 slideup
				var tit=$(this).attr('class');
				if(tit) $(this).find('ul').slideDown(200);
				else $(this).find('ul').slideUp(200);
			});
			//약도를 클릭시 경고창 띄워주세요
			if($(this).parent().has('ul').length) console.log("ok");
			//if($(this).parent().children('ul').length) console.log("ok");
			else alert('점검중입니다');
		});
		</script>	
	</div>	
</body>
</html>