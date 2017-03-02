<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/camport/css/bootstrap.css">

<style>
.footer-bs {
	background-color: #3c3d41;
	padding: 60px 40px;
	color: rgba(255, 255, 255, 1.00);
	margin-bottom: 20px;
	border-bottom-right-radius: 6px;
	border-top-left-radius: 0px;
	border-bottom-left-radius: 6px;
}

.footer-bs .footer-brand, .footer-bs .footer-nav, .footer-bs .footer-social,
	.footer-bs .footer-ns {
	padding: 10px 25px;
}

.footer-bs .footer-nav, .footer-bs .footer-social, .footer-bs .footer-ns
	{
	border-color: transparent;
}

.footer-bs .footer-brand h2 {
	margin: 0px 0px 10px;
}

.footer-bs .footer-brand p {
	font-size: 12px;
	color: rgba(255, 255, 255, 0.70);
}

.footer-bs .footer-nav ul.pages {
	list-style: none;
	padding: 0px;
}

.footer-bs .footer-nav ul.pages li {
	padding: 5px 0px;
}

.footer-bs .footer-nav ul.pages a {
	color: rgba(255, 255, 255, 1.00);
	font-weight: bold;
	text-transform: uppercase;
}

.footer-bs .footer-nav ul.pages a:hover {
	color: rgba(255, 255, 255, 0.80);
	text-decoration: none;
}

.footer-bs .footer-nav h4 {
	font-size: 11px;
	text-transform: uppercase;
	letter-spacing: 3px;
	margin-bottom: 10px;
}

.footer-bs .footer-nav ul.list {
	list-style: none;
	padding: 0px;
}

.footer-bs .footer-nav ul.list li {
	padding: 5px 0px;
}

.footer-bs .footer-nav ul.list a {
	color: rgba(255, 255, 255, 0.80);
}

.footer-bs .footer-nav ul.list a:hover {
	color: rgba(255, 255, 255, 0.60);
	text-decoration: none;
}

.footer-bs .footer-social ul {
	list-style: none;
	padding: 0px;
}

.footer-bs .footer-social h4 {
	font-size: 11px;
	text-transform: uppercase;
	letter-spacing: 3px;
}

.footer-bs .footer-social li {
	padding: 5px 4px;
}

.footer-bs .footer-social a {
	color: rgba(255, 255, 255, 1.00);
}

.footer-bs .footer-social a:hover {
	color: rgba(255, 255, 255, 0.80);
	text-decoration: none;
}

.footer-bs .footer-ns h4 {
	font-size: 11px;
	text-transform: uppercase;
	letter-spacing: 3px;
	margin-bottom: 10px;
}

.footer-bs .footer-ns p {
	font-size: 12px;
	color: rgba(255, 255, 255, 0.70);
}

@media ( min-width : 768px) {
	.footer-bs .footer-nav, .footer-bs .footer-social, .footer-bs .footer-ns
		{
		border-left: solid 1px rgba(255, 255, 255, 0.10);
	}
}
</style>
<script src="/camport/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<section style="height: 80px;"></section>
		<div class="row" style="text-align: center;">
			<!-- <h2>Dark Footer</h2> -->
		</div>
		<!----------- Footer ------------>
		<footer class="footer-bs">
			<div class="row">
				<div class="col-md-3 footer-brand animated fadeInLeft">
					<h3>HappComport info</h3>
					<p>Suspendisse hendrerit tellus laoreet luctus pharetra.
						Aliquam porttitor vitae orci nec ultricies. Curabitur vehicula,
						libero eget faucibus faucibus, purus erat eleifend enim, porta
						pellentesque ex mi ut sem.</p>
					<p>© 2017 Happy Camport, All rights reserved</p>
				</div>
				<div class="col-md-4 footer-nav animated fadeInUp">
					<h4>Menu —</h4>
					<div class="col-md-6">
						<ul class="pages">
							<li><a href="#">Study</a></li>
							<li><a href="#">Notice</a></li>
							<li><a href="#">Chrome</a></li>
							<li><a href="#">Company</a></li>
							<li><a href="#">Advice</a></li>
						</ul>
					</div>
					<div class="col-md-6">
						<ul class="list">
							<li><a href="#">communication</a></li>
							<li><a href="#">TeamView</a></li>
							<li><a href="#">SNS</a></li>
							<li><a href="#">Policy</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-2 footer-social animated fadeInDown">
					<h4>Follow System</h4>
					<ul>
						<li><a href="#">Facebook</a></li>
						<li><a href="#">Twitter</a></li>
						<li><a href="#">Instagram</a></li>
						<li><a href="#">KaKaoTalk</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-ns animated fadeInRight">
					<h4>Newsletter</h4>
					<p>A rover wearing a fuzzy suit doesn’t alarm the real penguins</p>
					<p>
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for..."> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">
								<span class="glyphicon glyphicon-envelope"></span>
							</button>
						</span>
					</div>
					<!-- /input-group -->
					</p>
				</div>
			</div>
		</footer>
		<section style="text-align: center; margin: 10px auto;">
			<p>
				Copy@right <a href="http://enfoplus.net">Happy Camport World</a>
			</p>
		</section>
	</div>


</body>
</html>