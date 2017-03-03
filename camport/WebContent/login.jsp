<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<html>
<style>
#main, #header {
	background-image: url("flower.jpg");
}
</style>

<head>
<title>CAMPORT</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="css/main.css" />
<%@include file="/inc/asset.jsp"%>
<noscript>
	<link rel="stylesheet" href="css/noscript.css" />
</noscript>
</head>
<style>
#iid {
	background-color: black;
	font-weight: bold;
	color: white;
}

#name {
	background-color: black;
	font-weight: bold;
	color: white;
}

#tel {
	background-color: black;
	font-weight: bold;
	color: white;
}

#ppw {
	background-color: black;
	font-weight: bold;
	color: white;
}

#camport {
	color: black;
	font-weight: bold;
}

#welcome {
	color: black;
	font-weight: bold;
}

#join {
	color: black;
	font-size: 15pt;
	font-weight: bold;
}

#join img {
	width: 50px;
	height: 50px;
}

#main .field half first {
	color: white;
}
</style>
<script>
	$(function() {

		$("#frm").on("keydown", function(e) {
			if (e.which == 13) {
				$("#frm").submit();
			}

		})

	})

	/*aJax 학교->단과대학 */
	function ajaxCommList(event) {
		var universeSeq = $(event.srcElement).val();
		console.log(universeSeq);
		//var str = $(event.srcElement).parents('form:first').serialize();
		//var str = $(event.srcElement).parents('form:first').children();
		var str = {
			"universe" : universeSeq
		};
		console.log(str);
		$.ajax({
			type : "GET",
			url : "/camport/login/selectmajor.do",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			data : str,
			datatype : "json",
			success : function(data) {
				if (data.length != 0) {
					$.each(data, function(intValue, currentElement) {
						var colNameVAL = "";
						var colSeqVAL = "";
						$.each(currentElement, function(key, value) {
							//console.log(key);
							//console.log(value);
							if (key == "colName") {
								colNameVal = value;
							} else if (key == "colSeq") {
								//console.log(value);
								colSeqVal = value;
							}

						});
						$("#collage").append(
								"<option value="+colSeqVal+">" + colNameVal
										+ "</option>");
					});

				} else {
				}

			},
			error : function(e) {
				//alert("에러발생");
			}
		});
	}
	/*aJax 단과->전공 */
	function ajaxCommList2(event) {
		var collageSeq = $(event.srcElement).val();
		console.log(collageSeq);
		//var str = $(event.srcElement).parents('form:first').serialize();
		//var str = $(event.srcElement).parents('form:first').children();
		var str = {
			"collage" : collageSeq
		};
		console.log(str);
		$.ajax({
			type : "GET",
			url : "/camport/login/selectmajor.do",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			data : str,
			datatype : "json",
			success : function(data) {
				if (data.length != 0) {
					$.each(data, function(intValue, currentElement) {
						var majorNameVAL = "";
						var majorSeqVAL = "";
						$.each(currentElement, function(key, value) {
							//console.log(key);
							//console.log(value);
							if (key == "majorName") {
								majorNameVAL = value;
							} else if (key == "majorSeq") {
								//console.log(value);
								majorSeqVAL = value;
							}

						});
						$("#major").append(
								"<option value="+majorSeqVAL+">" + majorNameVAL
										+ "</option>");
					});

				} else {
				}

			},
			error : function(e) {
				//alert("에러발생");
			}
		});
	}
</script>
<!-- BG -->
<div id="bg"></div>

<!-- Scripts -->
<script src="js/jquery.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/util.js"></script>
<script src="js/main.js"></script>
<body>


	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">

			<div class="logo">
				<span class="icon fa-diamond"></span>
			</div>

			<div class="content">
				<div class="inner">
					<h1 id="camport">CAMPORT</h1>
					<p id="welcome">
						Welcome</a>
					</p>
				</div>
			</div>

			<%-- <c:if test="${empty id}"> --%>
			<form method="POST" action="/camport/login/loginok.do" id="frm">
				<nav>
					<ul>
						<li><input type="text" required="required" placeholder="ID"
							name="iid" id="iid" /></li>
						<li><input type="password" required="required"
							placeholder="PW" class="form-control" name="ppw" id="ppw" /></li>
					</ul>
					<li><a href="#contact" id="join">JOIN<img
							src="/camport/images/click.png"></a></li>


				</nav>
			</form>
			<%-- </c:if> --%>

			<%-- <c:if test="${!empty id}">
				
					<nav>
						<ul>
							<li>

							${id} 님 반갑습니다.
							</li>
						
						</ul>
						<li><a href="#contact" id="join">JOIN<img src="/camport/images/click.png"></a></li>
						


					</nav>
			
			</c:if> --%>


		</header>


		<!-- Main -->
		<div id="main">
			<!-- Contact -->
			<article id="contact">
				<h2 class="major">JOIN</h2>
				<form method="POST" action="/camport/login/joinok.do">

					<div class="field half first">
						<label for="email">ID(E-mail)</label> <input type="email"
							name="userId" id="userId" />
					</div>
					<div class="field half">
						<label for="password">PASSWORD</label> <input type="password"
							name="userPw" id="userPw" />
					</div>

					<div class="field half first">
						<label for="userName">NAME</label> <input type="text" name="userName"
							id="userName" />
					</div>

					<div class="field half">
						<label for="userTel">TEL</label> <input type="text" name="userTel"
							id="userTel" />
					</div>

					<div>


						<select id="universe" name="universe"
							onchange="ajaxCommList(event);">
							<option selected></option>
							<c:forEach items="${list}" var="dto">
								<option value="${dto.uniSeq}">${dto.uniName}</option>
							</c:forEach>
						</select> 
						<select id="collage" name="collage"
							onchange="ajaxCommList2(event);">
							<option selected></option>
						</select>
						 <select id="major" name="major">
							<option selected></option>
						</select>





					</div>



					<ul class="actions">
						<li><input type="submit" value="Complete" class="special" /></li>
						<li><input type="reset" value="Reset" /></li>
					</ul>
				</form>

			</article>




		</div>

		<!-- Footer -->
		<footer id="footer1">
			<p class="copyright">&copy; Untitled. CAMPORT</p>
		</footer>

	</div>



</body>
</html>
