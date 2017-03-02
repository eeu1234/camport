<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Login Page</title>
<style>
body{text-align:center;background:#f8f8f8;}
*{margin:0; padding:0;}
a:link,a:visited,a:hover,a:active{text-decoration:none;}
h1{margin-top:50px;margin-bottom:20px;color:red; background:#eee;}
span{color:green;}
#wrap{width:700px;height:300px;border:1px solid #ddd;margin:auto;border-top:2px solid blue;}
form{margin-top:50px;}
input{font:13px arial; }
button{width:80px;float:right;margin-right:200px;margin-top:-55px;border:0;background:#0000ff;color:#fff;height:50px;line-height:50px;font-weight:bold;font:13px arial;}
a{font:13px arial;background:#3399ff;width:180px;height:35px;line-height:35px;display:inline-block;text-align:center;color:#fff;}
.register {width:100px;margin-left:12px;}
.login_data input{width:200px;height:20px;margin:3px 3px 3px -65px;border:1px solid #ddd;}
</style>
<script src="js/jquery-1.11.3.min.js"></script>

</head>
<body>
<h1>Welcome To <span>Camport</span></h1>
<div id="wrap">
<% if (session.getAttribute("reportBoardSeq") == null) { %>
<form method=post action="/camport/loginok.do">	
<!-- 	
	<input type="radio" name="job" value="job1" />학생
	<input type="radio" name="job" value="job3" />관리자<br />
-->
	<div class="login_data">
		<input type="text" name="email" required placeholder="이메일ID" /><p>
		<input type="password" name="password"  required placeholder="패스워드" /><p>
		<button type="submit" onclick="check_pw()">LOGIN</button>
	</div>	
</form>
<% } else { %>
<div><%= session.getAttribute("user_Name") %></div>
<div>[<%= session.getAttribute("user_Id") %>]</div>
<%-- <div><%= (boolean)session.getAttribute("isAdmin") ? "관리자" : "회원" %></div> --%>
<input type="button" value="logout" id="btnLogin" onclick="location.href='/camport/logoutok.do';">
<% } %>

<a href="register.jsp" class="register">회원가입</a>
<a href="infoSearch.jsp" >아이디/비밀번호 찾기</a>
</div>
<script>
//.login_data input:hover{font-weight:bold; color:blue; background:#5eb9ff; border:1px solid #a5cbfb;}
/*
Login버튼 클릭시 유효성 검사
-아이디(5자이상) -패스워드(반드시 특수문자 포함)~@!#$%^&* -버튼체크(선택이되어있는지)

radio 버튼 클릭시
-텍스트 컬러 파란색, 서체 두껍게
radio{color:blue; font-weight:bold}
input 상자에 마우스 올리면
-border, background, color 변경
*/
$('.login_data input').hover(function(){
		//마우스를 올렸을때
		$(this).css({'font-weight':'bold','color':'blue','background':'#5eb9ff','border':'1px solid #a5cbfb'});
	},function(){
		//마우스를 뺏을때
		$(this).css({'font-weight':'0','color':'#000','background':'#fff','border':'0'});
});
function check_pw(){
	var f = document.myform.password;
	var spacial = "~!@#%^&*_";
	var check = false;
	if(f.value.length<6){
		alert('비밀번호가 6자 이상 가능합니다.');
		f.value="";
		f.focus();
		return false;
	}
	for(i=0; i< spacial.length; i++){
		var output = f.value.indexOf(spacial[i]);
		// 해당문자열에 특수문자열이 있는지 확인
		console.log(output);
		if (output >= 0) check = true;
	}
	if (!check){
		alert("특수문자가 없습니다. 다시 입력하시오.");
		f.value="";
		f.focus();
	}else alert('사용가능 합니다.');
}
</script>	
</body>
</html>