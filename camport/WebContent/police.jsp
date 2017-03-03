<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 신고하기</title>

<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/> 
<meta http-equiv="Pragma" content="no-cache"/>

<%@include file="/inc/asset.jsp" %> <!-- css js -->

<style>

#mains{
	width:740px;
	margin:0 auto;
	margin-bottom:100px;
	border:0;
}
/* 게시글 신고 타이틀 */
#polices_title{
	padding:20px;
	background-color:#363434;
}
#polices_title h1{
	font-size:20px;
	font-weight:bold;
	color:#fff;
}
/* 신고 양식 설명글 */
#police_rule{
	width:100%;
	margin:0 auto;
	border-right:2px solid #000;
	border-left:2px solid #000;
	border-bottom:2px solid red;
}
#police_rule #text_rule{
	vertical-align: middle;
	padding:30px;
}
#select_checks{
	padding:30px;
}
#btnList{
	text-align:right;
}
</style>
<scirpt>

</scirpt>
</head>

<body>

	<div id="wrapper">
		<%@include file="/inc/top.jsp" %>
		<div id="mains">
			<div id="polices">
				<div class="alert alert-danger" role="alert" style="text-align:center;"><strong style="font-weight:bold; color:blue;">신고하기</strong>페이지입니다. <span style="font-weight:bold; color:red; font-size:18px;">게시판 내에서 이동</span>하시면 신고가 접수됩니다.</div>
				<div id="polices_title">
					<h1>게시글 신고하기</h1>
				</div>
				<div id="police_rule">
					<div id="text_rule">
						<p>이 글이 이용규칙 위반으로 관리자에 의해 삭제되어야한다고 생각되시면 신고해주세요.</p>
						<p>신고 10회 이상의 글은 삭제될 수 있습니다.</p>
						<p>이용규칙에 위배되는 글을 여러 차례 게시하여 신고를 많이 받은 회원은 삭제 및 제재가 있습니다.</p>
						<p>신고는 반대의견을 표시하는 기능이 아닙니다. 허의 신고는 징계처분이 있을 수 있습니다.</p>
						<p>신고에 부적합한 글을 지속적으로 신고하는 회원에게는 제한 조취가 취해질 수 있습니다.</p>
					</div>
					<div id="select_checks">
						<div class="checks">
	                      <input type="radio" id="ex_rd" name="ex_rds"> 
	                      <label for="ex_rd">욕설 및 제재(심한 불쾌감 유발)</label> 
	                    </div>
						<br>
						<div class="checks">
	                      <input type="radio" id="ex_rd2" name="ex_rds"> 
	                      <label for="ex_rd2">도배글, 낚시 (무의미한 짧은 글 포함)</label> 
	                    </div>
	                    <br>
	                    <div class="checks">
	                      <input type="radio" id="ex_rd2" name="ex_rds"> 
	                      <label for="ex_rd2">선정적, 음란물(신고자가 선정적이라고 판단)</label> 
	                    </div>
	                    <br>
	                    <div>
	                    	<textarea rows="3" cols="70" placeholder="상세하게 적으시오."></textarea>
	                    	<div id="btnList">
								<input type="button" value="게시글 신고" class="btn btn-primary"
										onclick="alert('신고가 완료되었습니다.')">
							</div>
	                    </div>
                    </div>
				</div>
			</div><!-- polices -->
		</div>
		<%@include file="/inc/Dark_footer.jsp" %>
	</div>

</body>
</html>



















