<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>

<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/> 
<meta http-equiv="Pragma" content="no-cache"/>

<%@include file="inc/asset.jsp" %>

<style>
	
#tbl1 { width: 850px; margin: 30px auto; }

#tbl1 th { width: 200px; text-align: center; }
#tbl1 td { width: 650px; }
#tbl1 #name, #tbl1 #tag, #tbl1 #pw { width: 150px; }
#tbl1 #content { height: 200px; }

#btnList { width: 850px; margin: 30px auto; }

#comment_style{
	width: 900px;
	margin: 0 auto;
	text-align:Center;
	font-weight:bold;
}
/* 댓글 alert */
#comment_style .rule_style strong{
	color:blue;
	font-weight:bold;
}	
#comment_style .rule_style{
	width: 900px;
	margin: 0 auto;
	text-align:Center;
	font-weight:bold;
	margin-top:10px;
	margin-bottom:10px;
}/* 댓글 alert END */

</style>
<script>
$(document).ready(function() {

	$("#tbl3 tr").on("mouseover", function() {
		$(this).children().last().children().last().show();
	});
	$("#tbl3 tr").on("mouseout", function() {
		$(this).children().last().children().last().hide();
	});

	if ($("#attachimg").width() > 600) {
		$("#attachimg").width(600);
	}
	
});

function delComment(reportCommentSeq, reportBoardSeq) {
	if (confirm("댓글을 삭제하겠습니까?")) {
		location.href = "/camport/delCommentOk.do?reportCommentSeq=" + reportCommentSeq + "&reportBoardSeq=" + reportBoardSeq;
	}
}
</script>
</head>
<body>

	<!-- view.jsp -->
	<div id="wrapper">
		<%@include file="/inc/top.jsp" %>
		<div id="middle">
			<div class="alert alert-info" style="text-align:center;" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  <strong>선택하신 글</strong>의 상세 페이지입니다.
			</div>
			<table id="tbl1" class="table table-striped">	
				<tr>
					<th>번호</th>
					<td>${dto.reportBoardSeq}</td>				
					<th>다운로드</th>
					<td>${dto.reportBoardDowncount}</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${dto.userId}</td>
					<th>조회수</th>
					<td>${dto.reportBoardReadcount}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3" name="subject" id="subject">${dto.reportBoardName}</td>
				</tr>
				<tr style="height: 300px;">
					<th style="vertical-align: middle;">내용</th>
					<td style="vertical-align: middle;" colspan="3">${dto.reportBoardContent}</td>
				</tr>
				<%-- <tr>
					<th>첨부파일</th>
					<td colspan="3">${dto.reportBoardFileName}</td>
				</tr> --%>
				<tr>
					<th style="vertical-align: middle;">소개글</th>
					<td colspan="3" style="height:150px; vertical-align: middle;">${dto.reportBoardSummary}</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td>${dto.reportBoardRegdate}</td>
					<th>포인트</th>
					<td>${dto.reportBoardPoint}</td>
				</tr>
				<tr>
					<th>암호</th>
					<td colspan="3">${dto.pw}</td>
				</tr>
			</table>
			<div id="btnList">
				<input type="button" value="돌아가기" class="btn btn-default"
						onclick="location.href='/camport/list.do';">
				<input type="button" value="수정하기" class="btn btn-primary"
						onclick="location.href='/camport/edit.do?reportBoardSeq=${dto.reportBoardSeq}';">
				<input type="button" value="삭제하기" class="btn btn-primary"
						onclick="location.href='/camport/del.do?reportBoardSeq=${dto.reportBoardSeq}';">
				<input type="button" value="게시글 신고" class="btn btn-primary"
						onclick="location.href='/camport/police.do?reportBoardSeq=${dto.reportBoardSeq}';">
			</div>
			<!-- button 종료 -->
			<div id="comment_style">
				<!-- 댓글 룰 alert -->
				<div class="alert alert-danger alert-dismissible rule_style" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<strong>댓글 규칙 : </strong>욕설, 비방, 도배글은 제재처리 및 삭제합니다.
				</div>
				<!-- 댓글쓰기 및 댓글목록 불러오기 -->
				<div id="addComment">
					<form method="POST" action="/camport/reportCommentOk.do">
						<table id="tbl2" class="table table-striped">
							<tr>
								<td>${dto.userId}</td>
								<td>
									<input type="text" name="reportCommentContent" id="content" required placeholder="댓글 내용" class="form-control">
								</td>
								<td>
									<input type="submit" value="댓글 쓰기" class="btn btn-info">
								</td>
							</tr>
						</table>
						<input type="hidden" name="reportBoardSeq" value="${dto.reportBoardSeq}">
						
					</form>
				</div>
				<div id="listComment">
					<table id="tbl3" class="table table-striped">
						<c:forEach items="${clist}" var="cdto">
						<tr>
							<td>${cdto.userId}</td>
							<td>${cdto.reportCommentContent}</td>
							<td>${cdto.reportCommentRegdate}</td>
							<td><input type="button" value=" x " class="btn btn-default btn-xs" style="float: right; display:none;" onclick="delComment(${cdto.reportCommentSeq}, ${dto.reportBoardSeq});"></td>
						</tr>
						</c:forEach>
					</table>
				</div><!-- listComment -->
			</div><!-- comment_style 영역값 및 스타일을 위한 div -->
		</div>
		<%@include file="/inc/Dark_footer.jsp" %>
	</div>

</body>
</html>



















