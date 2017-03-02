<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FreeBoardview</title>

<meta http-equiv="Cache-Control" content="no-cache"/>   
<meta http-equiv="Expires" content="0"/>				
<meta http-equiv="Pragma" content="no-cache"/>

<%@include file="/inc/asset.jsp" %> 

<style>

#main {margin:0px auto; overflow: hidden; width:980px;}
#rightcontent {float:left; width:115px}
#main .centertbl, #tbl2, #addComment, #listComment {width:830px; float:right;}
#serchtbl{margin:0px auto;}
#btnList {float:right;}
#btnList input{ margin-left:3px; margin-bottom: 20px;}
#commentdate{font-size: 12px; float:right; }




</style>
<script>

$(document).ready(function() {

	$("#tbl3 tr").on("mouseover", function() {
		$(this).children().last().children().last().show();
	});
	$("#tbl3 tr").on("mouseout", function() {
		$(this).children().last().children().last().hide();
	});

});


function delComment(freeCommentSeq, freeBoardSeq) {
	if (confirm("댓글을 삭제하겠습니까?")) {
		location.href = "/camport/freeboard/freeboardcommentdelok.do?freeCommentSeq=" + freeCommentSeq + "&freeBoardSeq=" + freeBoardSeq;
	}
}




</script>
</head>
<body>
	
	<div id="wrapper" >
		<%@include file="/inc/top.jsp" %>
		<div id="main">
			<div class="panel panel-default">
			 <div class="panel-body">
			   무료서식 게시판 
			  </div>
			</div> 
			<div id="rightcontent" class="btn-group-vertical" role="group" aria-label="...">
					<div class="btn-group " role="group" > 
						<button type="button" class="btn btn-default " >
						서식
						</button>
					</div>
					<div class="btn-group" role="group">
	    				<button type="button" class="btn btn-default" >
	    				워드프로세서</button>
	  				</div>
					<div class="btn-group" role="group">
	    				<button type="button" class="btn btn-default">파워포인트</button>
	  				</div>
					<div class="btn-group" role="group">
	    				<button type="button" class="btn btn-default">한컴오피스</button>
	  				</div>
					<div class="btn-group" role="group">
	    				<button type="button" class="btn btn-default">MS 엑셀</button>
	  				</div>
					<div class="btn-group" role="group">
					    <button type="button" class="btn btn-default">기타서식</button>
					</div>
				</div>
			<table id="freetbl" class="table centertbl" >
				 <tr>
					<td>
						<p style="font-size:15px;"> 글제목: ${dto.freeBoardName}  </p> 
						<p style="font-size: 12px; font:bold;">
						<span>작성자:${dto.userId}</span>&nbsp;&nbsp;&nbsp;|
						<span>조회:${dto.freeBoardReadcnt}</span>&nbsp;&nbsp;&nbsp;|
						<span>날짜:${dto.freeBoardRegdate}</span>
						</p>	
					</td>			
				<tr style="height: 250px;">
					<td>
						<p> < 소개글 > </p>
						<p>&nbsp;</p>
						<p>${dto.freeBoardContent}</p>
					</td>		
				</tr>
				<tr>
					<td >다운로드 파일_ file <span style="font-size:12px;"> [${dto.freeBoardDawncount}]</span> </td>
				</tr>
			</table>
			<div id="btnList">
		
			<input type="button" value="돌아가기" class="btn btn-default"
					onclick="location.href='/camport/freeboard/freeboardlist.do<%-- ?name=${freeboardname}&word=${word} --%>';">
					
			<input type="button" value="수정하기" class="btn btn-primary"
					onclick="location.href='/camport/freeboard/freeboardedit.do?freeBoardSeq=${dto.freeBoardSeq}';">
			<input type="button" value="삭제하기" class="btn btn-primary"
					onclick="location.href='/camport/freeboard/freeboarddel.do?freeBoardSeq=${dto.freeBoardSeq}';">
			<%-- 		
			<input type="button" value="답변쓰기" class="btn btn-primary"
					onclick="location.href='/camport/freeboard/freeboardadd.do?mode=reply&freeBoardSeq=${dto.freeBoardSeq}';">
			 	  --%>
		</div><!-- btnList -->
		
		<div id="addComment">
			<form method="POST" action="/camport/freeboard/freeboardcommentok.do">
				<table id="tbl2" class="table table-striped">
					<tr>
						<td>
							${id}
						</td>
						<td  style="width: 580px;">
							<input type="text" name="freeCommentContent" id="content" required placeholder="댓글 내용" class="form-control">
						</td>
						<td>
						
						<input type="hidden" name="freeBoardSeq" value="${dto.freeBoardSeq}" />
							<input type="submit" value="댓글 쓰기" class="btn btn-info">
						</td>
					</tr>
				</table>
			 <input type="hidden" name="userId" value="${id}"> 
				
			</form>
		</div><!-- addComment -->
		<div id="listComment" style="width:830px; margin:0px auto;">
				<table id="tbl3" class="table table-striped">
					<c:forEach items="${clist}" var="cdto">
					<tr> 
						<td>${cdto.userId}</td>
						<td  style="width: 830px; text-align:left; ">
							${cdto.freeCommentContent} <span id="commentdate" >(${cdto.freeCommentRegdate})</span>
						</td>
						<td>
							<input type="button" value=" x "
								class="btn btn-default btn-xs"
								style="float: right; display:none;" 
								 onclick="delComment(${cdto.freeCommentSeq}, ${dto.freeBoardSeq});"> 
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		
		</div><!-- main   -->
	</div>

		<%-- <%@include file="/inc/bottom.jsp" %>  --%>

</body>
</html>